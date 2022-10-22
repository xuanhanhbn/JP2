package Library.dao.impls;

import Library.dao.interfaces.IBookManagerRepository;
import Library.dao.interfaces.IRepository;
import Library.entities.BookManager;
import Library.entities.Student;
import Library.helper.Connector;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookManagerRepository implements IRepository<BookManager> {

    @Override
    public ArrayList<BookManager> all() {
        ArrayList<BookManager> bm = new ArrayList<>();
//        try {
//            String sql_txt = "select * from BookRents";
//            Connector conn = Connector.getInstance();
//            ResultSet rs = conn.query(sql_txt);
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String nameStudent = rs.getString("nameStudent");
//                String nameBook = rs.getString("nameBook");
//                Date exDate = rs.getDate("exDate");
//                BookManager bookManager = new BookManager(id,nameStudent,nameBook,exDate);
//                bm.add(bookManager);
//            }
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//        return bm;
        return null;
    }

    @Override
    public boolean create(BookManager bookManager) {
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

    @Override
    public BookManager findOne(Integer id) {
        return null;
    }
}
