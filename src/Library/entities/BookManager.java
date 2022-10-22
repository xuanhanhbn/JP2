package Library.entities;

import Library.dao.impls.BookRepository;
import Library.enums.RepositoryType;
import Library.factory.RepositoryFactory;

import java.util.Date;

public class BookManager {
    private Integer id;
    private Integer bookID;
    private Integer studentID;
    private Date renDate;
    private Date expireDate;
    private Integer status;

    public BookManager() {
    }

    public BookManager(Integer id, Integer bookID, Integer studentID, Date renDate, Date expireDate, Integer status) {
        this.id = id;
        this.bookID = bookID;
        this.studentID = studentID;
        this.renDate = renDate;
        this.expireDate = expireDate;
        this.status = status;
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

    public void setRenDate(Date renDate) {
        this.renDate = renDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public void setStatus(Integer status) {
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

    public Date getRenDate() {
        return renDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public Integer getStatus() {
        return status;
    }

    public Book book(){
        return ((BookRepository) RepositoryFactory.createRepository(RepositoryType.BOOK)).findOne(this.getBookID());
    }
}
