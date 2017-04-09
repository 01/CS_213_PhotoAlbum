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



/**
 * Controller for Login
 */
public class LoginController {
	@FXML private Button LoginButton;
	@FXML private Button NewAccountButton;
	@FXML private TextField usernameBox;
	@FXML private TextField passwordBox;
	
	
	//
	@FXML
	public void onClick(ActionEvent e) throws IOException{	
		String username = usernameBox.getText();
		System.out.println("Makes it here");
		Button clicked = (Button)e.getSource();
		BackendSerial.createUser("Andrew", "Khazanovich", "admin", "admin");
		if(clicked == LoginButton){ //if logging in
			// Entered admin 
			System.out.println("Makes it trhough clicked == LoginButton");
			if(username.toLowerCase().trim().equals("admin") && BackendSerial.userExists("admin")){
				System.out.println("Admin exists and clicked Login");
		        Scene admin_page = new Scene(FXMLLoader.load(getClass().getResource("/view/AdminView.fxml")));
		        Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		        app_stage.setResizable(false);
	            app_stage.setScene(admin_page);
			}
			else{ // Regular User login
				if(BackendSerial.userExists(username)){
						System.out.println("Makes it past userExists check");
						int userIndex = BackendSerial.userIndex(username);
						String password = passwordBox.getText();
						System.out.println("User exists: user Index:" + userIndex + "password: " + password);
						User currentUser;
						try {
							currentUser = BackendSerial.readUser(username);
							if(password.equals(currentUser.getPassword())) {
								BackendSerial.loadUser(username);
								Parent home_page_parent = FXMLLoader.load(getClass().getResource("/view/UserView.fxml"));
								Scene home_page_scene = new Scene(home_page_parent);
								Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
								app_stage.setResizable(false);
								app_stage.setScene(home_page_scene);
							}
							else {
								System.out.println("Password is incorrect for user");// wrong password
							}
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
				}
						
				else { // User doesnt exist
					System.out.println("User doesnt exist");
					
				}
			}
		}
		else { // Clicked create new user
			Scene createuser_page = new Scene(FXMLLoader.load(getClass().getResource("/view_helper/CreateNewUser.fxml")));
	        Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
	        app_stage.setResizable(false);
            app_stage.setScene(createuser_page);
		}
			
	}
			
		}

