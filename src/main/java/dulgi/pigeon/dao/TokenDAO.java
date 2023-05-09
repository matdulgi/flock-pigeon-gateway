package dulgi.pigeon.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TokenDAO {

    private final JdbcTemplate jdbcTemplateToken;

    @Autowired
    public TokenDAO (JdbcTemplate jdbcTemplateToken) {
        this.jdbcTemplateToken = jdbcTemplateToken;
    }

    public void insertNewToken(String uuID, String token, String registeredTime) {
        jdbcTemplateToken.execute("INSERT INTO sj_practice VALUES ('" + uuID + "', '" + token + "', '" + registeredTime + "');");
    }

}
