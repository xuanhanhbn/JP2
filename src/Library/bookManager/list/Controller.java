package Library.bookManager.list;

import Library.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Controller {
    public void handleAdd(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(this.getClass().getResource("../../create/bookManager/createBookManager.fxml"));
        Main.rootStage.setTitle("Student Form");
        Main.rootStage.setScene(new Scene(listBook, 800, 600));
    }
}
