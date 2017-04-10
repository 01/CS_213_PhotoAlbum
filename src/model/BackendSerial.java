package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
	private static final String usersFile = "users.data"; 
	private static final String storeExtension = ".dat";
	
	private static ArrayList<String> userList;
	private static BackendSerial current = new BackendSerial();
	private static User currentUser;
	
	
	public BackendSerial() {
		try {
			load();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Set path for files to be written. 
		File datDir = new File(storeDir + File.separator + usersFile);
		datDir.mkdir();
	}
	
	@SuppressWarnings("unchecked")
	public void load() throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File(storeDir + File.separator + usersFile);
			if(!file.exists()){
			userList = new ArrayList<String>();
			FileOutputStream oos= new FileOutputStream(storeDir + File.separator + usersFile);
			ObjectOutputStream out = new ObjectOutputStream(oos);
			out.writeObject(userList);
			oos.close();
			out.close();
			return;
		}else{
			try {
			FileInputStream ois = new FileInputStream(storeDir + File.separator + usersFile);
			ObjectInputStream in = new ObjectInputStream(ois);
			userList = (ArrayList<String>) in.readObject();
			System.out.println("Makes it here");
			ois.close();
			in.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			return;
		}
	}
	
	public static void save() {
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(storeDir + File.separator + usersFile));
			oos.writeObject(userList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(currentUser != null) {
			oos = new ObjectOutputStream(new FileOutputStream(storeDir + File.separator + currentUser.getUsername().concat(storeExtension)));
			oos.writeObject(currentUser);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/*public static void writeAll() {
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(storeDir + File.separator + usersFile));
			oos.writeObject(userList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*for(String user: userList) {
			//writeUser(user);
		}
	}*/



	public static void writeUser(User user) {
		// write the users.dat

			ObjectOutputStream oos;
			try {
				oos = new ObjectOutputStream(new FileOutputStream(storeDir + File.separator + user.getUsername().concat(storeExtension)));
				oos.writeObject(user);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
	
	@SuppressWarnings("resource")
	public static User readUser(String username) throws IOException, ClassNotFoundException  {
		if(!userExists(username)) {
			System.out.println("User does not exist");
			return null;
		}
		else {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(storeDir + File.separator + username.concat(storeExtension)));
			User user = (User) ois.readObject();
			return user;	
		}
		
	}
	
	public static void loadUser(String username) throws ClassNotFoundException {
		if(!userExists(username)) {
			System.out.println("User does not exist");
	
		}
		else {
			try {
				FileInputStream ois = new FileInputStream(storeDir + File.separator + username.concat(storeExtension));
				ObjectInputStream in = new ObjectInputStream(ois);
				currentUser = (User) in.readObject();
				ois.close();
				in.close();
			}
			catch(IOException e) {
					e.printStackTrace();
			}
		}
		
	}
	
	public static void createUser(String firstName, String lastName, String username, String password) {
		if(userExists(username)) {
			System.out.println("User already exists");
		}
		else {
			//public User(String firstName, String lastName, String username, String password) {
			User current = new User(firstName, lastName, username, password);
			userList.add(current.getUsername());
			writeUser(current);
			save();
		}
	}
	
	public static void deleteUser(String username) {
		// Need helper method to check if user exists
		if(!userExists(username)) {
			System.out.println("User does not exist");
		}
		else {
			// Delete the users file
			File file = new File(storeDir + File.separator + username.concat(storeExtension));
			file.delete();
			// need getIndex of user method
			int userIndex = userIndex(username);
			userList.remove(userIndex);
		}
	}
	
	public static boolean userExists(String username) {
		for(String user: userList) {
			if (user.equals(username)) return true;
		}
		return false;
	}
	
	public static int userIndex(String username) {
		if(userList.size() < 1) return -1;
		for(int i = 0; i < userList.size(); i++) {
			String current = userList.get(i);
			if(current.equals(username)) return i;
		}
		return -1;
	}
	
	public static String getUsernameAtIndex(int index) {
		return userList.get(index);
	}
	
	public static ArrayList<User> getUsers(){
		ArrayList<User> users = new ArrayList<User>();
		User current = null;
		for(String username: userList) {
			try {
				current = readUser(username);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			users.add(current);
		}
		return users;
	}
	
		
}
