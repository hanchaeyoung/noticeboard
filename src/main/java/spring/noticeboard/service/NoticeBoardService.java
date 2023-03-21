package spring.noticeboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.noticeboard.entity.NoticeBoardEntity;
import spring.noticeboard.repository.NoticeBoardRepository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service(value = "noticeBoardService")
public class NoticeBoardService {
    private NoticeBoardRepository noticeBoardRepository;

    @Autowired
    public void setNoticeBoardRepository(NoticeBoardRepository noticeBoardRepository) { this.noticeBoardRepository = noticeBoardRepository; }

//    @PostConstruct
//    public void prepare() {
//        addWrite("제목 1", "내용 1", "글쓴이 1");
//        addWrite("제목 2", "내용 2", "글쓴이 2");
//        addWrite("제목 3", "내용 3", "글쓴이 3");
//    }

    public void addWrite(String title, String contents, String writer) {
        NoticeBoardEntity write = new NoticeBoardEntity();
        write.setTitle(title);
        write.setContents(contents);
        write.setWriter(writer);
        write.setTime(String.valueOf(LocalDate.now()));
        write.setReadCount(0);

        noticeBoardRepository.save(write);
    }

    public void updateReadCount(Optional<NoticeBoardEntity> optional) {
        optional.ifPresent(id -> {
            id.setReadCount(optional.get().getReadCount() + 1);
            System.out.println(optional.get().getReadCount());
            noticeBoardRepository.save(id);
        });
    }

    public NoticeBoardEntity readPost(Long idx) {
        Optional<NoticeBoardEntity> optional = noticeBoardRepository.findById(idx);
        if (optional.isPresent()) {
            updateReadCount(optional);
            return optional.get();
        } else {
            throw new IllegalArgumentException("존재하지 않는 게시글입니다.");
        }
    }
    public List<NoticeBoardEntity> list() {
        List<NoticeBoardEntity> list = noticeBoardRepository.findAll();
        return list;
    }
}
