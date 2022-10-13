package ss1.Book;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ss1.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class bookController implements Initializable {
    public TextField txtID;
    public TextField txtName;
    public TextField txtCategory;
    public TextField txtDes;
    public TextField txtAuthor;

    public static ObservableList<Book> bookList;
    public static Book editItem;


    @FXML
    private TableView<Book> table;
    @FXML
    private TableColumn<Book, String> idBook;
    @FXML
    private TableColumn<Book, String> idName;
    @FXML
    private TableColumn<Book, String> idCategory;
    @FXML
    private TableColumn<Book, String> idDes;
    @FXML
    private TableColumn<Book, String> idAuthor;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bookList = FXCollections.observableArrayList(new Book("AAA", "BBB", "CCC", "DDD", "EEE"));
        idBook.setCellValueFactory(new PropertyValueFactory<Book, String>("ID"));
        idName.setCellValueFactory(new PropertyValueFactory<Book, String>("Name"));
        idCategory.setCellValueFactory(new PropertyValueFactory<Book, String>("Category"));
        idDes.setCellValueFactory(new PropertyValueFactory<Book, String>("Description"));
        idAuthor.setCellValueFactory(new PropertyValueFactory<Book, String>("Author"));
        table.setItems(bookList);
    }
    public void handleAdd (ActionEvent e){
        Book newBook = new Book();
        newBook.setId(txtID.getText());
        newBook.setName(txtName.getText());
        newBook.setCategory(txtCategory.getText());
        newBook.setDescription(txtDes.getText());
        newBook.setAuthor(txtAuthor.getText());
        bookList.add(newBook);
        clear();
    }
    public void clear(){
        txtID.setText("");
        txtName.setText("");
        txtCategory.setText("");
        txtDes.setText("");
        txtAuthor.setText("");
    }

    public void handleDelete(ActionEvent e) {
        Book selected = table.getSelectionModel().getSelectedItem();
        bookList.remove(selected);
    }

    public void handleUpdate(ActionEvent actionEvent) throws Exception {
        editItem = table.getSelectionModel().getSelectedItem(); // Lay du lieu duoc chon;
        if(editItem == null) return;

        Parent editPage = FXMLLoader.load(getClass().getResource("editForm.fxml"));
        Scene editScene = new Scene(editPage, 800, 600);
        Main.rootStage.setTitle("Form Edit Book");
        Main.rootStage.setScene(editScene);
    }
}
