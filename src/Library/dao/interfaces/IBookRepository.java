package Library.dao.interfaces;


import Library.entities.Book;

import java.util.ArrayList;

public interface IBookRepository {
    ArrayList<Book> all();
    boolean create(Book book);
    boolean update(Book book);
    boolean delete(Book book);
}
