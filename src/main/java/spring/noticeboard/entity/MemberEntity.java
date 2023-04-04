package spring.noticeboard.entity;

import lombok.*;
import javax.persistence.*;

@Entity(name = "member_entity")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String password;
    private String username;

   @Builder
    public MemberEntity(Long id, String email, String password, String username) {
       this.id = id;
       this.email = email;
       this.password = password;
       this.username = username;
   }
}





//@Entity
//@Table(name = "member_entity")
//public class UserEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String email;
//    private String password;
//    private String username;
//
//    public UserEntity() {}
//
//    public UserEntity(Long id, String email, String password, String username) {
//        this.id = id;
//        this.email = email;
//        this.password = password;
//        this.username = username;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//}