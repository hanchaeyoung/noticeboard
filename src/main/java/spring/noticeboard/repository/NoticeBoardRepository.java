package spring.noticeboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.noticeboard.entity.NoticeBoardEntity;

public interface NoticeBoardRepository extends JpaRepository<NoticeBoardEntity, Long> {

}
