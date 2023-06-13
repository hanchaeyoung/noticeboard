package spring.noticeboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.noticeboard.entity.BoardEntity;
import spring.noticeboard.entity.CommentEntity;
import spring.noticeboard.entity.UserEntity;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    List<CommentEntity> findByBoardId(Long no);
//    List<CommentEntity> findByBoard(BoardEntity board);
//    List<CommentEntity> findByUser(UserEntity name);
}