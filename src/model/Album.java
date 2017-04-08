package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

/*
 * Open an album. Opening an album displays all photos, with their thumbnail images and captions, inside that album. Once an album is open the user can do the following:
 * Add a photo
 * Remove a photo
 * Go through photos in album in sequence forward or backward, one at a time, with user interaction (manual slideshow)
 */

public class Album implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8662942780052626269L;
	
	private String albumName;
	private ArrayList<Photo> photos;
	
	public Album(String albumName) {
		this.albumName = albumName;
		this.photos = new ArrayList<Photo>();
	}
	
	// Getter methods
	public String getAlbumName() {
		return this.albumName;
	}
	
	public ArrayList<Photo> getPhotoList(){
		return this.photos;
	}
	
	// Setter Methods
	public boolean setAlbumName(String newName) {
		this.albumName = newName;
		return true;
	}
	// Add and remove photos
	
	public boolean addPhoto(Photo photo) {
		this.photos.add(photo);
		return true;
	}
	
	public boolean removePhoto(Photo photo) {
		// Need to decide how this will be done index vs photo object
		int photoIndex = photoIndex(photo);
		if(photoIndex != -1) {
			this.photos.remove(photoIndex);
			return true;
		}
		return false;
	}
	
	public void printPhotoListNames() {
		for(Photo photo: this.photos) {
			System.out.println("Photo File Name: " + photo.getfileName());
		}
	}
	
	public int photoIndex(Photo photo) {
		Photo current;
		for(int i = 0; i < this.photos.size(); i++) {
			current = this.photos.get(i);
			if(current.equals(photo)) return i;
		}
		return -1;
	}
	
	public Calendar getFirst() {
		if(this.photos.size() < 1) return null;
		Calendar first = this.photos.get(0).getDate();
		for(Photo photo: this.photos) {
			first = (photo.getDate().compareTo(first) > 0) ? photo.getDate() : first;
		}
		
		return first;
	}
	
	public Calendar getLast() {
		if(this.photos.size() < 1) return null;
		Calendar last = this.photos.get(0).getDate();
		for(Photo photo: this.photos) {
			last = (photo.getDate().compareTo(last) < 0) ? photo.getDate() : last;
		}
		
		return last;
	}
	
}
