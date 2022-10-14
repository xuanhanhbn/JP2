package Library;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class homeController {
    public void handleChangeBook(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("bookList/list/listBook.fxml"));
        Main.rootStage.setTitle("Form Books");
        Main.rootStage.setScene(new Scene(listBook, 800, 600));


    }
}
