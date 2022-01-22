package poiseProject;

public class personnel {
	// Attributes
	
	String name;
	String phoneNum;
	String emailAddress;
	String address;
	String role;
	
	// Methods
	
	public personnel(String name, String phoneNum, String emailAddress, String address, String role) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.emailAddress = emailAddress;
		this.address = address;
		this.role = role;
	}
	
	// Returns the name of the personnel object.
	public String getName() {
		return name;
	}
	
	// Returns the phone number of the personnel object.
	public String getPhoneNum(){
		return phoneNum;
	}
	
	// Returns the email address of the personnel object.
	public String getEmailAddress() {
		return emailAddress;
	}
	
	// Returns the address of the personnel object. 
	public String getAddress() {
		return address;
	}
	
	// Returns the role of the personnel.
	public String getRole() {
		return role;
	}
	
	// Allows you to update the role of a personnel.
	public void updateRole(String role) {
		this.role = role;
	}
	
	// Allows you to update the physical address of a personnel object
	// mainly to to correct typos, or incorrect entries. 
	public void updateAddress(String address) {
		this.address = address;
	}
	
	// Allows you to update the name of a personnel object.
	public void updateName(String name) {
		this.name = name;
	}
	
	// Allows you to update the phone number of a personnel object.
	public void updatePhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	// Allows you to update the email address of a personnel object.
	public void updateEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	// Returns a string of all the attributes of a personnel object.
	public String toString() {
		String output = "\nName: " + this.name;
		output += "\nPhone number: " + this.phoneNum;
		output += "\nEmail address: " + this.emailAddress;
		output += "\nAddress: " + this.address;
		return output;
	}
	
}
