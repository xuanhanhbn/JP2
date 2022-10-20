package Library.entities;

public class Book {
    public Integer id;
    public String name;
    public String author;
    public Integer qty;

    public Book(Integer id, String name, String author, Integer qty) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.qty = qty;
    }

    public Book() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}
