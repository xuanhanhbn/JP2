package Library.entities;

import Library.dao.impls.BookRepository;
import Library.dao.impls.StudentRepository;
import Library.enums.RepositoryType;
import Library.factory.RepositoryFactory;

import java.util.Date;

public class BookManager {
    private Integer id;
    private Integer bookID;
    private Integer studentID;
    private Date rentDate;
    private Date expireDate;
    private String status;
    private String bookName;
    private String studentName;


    public BookManager() {
    }

    public BookManager(Integer id, Integer bookID, Integer studentID, Date rentDate, Date expireDate, String status) {
        this.id = id;
        this.bookID = bookID;
        this.studentID = studentID;
        this.rentDate = rentDate;
        this.expireDate = expireDate;
        this.status = status;
    }

    public String getBookName() {
        return this.book().getName();
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getStudentName(){
        return this.student().getName();
    }
    public void setStudentName(String studentName){
        this.studentName = studentName;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public Integer getBookID() {
        return bookID;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public String getStatus() {
        return status;
    }

    public Book book(){
        return ((BookRepository) RepositoryFactory.createRepository(RepositoryType.BOOK)).findOne(this.getBookID());
    }
    public Student student(){
        return (Student) RepositoryFactory.createRepository(RepositoryType.STUDENT).findOne(this.getStudentID());
    }
}

