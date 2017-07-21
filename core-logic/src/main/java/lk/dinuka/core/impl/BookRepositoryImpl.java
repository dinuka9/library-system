package lk.dinuka.core.impl;

import lk.dinuka.core.BookRepository;
import lk.dinuka.core.domain.DomainBook;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
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
        String sql = "SELECT * FROM book WHERE bookId = "+bookId;
        DomainBook book = jdbcTemplate.query(sql, new DomainBookMapper()).get(0);
        return book;
    }

    @Override
    public void deleteBookById(int bookId) {
        String sql = "DELETE FROM book WHERE bookId = "+bookId;
        jdbcTemplate.execute(sql);
    }

    @Override
    public void deleteAllBooks() {
        String sql = "truncate table book;";
        jdbcTemplate.execute(sql);
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

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

}
