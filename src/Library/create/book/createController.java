package Library.create.book;

import Library.Main;
import Library.helper.Connector;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class createController {
    public TextField txtName;
    public TextField txtAuthor;
    public TextField txtQty;

    public void handleSubmit(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String author = txtAuthor.getText();
            int qty = Integer.parseInt(txtQty.getText());
            String sql_txt  = "insert into Book(name, author, qty) values(?,?,?)";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(name);
            arr.add(author);
            arr.add(qty);

            if (conn.executeAdd(sql_txt,arr)){
                handleCancel(null);
            }else {
                System.out.println("Error");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void handleCancel(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(this.getClass().getResource("../../bookList/list/listBook.fxml"));
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(listBook, 800, 600));
    }
}
