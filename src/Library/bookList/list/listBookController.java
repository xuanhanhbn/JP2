package Library.bookList.list;

import Library.entities.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class listBookController implements Initializable {
    public TableView<Book> tbBook;
    public TableColumn<Book, Integer> idID;
    public TableColumn<Book, String> idName;
    public TableColumn<Book, String> idAuthor;
    public TableColumn<Book, Integer> idQty;

//    Create Connect API
    public final static String connectionString = "jdbc:mysql://localhost:8889/T2203E";
    public final static String user = "root";
    public final static String pwd = "root";


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idID.setCellValueFactory(new PropertyValueFactory<Book, Integer>("id"));
        idName.setCellValueFactory(new PropertyValueFactory<Book, String>("name"));
        idAuthor.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        idQty.setCellValueFactory(new PropertyValueFactory<Book, Integer>("qty"));
        ObservableList<Book> listBook = FXCollections.observableArrayList();
//        Get API Database
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connectionString,user,pwd);
            Statement statement = conn.createStatement();
            String sql_txt = "select * from Book";
            ResultSet rs = statement.executeQuery(sql_txt);
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
//        Add API to DB
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connectionString, user, pwd);
            Statement statement = conn.createStatement();

            String sql_txt = "INSERT INTO `Book`(`name`, `author`, `qty`)" + " VALUES ('Quản lý thời gian','Richard Guare',20)";
            System.out.println("Run: "+sql_txt);
            int rs = statement.executeUpdate(sql_txt);
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }finally {

        }

    }
}
