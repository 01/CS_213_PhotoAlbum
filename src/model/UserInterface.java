package model;
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

public interface UserInterface {
	String getFullName();
	String getPassword();
	String getUsername();
	boolean createAlbum(String albumName);
	boolean deleteAlbum(String albumName);
	boolean renameAlbum(String albumName, String newAlbumName);
		
}
