package poiseProject;
import java.sql.Date;

public class project {
	
	// Project attributes
	String projectNum;
	String projectName;
	String address;
	String buildType;
	String erfNum;
	String architect;
	String contractor;
	String customer;
	String fee;
	String amountPaid;
    String dueDate;
    String status = "In Progress";
    String completeDate;
	
    // Project methods
	public project(String projectNum,String customer,String architect
			,String contractor, String buildType,String erfNum, String address,
			String projectName, String fee, String amountPaid, String dueDate) {
		
		this.projectNum = projectNum;
		this.projectName = projectName;
		this.address = address;
		this.buildType = buildType;
		this.erfNum = erfNum;
		this.architect = architect;
		this.contractor = contractor;
		this.customer = customer;
		this.fee = fee;
		this.amountPaid = amountPaid;
		this.dueDate = dueDate;	
	}
	
	// Returns string with all the attributes of a project object.
	public String toString() {
		
		String output = "Project Number: "+ projectNum;
		output += "\nProject Name: "+ projectName;
		output += "\nPhysical Adddress: " + address;
		output += "\nBuilding Type: " + buildType;
		output += "\nERF Number: " + erfNum;
		output += "\nArchitect: " + architect;
		output += "\nContractor: " + contractor;
		output += "\nCustomer: " + customer;
		output += "\nFee: R" + fee;
		output += "\nAmount Paid: R" + amountPaid;
		output += "\nDue Date: " + dueDate;
		output += "\nStatus: " + status;
		output += "\nCompletion Date: " + completeDate;
		
		return output;
	}
	
	// Updates the due date of a project.
	public void updateDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	
	// Updates the fee of a project.
	public void updateFee(String fee) {
		this.fee = fee;
	}
	
	// Updates the amount paid for a project.
	public void updateAmountPaid(String amountPaid) {
		this.amountPaid = amountPaid;
	}
	
	// Updates the name of a project object.
	public void updateName(String projectName) {
		this.projectName = projectName;
	}
	
	// Updates the build type of a project.
	public void updateBuildType(String buildType) {
		this.buildType = buildType;
	}
	
	// Updates the architect of a project.
	public void updateArchitect(String architect) {
		this.architect = architect;
	}
	
	// Updates the contractor of a project
	public void updateContractor(String contractor) {
		this.contractor = contractor;
	}
	
	// Updates the erf number of a project.
	public void updateErf(String erfNum) {
		this.erfNum = erfNum;
	}
	
	// Updates the status of a project e.g. from incomplete to complete
	public void updateStatus(String status) {
		this.status = status;
	}
	
	// Updates completion date for the project.
	public void updateCompleteDate(String completeDate) {
		this.completeDate = completeDate;
	}
	
	// Returns fee of project.
	public String getFee() {
		return this.fee;
	}
	
	// Returns amount paid for the project.
	public String getAmountPaid() {
		return this.amountPaid;
	}
	
	// Returns customer name of the project.
	public String getCustomer() {
		return this.customer;
	}
	
}

