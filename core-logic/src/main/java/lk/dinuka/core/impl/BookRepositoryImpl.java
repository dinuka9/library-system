package lk.dinuka.core.impl;

import lk.dinuka.core.BookRepository;
import lk.dinuka.core.domain.DomainBook;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dinuka on 7/19/17.
 */
public class BookRepositoryImpl implements BookRepository {
    private DriverManagerDataSource dataSource;

    @Override
    public void saveBook(DomainBook domainBook) {
        String sql = "INSERT INTO book (bookId, bookName, bookType, bookAuthor) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, domainBook.getBookId());
            ps.setString(2, domainBook.getBookName());
            ps.setString(3, domainBook.getBookType());
            ps.setString(4, domainBook.getBookAuthor());
            ps.executeUpdate();
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
    public List<DomainBook> getAllBooks() {
        String sql = "SELECT * FROM book";
        List<DomainBook> bookList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                DomainBook domainBook = new DomainBook(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4));

                bookList.add(domainBook);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    @Override
    public DomainBook getBookById(int bookId) {
        String sql = "SELECT * FROM book WHERE bookId = ?";
        Connection conn = null;
        DomainBook book = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, bookId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                book = new DomainBook(rs.getInt(1),
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
        return book;
    }

    @Override
    public void deleteBookById(int bookId) {
        String sql = "DELETE FROM book WHERE bookId = ?";
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, bookId);
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
    public void deleteAllBooks() {

    }

    public void setDataSource(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
    }
}
