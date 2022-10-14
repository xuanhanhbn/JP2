package ss1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Controller {
    public void handleChangeBook(ActionEvent actionEvent) throws Exception {
        Parent editPage = FXMLLoader.load(getClass().getResource("./Book/formBook.fxml"));
        Scene editScene = new Scene(editPage, 800, 600);
        Main.rootStage.setTitle("Form Edit Book");
        Main.rootStage.setScene(editScene);
    }

    public void handleChangeStaff(ActionEvent actionEvent) {

    }

    public void handleChangeBookManagement(ActionEvent actionEvent) {

    }
}
