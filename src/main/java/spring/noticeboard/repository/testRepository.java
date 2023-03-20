package spring.noticeboard.repository;

import org.springframework.jdbc.core.JdbcTemplate;

public class testRepository {
    private final JdbcTemplate jdbcTemplate;

    public testRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void sampleQuery() {
        jdbcTemplate.query("SELECT * FROM sample_table", rs -> {
            String name = rs.getString("name");
            int age = rs.getInt("age");
            // do something with name and age
        });
    }
}
