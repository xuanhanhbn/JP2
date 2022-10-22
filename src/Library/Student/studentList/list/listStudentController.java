package Library.Student.studentList.list;

import Library.Main;
import Library.dao.impls.StudentRepository;
import Library.entities.Student;
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

public class listStudentController implements Initializable {
    public TableView tbvStudent;
    public TableColumn<Student, Integer> idIDStudent;
    public TableColumn<Student, String> idName;
    public TableColumn<Student, String> idEmail;
    public TableColumn<Student, String> idTel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idIDStudent.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
        idName.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        idEmail.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));
        idTel.setCellValueFactory(new PropertyValueFactory<Student, String>("tel"));
        ObservableList<Student> listStudent = FXCollections.observableArrayList();

//        GET DB
        ObservableList<Student> st = FXCollections.observableArrayList();
        StudentRepository s = new StudentRepository();
        st.addAll(s.all());
        tbvStudent.setItems(st);
    }

    public void backHome(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("../../../home.fxml"));
        Main.rootStage.setTitle("Home");
        Main.rootStage.setScene(new Scene(listBook, 800, 600));
    }

    public void handleChangeAddStudent(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("../../../create/student/createStudent.fxml"));
        Main.rootStage.setTitle("Create Student");
        Main.rootStage.setScene(new Scene(listBook, 800, 600));
    }
}
