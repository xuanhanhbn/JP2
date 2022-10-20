package Library.create.bookManager;

import Library.Main;
import Library.dao.impls.BookRepository;
import Library.entities.Book;
import Library.entities.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public ComboBox<Book> cbBook;
    public ComboBox<Student> cboStudent;
    public DatePicker dpEx;

    public void handleCancel(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(this.getClass().getResource("../../bookManager/list/listBookManager.fxml"));
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(listBook, 800, 600));
    }

    public void handleSubmit(ActionEvent actionEvent) {
        Book selected = cbBook.getSelectionModel().getSelectedItem();
        LocalDate dp = dpEx.getValue();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BookRepository rp = new BookRepository();
        ObservableList<Book> ls = FXCollections.observableArrayList();
        ls.addAll(rp.all());
        cbBook.setItems(ls);

    }
}
