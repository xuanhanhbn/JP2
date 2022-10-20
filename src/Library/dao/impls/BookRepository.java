package Library.dao.impls;

import Library.dao.interfaces.IBookRepository;
import Library.entities.Book;
import Library.helper.Connector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class BookRepository implements IBookRepository {
    @Override
    public ArrayList<Book> all() {
        ArrayList<Book> ls = new ArrayList<>();
        try {
            String sql_txt = "select * from Book";
            Connector conn = Connector.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String author = rs.getString("author");
                int qty = rs.getInt("qty");
                Book b = new Book(id, name, author, qty);
                ls.add(b);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return ls;
    }

    @Override
    public boolean create(Book book) {
            String sql_txt  = "insert into Book(name, author, qty) values(?,?,?)";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(book.getName());
            arr.add(book.getAuthor());
            arr.add(book.getQty());

            if (conn.executeAdd(sql_txt,arr)) {
                return true;
            }
        return false;
    }

    @Override
    public boolean update(Book book) {

        String sql_txt  = " UPDATE `Book` SET `name`='[value-2]',`author`='[value-3]',`qty`='[value-4]' WHERE 1";
        Connector conn = Connector.getInstance();
        ArrayList arr = new ArrayList();
        arr.add(book.getName());
        arr.add(book.getAuthor());
        arr.add(book.getQty());

        if (conn.executeAdd(sql_txt,arr)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Book book) {
        return false;
    }
}
