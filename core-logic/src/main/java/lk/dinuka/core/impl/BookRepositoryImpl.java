package lk.dinuka.core.impl;

import lk.dinuka.core.BookRepository;
import lk.dinuka.core.domain.DomainBook;
import lk.dinuka.core.domain.DomainUser;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dinuka on 7/19/17.
 */
public class BookRepositoryImpl implements BookRepository {
    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveBook(DomainBook domainBook) {
        String query = "INSERT INTO book (bookId, bookName, bookType, bookAuthor) " +
                       "VALUES ('"+domainBook.getBookId()+"','"+domainBook.getBookName()+"','"
                                  +domainBook.getBookType()+"','"+domainBook.getBookAuthor()+"');";

        jdbcTemplate.update(query);
    }

    @Override
    public List<DomainBook> getAllBooks() {
        String sql = "SELECT * FROM book";

        List<DomainBook> books = jdbcTemplate.query(sql, new DomainBookMapper());

        return books;
    }

    @Override
    public DomainBook getBookById(int bookId) {
        String sql = "SELECT * FROM book WHERE bookId = ?";
        DomainBook book = null;
        return book;
    }

    @Override
    public void deleteBookById(int bookId) {
        String sql = "DELETE FROM book WHERE bookId = ?";

    }

    @Override
    public void deleteAllBooks() {

    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final class DomainBookMapper implements RowMapper<DomainBook> {

        public DomainBook mapRow(ResultSet rs, int rowNum) throws SQLException {
            DomainBook book = new DomainBook(rs.getInt("bookId"),
                                            rs.getString("bookName"),
                                            rs.getString("bookType"),
                                            rs.getString("bookAuthor"));
            return book;
        }
    }
}
