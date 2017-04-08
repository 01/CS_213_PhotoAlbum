package model;

public class methodTesters {

	public static void main(String[] args) {
	// Photo object Tests
		
		//photoTests();
		albumTests();

	}
	
	public static void photoTests() {
		// Test Photo creation with/without caption
		Photo testPhoto_No_Caption = new Photo("test.jpg");
		Photo testPhoto_Caption = new Photo("Test Caption", "test2.jpg");
		
		// Test getCaption
		System.out.println("Caption for Photo test.jpg with no Caption: " + testPhoto_No_Caption.getCaption());
		System.out.println("Caption for Photo test1.jpg with Caption: " + testPhoto_Caption.getCaption());
		
		//Test addTag
		if(testPhoto_No_Caption.addTag("Person", "Andrew")) System.out.println("Added Tag Person:Andrew");
		if(testPhoto_Caption.addTag("Person", "Sagar")) System.out.println("Added Tag Person:Andrew");
		
		//Test addingTag that already exists
		testPhoto_No_Caption.addTag("Person", "Andrew");
		testPhoto_Caption.addTag("Person", "Sagar");
		
		// Test changeCaption
		System.out.println("Old Caption: " + testPhoto_No_Caption.getCaption());
		testPhoto_No_Caption.changeCaption("New Caption previous no Caption");
		System.out.println("New Caption: " + testPhoto_No_Caption.getCaption());
		
		// Test editTag
		if(testPhoto_No_Caption.editTag("Person", "Andrew", "Andy")) System.out.println("Successfully edited tag");
		
		// test hasTag
		if(testPhoto_No_Caption.hasTag("Person", "Andy")) System.out.println("Has tag checked");
		
		// test tagIndex
		if(testPhoto_No_Caption.tagIndex("Person", "Andy") != -1) System.out.println("tagIndex successfull check");
		
		
		// test removeTag
		if(testPhoto_No_Caption.removeTag("Person", "Andy")) System.out.println("removeTag successful");
	}
	
	public static void albumTests() {
		// Test album creation
		Album album1 = new Album("Album1");
		System.out.println("Album Created getAlbumName = " + album1.getAlbumName());
		
		// Test adding photos to album
		Photo testPhoto1 = new Photo("testPhoto1", "test1.jpg");
		Photo testPhoto2 = new Photo("testPhoto2", "test2.jpg");
		Photo testPhoto3 = new Photo("testPhoto3", "test3.jpg");
		Photo testPhoto4 = new Photo("testPhoto4", "test4.jpg");
		Photo testPhoto5 = new Photo("testPhoto5", "test5.jpg");
		Photo testPhoto6 = new Photo("testPhoto6", "test6.jpg");
		Photo testPhoto7 = new Photo("testPhoto7", "test7.jpg");
		
		album1.addPhoto(testPhoto1);
		album1.addPhoto(testPhoto2);
		album1.addPhoto(testPhoto3);
		album1.addPhoto(testPhoto4);
		album1.addPhoto(testPhoto5);
		album1.addPhoto(testPhoto6);
		album1.addPhoto(testPhoto7);
		
		// Test print photolistnames
		System.out.println("Printing photo list names");
		album1.printPhotoListNames();
		
		
	}

}
