package Library.create.student;

import Library.Main;
import Library.dao.impls.StudentRepository;
import Library.entities.Student;
import Library.helper.Connector;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class createStudentController {
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtTel;
    public Text txtNoticeError;
    public void handleCancel(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(this.getClass().getResource("../../Student/studentList/list/studentForm.fxml"));
        Main.rootStage.setTitle("Student Form");
        Main.rootStage.setScene(new Scene(listBook, 800, 600));
    }

    public void handleSubmit(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String email = txtEmail.getText();
            String tel = txtTel.getText();
            Student student = new Student(null,name,email,tel);
            StudentRepository st = new StudentRepository();
            if (st.create(student)){
                handleCancel(null);
            }else {
                txtNoticeError.setVisible(true);
                txtNoticeError.setText("Error");
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }


    }
}
