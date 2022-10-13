package ss1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Controller {
    public void handleChangeBook(ActionEvent actionEvent) throws Exception {
        Parent bookPage = FXMLLoader.load(getClass().getResource("./Book/formBook.fxml"));
        Scene listScene = new Scene(bookPage, 800, 600);
//        Main.rootStage.setTitle("From Add Book");
        Main.rootStage.setScene(listScene);
    }

    public void handleChangeStaff(ActionEvent actionEvent) {

    }

    public void handleChangeBookManagement(ActionEvent actionEvent) {

    }
}
