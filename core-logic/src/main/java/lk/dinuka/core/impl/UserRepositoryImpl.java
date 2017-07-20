package lk.dinuka.core.impl;

import lk.dinuka.core.UserRepository;
import lk.dinuka.core.domain.DomainUser;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dinuka on 7/19/17.
 */
public class UserRepositoryImpl implements UserRepository {
    private DriverManagerDataSource dataSource;

    @Override
    public void saveUser(DomainUser domainUser) {
        String sql = "INSERT INTO user (userId, memberType, userName, userEmail) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, domainUser.getUserId());
            ps.setString(2, domainUser.getMemberType());
            ps.setString(3, domainUser.getUserName());
            ps.setString(4, domainUser.getUserEmail());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public List<DomainUser> getAllUsers() {
        String sql = "SELECT * FROM user";
        List<DomainUser> userList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                DomainUser domainUser = new DomainUser( rs.getInt("userId"),
                                                        rs.getString("userName"),
                                                        rs.getString("userEmail"),
                                                        rs.getString("memberType"));

                userList.add(domainUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public DomainUser getUserById(int userId) {
        String sql = "SELECT * FROM user WHERE userId = ?";
        Connection conn = null;
        DomainUser user = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new DomainUser(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                );
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
        return user;
    }

    @Override
    public void deleteUserById(int userId) {
        String sql = "DELETE FROM user WHERE userId = ?";
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.execute();
            ps.close();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public void deleteAllUsers() {

    }

    public DriverManagerDataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
    }
}
