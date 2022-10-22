package Library.bookManager.list;

import Library.Main;
import Library.dao.impls.BookRepository;
import Library.entities.Book;
import Library.entities.BookManager;
import Library.enums.RepositoryType;
import Library.factory.RepositoryFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TableView<BookManager> tbvBookManager;
    public TableColumn<BookManager, Integer> tdID;
    public TableColumn<BookManager, String> tdNameStudent;
    public TableColumn<BookManager, String> tdNameBook;
    public TableColumn<BookManager, Date> tdExpDate;

    public void handleAdd(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(this.getClass().getResource("../../create/bookManager/createBookManager.fxml"));
        Main.rootStage.setTitle("Student Form");
        Main.rootStage.setScene(new Scene(listBook, 800, 600));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tdID.setCellValueFactory(new PropertyValueFactory<BookManager, Integer>("id"));
        tdNameStudent.setCellValueFactory(new PropertyValueFactory<BookManager, String>("nameStudent"));
        tdNameBook.setCellValueFactory(new PropertyValueFactory<BookManager, String>("nameBook"));
        tdExpDate.setCellValueFactory(new PropertyValueFactory<BookManager, Date>("exDate"));
        ObservableList<BookManager> listBookManager = FXCollections.observableArrayList();

//        Get API Database
        ObservableList<BookManager> ls = FXCollections.observableArrayList();
        BookRepository rp = (BookRepository) RepositoryFactory.createRepository(RepositoryType.BOOKMANAGER);
//        ls.addAll(rp.all());
        tbvBookManager.setItems(ls);
    }
}
