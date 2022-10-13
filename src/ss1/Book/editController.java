package ss1.Book;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import ss1.Book.Book;
import ss1.Main;

import java.net.URL;
import java.util.ResourceBundle;


public class editController implements Initializable {
    public TextField txtID;
    public TextField txtName;
    public TextField txtCategory;
    public TextField txtDes;
    public TextField txtAuthor;

    private ObservableList<Book> listBook = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            if(bookController.editItem == null ){
                handleCancel(null);
            }
            txtID.setText(bookController.editItem.getId());
            txtName.setText(bookController.editItem.getName());
            txtCategory.setText(bookController.editItem.getCategory());
            txtDes.setText(bookController.editItem.getDescription());
            txtAuthor.setText(bookController.editItem.getAuthor());
        } catch (Exception e){

        }
    }

    public void handleUpdate(ActionEvent actionEvent) {
        try{
            bookController.editItem.setId(txtID.getText());
            bookController.editItem.setName(txtName.getText());
            bookController.editItem.setCategory(txtCategory.getText());
            bookController.editItem.setDescription(txtDes.getText());
            bookController.editItem.setAuthor(txtAuthor.getText());

        } catch (Exception e){

        }
    }

    public void handleCancel(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("formBook.fxml"));
        Scene listScene = new Scene(listPage, 800, 600);
        Main.rootStage.setTitle("EditList Course");
        Main.rootStage.setScene(listScene);
    }
}
