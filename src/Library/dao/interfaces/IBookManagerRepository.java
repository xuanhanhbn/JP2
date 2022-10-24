package Library.dao.interfaces;

import Library.entities.Book;
import Library.entities.BookManager;
import Library.entities.Student;

import java.util.ArrayList;

public interface IBookManagerRepository {
    ArrayList<BookManager> all();
    boolean create(BookManager bookManager);
    boolean update(BookManager bookManager);
    boolean delete(BookManager bookManager);
    Book findOne(Integer id);
}
