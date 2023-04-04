package spring.noticeboard.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.noticeboard.entity.MemberEntity;

@Getter
@Setter
@NoArgsConstructor
public class MemberDto {

    private Long id;
    private String email;
    private String password;
    private String username;

    public MemberEntity toEntity() {
        return MemberEntity.builder()
                .id(id)
                .email(email)
                .password(password)
                .username(username)
                .build();
    }

    @Builder
    public MemberDto(Long id, String email, String password, String username) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
    }
}
