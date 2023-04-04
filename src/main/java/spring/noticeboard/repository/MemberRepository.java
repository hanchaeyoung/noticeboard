package spring.noticeboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.noticeboard.entity.MemberEntity;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    Optional<MemberEntity> findByEmail(String email); //
    List<MemberEntity> findAll();
    // List<MemberEntity> getAllMembers();
    // MemberEntity findByUsername(String username);
    // UserEntity findByEmail(String email);
}
