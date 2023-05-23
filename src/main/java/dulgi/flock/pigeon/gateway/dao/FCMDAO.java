package dulgi.flock.pigeon.gateway.dao;

import dulgi.flock.pigeon.gateway.model.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FCMDAO {

    private final JdbcTemplate jdbcTemplateToken;

    @Autowired
    public FCMDAO(JdbcTemplate jdbcTemplateToken) {
        this.jdbcTemplateToken = jdbcTemplateToken;
    }

    public void insertNewToken(String uuID, String token, String registeredTime) {
        jdbcTemplateToken.execute("INSERT INTO sj_practice VALUES ('" + uuID + "', '" + token + "', '" + registeredTime + "');");
    }

    public List<Token> getTokens(){
        RowMapper<Token> mapper = new RowMapper<Token>() {
            @Override
            public Token mapRow(ResultSet rs, int rowNum) throws SQLException {
                return Token.builder()
                        .uuid(rs.getString("uuid"))
                        .token(rs.getString("token"))
                        .registeredTime(rs.getString("registeredTime"))
                        .build();
            }
        };
        return jdbcTemplateToken.query("select * from sj_practice", mapper);
    }

}
