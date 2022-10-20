package Library.entities;

import Library.edit.editBookController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import ss1.Main;

public class Book {
    public Integer id;
    public String name;
    public String author;
    public Integer qty;
    public Button edit;

    public Book(Integer id, String name, String author, Integer qty) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.qty = qty;
        this.edit = new Button("Edit");
        this.edit.setOnAction((event -> {
            try{
                editBookController.editedBook = this;

                Parent edit = FXMLLoader.load(this.getClass().getResource("../edit/editBook.fxml"));
                Library.Main.rootStage.setTitle("edit");
                Library.Main.rootStage.setScene(new Scene(edit, 800, 600));
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }));
    }

    public Book() {
    }

    public Button getEdit() {
        return edit;
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

    @Override
    public String toString() {
        return getName();
    }
}
