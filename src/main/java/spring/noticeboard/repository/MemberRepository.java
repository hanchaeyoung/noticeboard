package spring.noticeboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.noticeboard.entity.MemberEntity;

import java.util.List;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    // MemberEntity findByEmail(String email);
    List<MemberEntity> findAll();
}
