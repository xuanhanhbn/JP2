package Library.create.student;

import Library.Main;
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
            txtNoticeError.setVisible(false);
            if(!txtEmail.getText().contains("@") || txtEmail.getText().startsWith("@")
                || txtEmail.getText().endsWith("@") || !txtTel.getText().startsWith("0")){
                throw new Exception("Nhập đúng thông tin");
            }
            String sql_txt  = "insert into Student(name, email, tel) values(?,?,?)";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(name);
            arr.add(email);
            arr.add(tel);
            conn.executeAdd(sql_txt,arr);
            handleCancel(null);
            if (conn.executeAdd(sql_txt,arr)){
                handleCancel(null);}
            else {
                System.out.println("Error");
            }
        } catch (Exception e){
            txtNoticeError.setText(e.getMessage());
            txtNoticeError.setVisible(true);
        }
    }
}
