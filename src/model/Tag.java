package model;

// Debating if this should be its own object. 
/*
 * Tags
 *
 *	Photos can be tagged with pretty much any attribute you think is useful to search on, or group by. Examples are location where photo was taken, 
 *	so you can search for photos by location, and names of people in a photo.
 *
 *	From the implementation point of view, it may be useful to think of a tag is a combination of tag name and tag value, e.g. ("location","New Brunswick"), 
 *  or ("person","susan"). A photo may have multiple tags (name+value pairs), 
 *	but no two tags will have the same name and value.
 */
public class Tag {
	
	public static final String [] tagList = {"Person", "Location"};
	private String tagName, tagValue;
	
	public Tag(String tagName, String tagValue) {
		this.tagName = tagName;
		this.tagValue = tagValue;
	}
	
	// Getter Methods
	public String getTagName() {
		return this.tagName;
	}
	
	public String getTagValue() {
		return this.tagValue;
	}
	
	// Setter 
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	
	public void setTagValue(String tagValue) {
		this.tagValue = tagValue;
	}
	
	public String toString() {
		return this.tagName + " " + this.tagValue;
	}

}
