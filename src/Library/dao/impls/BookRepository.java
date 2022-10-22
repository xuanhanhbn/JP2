package Library.dao.impls;

import Library.dao.interfaces.IBookRepository;
import Library.dao.interfaces.IRepository;
import Library.entities.Book;
import Library.helper.Connector;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class BookRepository implements IRepository<Book> {

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
        try {
            String sql_txt  = "insert into Book(name, author, qty) values(?,?,?)";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(book.getName());
            arr.add(book.getAuthor());
            arr.add(book.getQty());

            if (conn.executeAdd(sql_txt,arr)) {
                return true;
            }
        } catch (Exception e){

        }

        return false;
    }

    @Override
    public boolean update(Book book) {
        try {
            String sql_txt  = " UPDATE Book SET name = ?, author = ?, qty = ? WHERE id = ?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(book.getName());
            arr.add(book.getAuthor());
            arr.add(book.getQty());
            arr.add(book.getId());

            if (conn.executeAdd(sql_txt,arr)) {
                return true;
            }
        } catch (Exception e){

        }
        return false;
    }

    @Override
    public boolean delete(Book book) {
        try {
            String sql_txt  = "DELETE FROM `Book` WHERE id = ?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(book.getId());
            if (conn.executeAdd(sql_txt,arr)) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public Book findOne(Integer id) {
        try{
            String sql_txt  = "SELECT * FROM `Book` WHERE id = ?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(id);
            ResultSet rs = conn.executeLook(sql_txt,arr);
            while (rs.next()){
                int Id = rs.getInt("id");
                String name = rs.getString("name");
                String author = rs.getString("author");
                int qty = rs.getInt("qty");
               return new Book(Id,name,author,qty);
            }
        } catch (Exception e){

        }
        return null;
    }
}
