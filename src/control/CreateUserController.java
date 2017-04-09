package control;

import java.io.IOException;
import model.User;
import model.BackendSerial;
import view.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class CreateUserController {
	@FXML private Button SubmitButton;
	@FXML private TextField usernameBox;
	@FXML private TextField nameBox;
	@FXML private TextField passwordBox;
	@FXML private TextField rePasswordBox;
	
	@FXML
	public void onClick(ActionEvent e) throws IOException{	
		System.out.println("Makes here 23");
		Button clicked = (Button)e.getSource();
		if(clicked == SubmitButton) {
			String username = usernameBox.getText();
			String name = nameBox.getText();
			String password = passwordBox.getText();
			String rePassword = rePasswordBox.getText();
			//System.out.println("Makes it here22");
			if(username.equals("")) {
				System.out.println("No username entered ");
			}
			if(password.equals("")) {
				System.out.print("No password");
			}
			if(rePassword.equals("")) {
				System.out.print("No password reentered ");
			}
			if(!password.equals(rePassword)) {
				System.out.print("Passwords dont match ");
			}
			//System.out.println("Makes it here");
			if(BackendSerial.userExists(username)) {
				System.out.println("Username already exists");
			}
			if(username.length() < 5) {
				System.out.println("Username must be at least 5 characters");
			}
			else {
				BackendSerial.createUser(name, "testLast", username, password);	
				Scene login_page = new Scene(FXMLLoader.load(getClass().getResource("/view/LoginScene.fxml")));
		        Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		        app_stage.setResizable(false);
	            app_stage.setScene(login_page);
			}
		}
	}

}
