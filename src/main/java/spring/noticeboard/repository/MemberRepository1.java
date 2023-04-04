package spring.noticeboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.noticeboard.domain.Member;

import java.util.Optional;

public interface MemberRepository1 extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
}
