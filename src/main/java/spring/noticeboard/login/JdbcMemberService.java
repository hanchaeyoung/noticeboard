package spring.noticeboard.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import spring.noticeboard.entity.MemberEntity;

import javax.sql.DataSource;
import java.util.List;

@Service
public class JdbcMemberService implements MemberService {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public MemberEntity authenticateUser(String username, String password) {
        String sql = "SELECT * FROM member_entity WHERE username = ?";
        RowMapper<MemberEntity> rowMapper = new BeanPropertyRowMapper<>(MemberEntity.class);
        List<MemberEntity> users = jdbcTemplate.query(sql, rowMapper, username);
        if (users.isEmpty()) {
            return null;
        } else {
            MemberEntity memberEntity = users.get(0);
            if (password.equals(memberEntity.getPassword())) {
                return memberEntity;
            } else {
                return null;
            }
        }
    }
}
