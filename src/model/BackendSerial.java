package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/* 
 * This will take care of the writing and reading form the user file of the serialized data
 * You are required to use the java.io.Serializable interface, and the java.io.ObjectOutputStream/java.io.ObjectInputStream classes to store and retrieve data.
 * 
 * Note that your application will need to store content for multiple users, so it would be a good idea to separate different user's contents from each other.
 * 
 * You need to think about what objects you want to have in your design, with what attributes and operations. It is important to plan this out and come up with a good 
 * object-oriented design that clearly separates roles and functions between objects,  and can be cleanly extended to add more features for future versions of the application.
 */
public class BackendSerial implements Serializable{

	private static final long serialVersionUID = 3727994457398773678L;
	
	private static final String storeDir = "dat";
	private static final String storeFile = "users.dat"; 
	
	private ArrayList<User> userList;
	
	
	public BackendSerial() {
		this.userList = new ArrayList<User>();
		
		// Set path for files to be written. 
		File datDir = new File(storeDir);
		datDir.mkdir();
	}
	public void writeUser(User user) {
		// write the users.dat

			ObjectOutputStream oos;
			try {
				oos = new ObjectOutputStream(new FileOutputStream(storeDir + File.separator + storeFile));
				oos.writeObject(user);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
	
	public User readUser(String username) throws IOException, ClassNotFoundException  {
		if(!userExists(username)) {
			System.out.println("User does not exist");
			return null;
		}
		else {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(storeDir + File.separator + storeFile));
			User user = (User) ois.readObject();
			return user;	
		}
		
	}
	
	public void createUser(String firstName, String lastName, String username, String password) {
		if(userExists(username)) {
			System.out.println("User already exists");
		}
		else {
			//public User(String firstName, String lastName, String username, String password) {
			User current = new User(firstName, lastName, username, password);
		//writeUser(current);
			this.userList.add(current);
		}
	}
	
	public void deleteUser(String username) {
		// Need helper method to check if user exists
		if(!userExists(username)) {
			System.out.println("User does not exist");
		}
		else {
			// Delete the users file
			
			// need getIndex of user method
			int userIndex = userIndex(username);
			this.userList.remove(userIndex);
		}
	}
	
	public boolean userExists(String username) {
		for(User user: this.userList) {
			if (user.getUsername().equalsIgnoreCase(username)) return true;
		}
		return false;
	}
	
	public int userIndex(String username) {
		if(this.userList.size() < 1) return -1;
		for(int i = 0; i < userList.size(); i++) {
			User current = this.userList.get(i);
			if(current.getUsername().equalsIgnoreCase(username)) return i;
		}
		return -1;
	}
	
	public User getUserAtIndex(int index) {
		return this.userList.get(index);
	}
	
}
