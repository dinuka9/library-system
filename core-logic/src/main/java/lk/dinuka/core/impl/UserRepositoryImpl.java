package lk.dinuka.core.impl;

import lk.dinuka.core.UserRepository;
import lk.dinuka.core.domain.DomainUser;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by dinuka on 7/19/17.
 */
public class UserRepositoryImpl implements UserRepository {
    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveUser(DomainUser domainUser) {
        String query = "INSERT INTO user (userId, memberType, userName, userEmail) " +
                "VALUES ('" + domainUser.getUserId() + "','" + domainUser.getMemberType() + "','" +
                domainUser.getUserName() + "','" + domainUser.getUserEmail() + "');";

        jdbcTemplate.update(query);
    }

    @Override
    public List<DomainUser> getAllUsers() {
        String sql = "SELECT * FROM user";

        List<DomainUser> users = jdbcTemplate.query(sql, new DomainUserMapper());

        return users;
    }

    @Override
    public DomainUser getUserById(int userId) {
        String sql = "SELECT * FROM user WHERE userId = " + userId;
        DomainUser user = jdbcTemplate.query(sql, new DomainUserMapper()).get(0);
        return user;
    }

    @Override
    public void deleteUserById(int userId) {
        String sql = "DELETE FROM user WHERE userId = "+userId;
        jdbcTemplate.execute(sql);
    }

    @Override
    public void deleteAllUsers() {
        String sql = "truncate table user;";
        jdbcTemplate.execute(sql);
    }

    private static final class DomainUserMapper implements RowMapper<DomainUser> {

        public DomainUser mapRow(ResultSet rs, int rowNum) throws SQLException {
            DomainUser user = new DomainUser(rs.getInt("userId"), rs.getString("userName"),
                    rs.getString("userEmail"),
                    rs.getString("memberType"));
            return user;
        }
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
