package Library.edit;

import Library.Main;
import Library.dao.impls.BookRepository;
import Library.entities.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class editBookController implements Initializable {
    public TextField txtName;
    public TextField txtAuthor;
    public TextField txtQty;
    public static Book editedBook;
    public void handleSubmit(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String author = txtAuthor.getText();
            Integer qty = Integer.parseInt(txtQty.getText());
            editedBook.setName(name);
            editedBook.setAuthor(author);
            editedBook.setQty(qty);
            BookRepository rp = new BookRepository();
            if (rp.update(editedBook)){
                handleCancel(null);
            }else {
                System.out.println("Error");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void handleCancel(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(this.getClass().getResource("../bookList/list/listBook.fxml"));
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(listBook, 800, 600));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(editedBook != null){
            txtName.setText(editedBook.getName());
            txtAuthor.setText(editedBook.getAuthor());
            txtQty.setText(editedBook.getQty().toString());
        }
    }
}
