package spring.noticeboard.entity;

import spring.noticeboard.domain.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "user_entity")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userIdx;

    private String email;

    private String password;

    @Column(length = 100, nullable = false)
    private String name;

    private int grade;

    private Date registerTime;

//    private Date lastLoginTime;

    private boolean withrawed;

//    private Date withdrawTime;

    public static UserEntity build(User user) {
        UserEntity entity = new UserEntity();

        entity.setUserIdx(user.getUserIdx());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        entity.setName(user.getName());
        entity.setGrade(user.getGrade());
        entity.setRegisterTime(user.getRegisterTime());
//        entity.setLastLoginTime(user.getLastLoginTime());
        entity.setWithrawed(user.isWithrawed());
//        entity.setWithdrawTime(user.getWithdrawTime());

        return entity;
    }

}
