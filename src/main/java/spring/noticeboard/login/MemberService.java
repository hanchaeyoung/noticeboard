package spring.noticeboard.login;

import spring.noticeboard.entity.MemberEntity;

public interface MemberService {

    /**
     * 입력된 아이디와 비밀번호로 사용자 인증을 수행합니다.
     * @param username 유저이름
     * @param password 비밀번호
     * @return 인증된 사용자 정보. 인증에 실패하면 null을 반환합니다.
     */
    MemberEntity authenticateUser(String username, String password);
}
