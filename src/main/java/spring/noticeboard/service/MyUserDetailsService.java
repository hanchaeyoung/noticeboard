package spring.noticeboard.service;

import spring.noticeboard.domain.MyUserDetails;
import spring.noticeboard.domain.User;
import spring.noticeboard.repository.BoardRepository;
import spring.noticeboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(value = "userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    private UserService userService;

    private BoardRepository boardRepository;
    private UserRepository userRepository;

    /*임시계정(admin) 생성*/
//    @PostConstruct
//    public void prepare() {
//        User user = User.build("admin", "1234", "관리자", 9);
//
//        userService.add(user);
//    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        try {
            User user = userService.read(username);
            return new MyUserDetails(user);
        } catch (IllegalArgumentException e) {
            throw new UsernameNotFoundException(username);
        }
    }
}
