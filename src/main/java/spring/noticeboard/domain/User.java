package spring.noticeboard.domain;

import spring.noticeboard.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class User {

    private Long userIdx;

    private String email;

    private String password;

    private String name;

    private int grade;

    private Date registerTime;

    private Date lastLoginTime;

    private boolean withrawed;

    private Date withdrawTime;

    public static User build(String email, String password, String name, int grade) {
        User user = new User();

        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        user.setGrade(grade);

        return user;
    }

    public static User build(UserEntity entity) {
        User user = new User();

        user.setUserIdx(entity.getUserIdx());
        user.setEmail(entity.getEmail());
        user.setPassword(entity.getPassword());
        user.setName(entity.getName());
        user.setGrade(entity.getGrade());
        user.setRegisterTime(entity.getRegisterTime());
        user.setLastLoginTime(entity.getLastLoginTime());
        user.setWithrawed(entity.isWithrawed());
        user.setWithdrawTime(entity.getWithdrawTime());

        return user;
    }
}

