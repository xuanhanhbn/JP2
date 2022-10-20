package Library.bookList.list;

import Library.Main;
import Library.dao.impls.BookRepository;
import Library.entities.Book;
import Library.helper.Connector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class listBookController implements Initializable {
    public TableView<Book> tbBook;
    public TableColumn<Book, Integer> idID;
    public TableColumn<Book, String> idName;
    public TableColumn<Book, String> idAuthor;
    public TableColumn<Book, Integer> idQty;
    public TableColumn<Book, Button> idEdit;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idID.setCellValueFactory(new PropertyValueFactory<Book, Integer>("id"));
        idName.setCellValueFactory(new PropertyValueFactory<Book, String>("name"));
        idAuthor.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        idQty.setCellValueFactory(new PropertyValueFactory<Book, Integer>("qty"));
        idEdit.setCellValueFactory(new PropertyValueFactory<Book, Button>("edit"));

        ObservableList<Book> listBook = FXCollections.observableArrayList();
//        Get API Database
        ObservableList<Book> ls = FXCollections.observableArrayList();
        BookRepository rp = new BookRepository();
        ls.addAll(rp.all());
        tbBook.setItems(ls);


    }

    public void handleAddNewBook(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(this.getClass().getResource("../../create/book/Untitled.fxml"));
        Main.rootStage.setTitle("Form Add Books");
        Main.rootStage.setScene(new Scene(listBook, 800, 600));
    }

    public void handleBack(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(this.getClass().getResource("../../home.fxml"));
        Main.rootStage.setTitle("Home");
        Main.rootStage.setScene(new Scene(listBook, 800, 600));
    }
}
