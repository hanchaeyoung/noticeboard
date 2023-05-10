package spring.noticeboard.repository;

import spring.noticeboard.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

//    public Optional<UserEntity> findByEmail(String email);

    public Optional<UserEntity> findById(String id);
}

