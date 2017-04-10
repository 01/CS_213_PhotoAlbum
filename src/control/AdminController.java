package control;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;

import model.User;
import model.Album;
import model.BackendSerial;
import model.Tag;
import view.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AdminController implements Initializable{
	@FXML private Button addUserButton;
	@FXML private Button deleteUserButton;
	@FXML private Button logoutButton;

	@FXML
	TableColumn<ObservableList<User>, String> username;
	@FXML
	TableColumn<ObservableList<User>, String> password;
	@FXML
	TableColumn<ObservableList<User>, String> firstName;
	@FXML
	TableColumn<ObservableList<User>, Calendar> dateCreated;
	@FXML
	TableColumn<ObservableList<User>, Calendar> lastLogin;
	//More of your code 
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
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
	
	/* public ObservableList<User> getUsersData() {
	        return usersData;
	    }
	
	 public void setUsersData(ObservableList<User> usersData) {
	        
	    }
	public void setupUsersTable(){
		ArrayList<User> userData = BackendSerial.getUsers();
		ObservableList<User> usersData = FXCollections.observableList(userData);
		


	}*/


}
