package Library.bookManager.list;

import Library.Main;
import Library.dao.impls.BookManagerRepository;
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
import java.util.Date;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TableView<BookManager> tbvBookManager;
    public TableColumn<BookManager, Integer> tdID;
    public TableColumn<BookManager, String> tdStudent;
    public TableColumn<BookManager, String> tdBook;
    public TableColumn<BookManager, Date> tdRentDate;
    public TableColumn<BookManager, Date> tdExDate;
    public TableColumn<BookManager, String> tdStatus;


    public void handleAdd(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(this.getClass().getResource("../../create/bookManager/createBookManager.fxml"));
        Main.rootStage.setTitle("BookManager Form");
        Main.rootStage.setScene(new Scene(listBook, 800, 600));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tdID.setCellValueFactory(new PropertyValueFactory<BookManager, Integer>("id"));
        tdBook.setCellValueFactory(new PropertyValueFactory<BookManager, String>("bookName"));
        tdStudent.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        tdExDate.setCellValueFactory(new PropertyValueFactory<BookManager, Date>("expireDate"));
        tdRentDate.setCellValueFactory(new PropertyValueFactory<BookManager, Date>("rentDate"));
        tdStatus.setCellValueFactory(new PropertyValueFactory<BookManager, String>("status"));


        BookManagerRepository brr = (BookManagerRepository)RepositoryFactory.createRepository(RepositoryType.BOOKMANAGER);
        tbvBookManager.getItems().addAll(brr.all());
    }

    public void handleBackHome(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(this.getClass().getResource("../../home.fxml"));
        Main.rootStage.setTitle("Home");
        Main.rootStage.setScene(new Scene(listBook, 800, 600));
    }
}
