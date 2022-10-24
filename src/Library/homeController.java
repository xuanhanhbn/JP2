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

    public void handleChangeStudent(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("Student/studentList/list/studentForm.fxml"));
        Main.rootStage.setTitle("Student");
        Main.rootStage.setScene(new Scene(listBook, 800, 600));
    }

    public void handleChangeBookManager(ActionEvent actionEvent) throws Exception {
        Parent listBookManager = FXMLLoader.load(getClass().getResource("bookManager/list/listBookRents.fxml"));
        Main.rootStage.setTitle("Book Manager");
        Main.rootStage.setScene(new Scene(listBookManager, 800, 600));
    }
}
