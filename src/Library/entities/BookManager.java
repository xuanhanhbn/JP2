package Library.entities;

import java.sql.Date;

public class BookManager {
    public Integer id;
    public String nameStudent, nameBook;
    public Date ExDate;

    public BookManager(Integer id, String nameStudent, String nameBook, Date exDate) {
        this.id = id;
        this.nameStudent = nameStudent;
        this.nameBook = nameBook;
        ExDate = exDate;
    }

    public Integer getId() {
        return id;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public String getNameBook() {
        return nameBook;
    }

    public Date getExDate() {
        return ExDate;
    }
}
