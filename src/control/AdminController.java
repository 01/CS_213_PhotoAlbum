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

public class AdminController {
	@FXML private Button addUserButton;
	@FXML private Button deleteUserButton;
	@FXML private Button logoutButton;
	
	
	
	@FXML
	public void onClick(ActionEvent e) throws IOException{	
		Button clicked = (Button)e.getSource();
		if(clicked == addUserButton) {
			Scene createuser_page = new Scene(FXMLLoader.load(getClass().getResource("/view_helper/CreateNewUser.fxml")));
	        Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
	        app_stage.setResizable(false);
            app_stage.setScene(createuser_page);
			
		}
		else if(clicked == deleteUserButton) {
			//String username = listView.getSelectionModel().getSelectedItem();
			// BackendSerial.deleteUser(username);
		}
		else if(clicked == logoutButton) {
			BackendSerial.save();
		}
	}

}
