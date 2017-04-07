package model;

import java.io.Serializable;
import java.util.Calendar;

// Photo attributes needed
// Caption/recaption a photo
// Add a tag to a photo
// Delete a tag from a photo
// Search for photos by a date range.
// Search for photos by tag type-value pairs.

/* 
 * Date of photo

 * Since we won't examine the contents of a photo file to get the date the photo was taken, we will instead use the last modification date of the 
 * photo file (as provided via the Java API to the filesystem) as a proxy. (The user interface will still refer to this as the date the photo was taken.)

 * You may want to use a java.util.Calendar instance for the date and time the photo was taken. Note: When you set a date and time in a Calendar instance,  
 * also make sure you set milliseconds to zero, as in:

     
 * cal.set(Calendar.MILLISECOND,0);
 * Otherwise your equality checks won't work correctly.
 * Tags

 * Photos can be tagged with pretty much any attribute you think is useful to search on, or group by. Examples are location where photo was taken, 
 * so you can search for photos by location, and names of people in a photo.

 * From the implementation point of view, it may be useful to think of a tag is a combination of tag name and tag value, e.g. ("location","New Brunswick"), 
 * or ("person","susan"). A photo may have multiple tags (name+value pairs), but no two tags will have the same name and value.

 * Location of Photos

 * There are two sets of photos, stock photos that come pre-loaded with the application, and user photos that are loaded/imported by a user when they run the 
 * application.

 * Stock photos are photos that you will keep in the application's workspace. Limit them to 10. Create a special username called "stock" 
 * (no password, or password="stock") and store the stock photos under this user. Leave the photos in the application's workspace so the graders can test 
 * your application starting with your stock photos, then load other photos from their computer, see below. You can have all stock photos in a single album, 
 * or break them into multiple albums, it's up to you. Try to work with low/medium resolution pictures for the stock photos because they will be on Bitbucket 
 * and downloaded by the graders, and you don't want to bloat your project size. Make sure that your application will work correctly even if there are no stock 
 * photos to start with.

 * User photos are photos that your application can allow a user to load from their computer, so they can be housed anywhere on the user's machine. 
 * The actual photos must NOT be in your application's workspace. Instead, your application should only store the location of the photo on the user's machine. 
 * User photo information must NOT be in the released project in Bitbucket since each installation of your application on a machine will have its own set of users.
 *
 */
public class Photo implements Serializable {
	private String caption, tag, fileName;
	private Calendar date;
	// List of tags (possibly ArrayList)
	
	public Photo (String caption, String fileName) {
		this.caption = caption;
		this.fileName = fileName;
		this.date = Calendar.getInstance();
		this.date.set(Calendar.MILLISECOND,0);
	}
	
	// Getter methods
	public String getCaption() {
		return this.caption;
	}
	
	public String getfileName() {
		return this.fileName;
	}
	
	public String getDate() {
		return this.date; // look up if it has toString or need to set it
	}
	public boolean addTag(String tagName, String tagValue) {
		return true;
	}
	
	public boolean removeTag(String tagName, String tagValue) {
		return true;
	}
	
	public boolean changeCaption(String newCaption) {
		this.caption = newCaption;
		return true;
	}
}
