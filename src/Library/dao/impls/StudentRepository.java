package Library.dao.impls;

import Library.dao.interfaces.IRepository;
import Library.dao.interfaces.IStudentRepository;
import Library.entities.Book;
import Library.entities.Student;
import Library.helper.Connector;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StudentRepository implements IRepository<Student> {
    @Override
    public ArrayList<Student> all() {
        ArrayList<Student> st = new ArrayList<>();
        try {
            String sql_txt = "select * from Student";
            Connector conn = Connector.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String tel = rs.getString("tel");
                Student s = new Student(id,name,email,tel);
                st.add(s);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return st;
    }

    @Override
    public boolean create(Student student) {
        try {
            if (!student.getEmail().contains("@") || student.getEmail().startsWith("@")
                    || student.getEmail().endsWith("@") || !student.getTel().startsWith("0")) {
                throw new Exception("Error");
            }
            String sql_txt = "insert into Student(name, email, tel) values(?,?,?)";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(student.getName());
            arr.add(student.getEmail());
            arr.add(student.getTel());
            if (conn.executeAdd(sql_txt, arr)) {
                return true;
            } else{
                System.out.println("Error");
            }
        } catch(Exception e){
        }
        return false;
    }

    @Override
    public boolean update(Student student) {
        try {
            String sql_txt  = " UPDATE Student SET name = ?, email = ?, tel = ? WHERE id = ?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(student.getName());
            arr.add(student.getEmail());
            arr.add(student.getTel());
            arr.add(student.getId());

            if (conn.executeAdd(sql_txt,arr)) {
                return true;
            }
        } catch (Exception e){

        }
        return false;
    }

    @Override
    public boolean delete(Student student) {
        try {
            String sql_txt  = "DELETE FROM `Student` WHERE id = ?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(student.getId());
            if (conn.executeAdd(sql_txt,arr)) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public Student findOne(Integer id) {
        try{
            String sql_txt  = "SELECT * FROM `Student` WHERE id = ?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(id);
            ResultSet rs = conn.executeLook(sql_txt,arr);
            while (rs.next()){
                int Id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String tel = rs.getString("tel");
                return new Student(Id,name,email,tel);
            }
        } catch (Exception e){

        }
        return null;

    }
}
