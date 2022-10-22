package Library.dao.interfaces;

import Library.entities.Student;

import java.util.ArrayList;

public interface IStudentRepository {
    ArrayList<Student> all();
    boolean create(Student student);
    boolean update(Student student);
    boolean delete(Student student);
}
