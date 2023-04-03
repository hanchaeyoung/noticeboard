package spring.noticeboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.noticeboard.entity.UserEntity;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    // MemberEntity findByEmail(String email);
    List<UserEntity> findAll();
    // List<MemberEntity> getAllMembers();
    // MemberEntity findByUsername(String username);
}
