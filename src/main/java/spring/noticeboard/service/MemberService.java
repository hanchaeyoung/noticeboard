package spring.noticeboard.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import spring.noticeboard.domain.Member;
import spring.noticeboard.dto.MemberDto;
import spring.noticeboard.entity.MemberEntity;
import spring.noticeboard.repository.MemberRepository;
import spring.noticeboard.repository.MemberRepository1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class MemberService implements UserDetailsService {

    private MemberRepository1 memberRepository1;

    @Transactional
    public Long signup(MemberDto memberDto) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));

        return memberRepository1.save(memberDto.toEntity()).getId();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<Member> memberWrapper = memberRepository1.findByEmail(email);
        Member member = memberWrapper.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        if ("admin@naver.com".equals(email)) {
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        }

        return new User(member.getEmail(), member.getPassword(), authorities);

//        Optional<Member> memberWrapper = memberRepository1.findByEmail(email);
//
//        if (memberWrapper.isPresent()) {
//            Member member = memberWrapper.get();
//
//            List<GrantedAuthority> authorities = new ArrayList<>();
//
//            if ("admin".equals(email)) {
//                authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
//            } else {
//                authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
//            }
//
//            return new User(member.getEmail(), member.getPassword(), authorities);
//        } else {
//            throw new UsernameNotFoundException("User not found with email : " + email);
//        }
    }
}
