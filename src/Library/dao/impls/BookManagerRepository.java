package Library.dao.impls;

import Library.dao.interfaces.IBookManagerRepository;
import Library.entities.BookManager;
import Library.entities.Student;
import Library.helper.Connector;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookManagerRepository implements IBookManagerRepository {
    @Override
    public ArrayList<BookManager> all() {
        ArrayList<BookManager> bm = new ArrayList<>();
        try {
            String sql_txt = "select * from BookRents";
            Connector conn = Connector.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nameStudent = rs.getString("nameStudent");
                String nameBook = rs.getString("nameBook");
                Date exDate = rs.getDate("exDate");
                BookManager bookManager = new BookManager(id,nameStudent,nameBook,exDate);
                bm.add(bookManager);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return bm;
    }

    @Override
    public boolean create(BookManager bookManager) {
        try {
            String sql_txt  = "insert into BookRents(name) values(?,?,?)";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(bookManager.getNameBook());
            arr.add(bookManager.getNameStudent());
            arr.add(bookManager.getExDate());

            if (conn.executeAdd(sql_txt,arr)) {
                return true;
            }
        } catch (Exception e){

        }

        return false;
    }

    @Override
    public boolean update(BookManager bookManager) {
        return false;
    }

    @Override
    public boolean delete(BookManager bookManager) {
        return false;
    }
}
