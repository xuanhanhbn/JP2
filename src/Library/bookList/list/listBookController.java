package Library.bookList.list;

import Library.Main;
import Library.entities.Book;
import Library.helper.Connector;
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
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class listBookController implements Initializable {
    public TableView<Book> tbBook;
    public TableColumn<Book, Integer> idID;
    public TableColumn<Book, String> idName;
    public TableColumn<Book, String> idAuthor;
    public TableColumn<Book, Integer> idQty;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idID.setCellValueFactory(new PropertyValueFactory<Book, Integer>("id"));
        idName.setCellValueFactory(new PropertyValueFactory<Book, String>("name"));
        idAuthor.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        idQty.setCellValueFactory(new PropertyValueFactory<Book, Integer>("qty"));
        ObservableList<Book> listBook = FXCollections.observableArrayList();
//        Get API Database
        try {
            String sql_txt = "select * from Book";
            Connector conn = Connector.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String author = rs.getString("author");
                int qty = rs.getInt("qty");
                Book b = new Book(id,name,author,qty);
                listBook.add(b);
            }
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        } finally {

            tbBook.setItems(listBook);
        }

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
