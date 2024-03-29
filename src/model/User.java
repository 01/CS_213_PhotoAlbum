package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

/*
 * Once the user logs in successfully, all albums and photo information for this user from a previous session (if any) are loaded from disk.
 * Initially, all the albums belonging to the user should be displayed. For each album, its name, the number of photos in it, and the range of dates (earliest and latest date) on which photos 
 * were taken must be displayed. Use your discretion on how to show this additional information.
 * 
 * The user can then do the following:
 * Create albums
 * Delete albums
 * Rename albums
 * Open an album. Opening an album displays all photos, with their thumbnail images and captions, inside that album. Once an album is open the user can do the following:
 * Add a photo
 * Remove a photo
 * Caption/recaption a photo
 * Display a photo in a separate display area. The photo display should also show its caption, its date-time of capture (see Date of photo below), and all its tags (see Tags below).
 * Add a tag to a photo
 * Delete a tag from a photo
 * Copy a photo from one album to another (multiple albums may have copies of the same photo)
 * Move a photo from one album (source) to another (the photo will be removed from the source album
 * Go through photos in album in sequence forward or backward, one at a time, with user interaction (manual slideshow)
 * Search for photos (Photos that match the search criteria should be displayed in a similar way to how photos in an album are displayed). Under this, you should provide the following specific features:
 * Search for photos by a date range.
 * Search for photos by tag type-value pairs. 
 * Note: searching on multiple tag-value pairs should be supported, e.g. search for all photos with person=sesh and location=london.
 * There should be functionality to create an album containing the search results.
 * As mentioned earlier (under Copy a photo from one albim to another), a photo can be in multiple albums. Creating an album out of search results means adding these photos to a new album, without deleting them from the current album(s) to which they belong.
 * 
 * Note: A single user may not have duplicate album names, but the name may be duplicated across users.
 */

public class User implements Serializable, UserInterface {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3636530334821498513L;
	/**
	 * 
	 */

	private String firstName, lastName, username, password;
	private ArrayList<Album> albumList;
	private Calendar dateCreated;
	private Calendar lastLogin;
	
	// private Albums (need to decide to datastructure for this
	
	// Regular Constructor 
	// Possibly for fancy functionality have method to check password strength;
	public User(String firstName, String lastName, String username, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.albumList = new ArrayList<Album>();
		this.dateCreated = Calendar.getInstance();
		this.dateCreated.set(Calendar.MILLISECOND,0);

	}
	
	// Overloaded Constructor for single name given
	public User(String firstName, String username, String password) {
		this.firstName = firstName;
		this.username = username;
		this.password = password;
		this.albumList = new ArrayList<Album>();
		this.dateCreated = Calendar.getInstance();
		this.dateCreated.set(Calendar.MILLISECOND,0);
	}
	
	// Getters 
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public Calendar getDateCreated() {
		return this.dateCreated;
	}
	
	public Calendar getLastLogin() {
		return this.lastLogin;
	}
	
	public void setLastLogin() {
		this.lastLogin = Calendar.getInstance();
		this.lastLogin.set(Calendar.MILLISECOND,0);
	}
	
	public boolean renameAlbum(String albumName, String newAlbumName) {
		int albumIndex = albumIndex(albumName);
		if(albumIndex != -1) {
			int newAlbumIndex = albumIndex(newAlbumName);
			if(newAlbumIndex == -1) {
			this.albumList.get(albumIndex).setAlbumName(newAlbumName);
			return true;
			}
		}
		return false;
	}
	
	public boolean createAlbum(String albumName) {
		// Need check if Album name already exists
		int albumIndex = albumIndex(albumName);
		if(albumIndex == -1) {
			this.albumList.add(new Album(albumName));
			return true;
		}
		
		return false;
	}
	
	public boolean deleteAlbum(String albumName) {
		// need a find index of Album method
		int albumIndex = albumIndex(albumName);
		if(albumIndex != -1) {
			this.albumList.remove(albumIndex);
			return true;
		}
		return false;	
	}
	
	public boolean movePhoto(String albumNameSource, Photo source, String albumNameDestination) {
		
		copyPhoto(source, albumNameDestination);
		//deletePhoto(albumNameSource, source);
		int albumIndex = albumIndex(albumNameSource);
		
		if(albumIndex != -1) {
			int photoIndex = this.albumList.get(albumIndex).photoIndex(source);
			if(photoIndex != -1) {
				this.albumList.get(albumIndex).removePhoto(source); //need to get index of photo
				return true;
			}
			return false;
			
		}
		return false;
	}
	
	public boolean copyPhoto(Photo source, String albumNameDestination) {
		int albumIndex = albumIndex(albumNameDestination);
		if(albumIndex != -1) {
			this.albumList.get(albumIndex).addPhoto(source);
			return true;
		}
		return false;
	}
	
	public int albumIndex(String albumName) {
		Album current;
		for(int i = 0; i < this.albumList.size(); i++) {
			current = this.albumList.get(i);
			if(current.getAlbumName().equalsIgnoreCase(albumName)) return i;
		}
		return -1;
	}

	public ArrayList<Photo> searchPhotosByDate(Calendar start, Calendar end){
		ArrayList<Photo> searchList = new ArrayList<Photo>();
		if(this.albumList.size() < 1) return null;
		for(Album album : this.albumList) {
			if(album.getPhotoList().size() < 1) continue;
			for(Photo photo : album.getPhotoList()) {
				if(photo.getDate().compareTo(start) >= 0 && photo.getDate().compareTo(end) <= 0) {
					searchList.add(photo);
				}
			}
		}
		return searchList;	
	}
	
	public ArrayList<Photo> searchByTags(ArrayList<Tag> tags){
		ArrayList<Photo> searchList = new ArrayList<Photo>();
		if(this.albumList.size() < 1) return null;
		for(Album album : this.albumList) {
			if(album.getPhotoList().size() < 1) continue;
			for(Photo photo : album.getPhotoList()) {
				if(hasSearchTag(tags, photo.getTags())) {
					searchList.add(photo);
				}
			}
		}
		return searchList;	
	}
	
	public ArrayList<Photo> searchPhotos(Calendar start, Calendar end, ArrayList<Tag> tags){
		ArrayList<Photo> searchList = new ArrayList<Photo>();
		if(this.albumList.size() < 1) return null;
		for(Album album : this.albumList) {
			if(album.getPhotoList().size() < 1) continue;
			for(Photo photo : album.getPhotoList()) {
				if(photo.getDate().compareTo(start) >= 0 && photo.getDate().compareTo(end) <= 0) {
					if(hasSearchTag(tags, photo.getTags())){
						searchList.add(photo);
					}
				}
			}
		}
		return searchList;	
		
	}
	
	public boolean hasSearchTag(ArrayList<Tag> searchTags, ArrayList<Tag> photoTags) {
		if(searchTags == null || photoTags == null) return false;
		for(Tag searchTag : searchTags) {
			for(Tag photoTag: photoTags) {
				if(searchTag.getTagName().equalsIgnoreCase(photoTag.getTagName()) && searchTag.getTagValue().equalsIgnoreCase(photoTag.getTagValue())){
					return true;
				}
			}
		}
		return false;
	}

	
	

	
}
