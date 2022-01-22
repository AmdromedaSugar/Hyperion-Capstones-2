package poiseProject;

import java.time.*;
import java.util.Hashtable;
import java.util.Scanner;

public class projectManager {
	public static void main (String[] args) {
		menu();
		Scanner menu1 = new Scanner(System.in);
		String user = menu1.nextLine();
		Scanner input1 = new Scanner(System.in);
		String attribute;
		int user_in = Integer.parseInt(user);
		
		// Dictionary that links the project name and project number.
		Hashtable<String, Integer> projectID = new Hashtable<>();
		Hashtable<Integer, project> projectDict = new Hashtable<>();
		// key variable to access projectDict values
		int key;
				
		// Dictionaries to store personnel objects.
		Hashtable<String, personnel> customer = new Hashtable<>();
		Hashtable<String, personnel> architect = new Hashtable<>();
		Hashtable<String, personnel> contractor = new Hashtable<>();
		
		// Project number tracker.
		int projectNum = 0;
		
		// Parameters array will populate attribute of a project object.
		String[] parameters = new String[11];
		
		// firstName and lastName variables to capture full name for personnel objects.
		String firstName;
		String lastName = "";
		String fullName;
		
		// personObj stores new personnel objects to be added to a dictionary. 
		personnel personObj;
		// projObj stores new project objects to be added to a dictionary.
		project projObj;
		
		// Array for personnel details for personnel object creation.
		String[] personDetails = {"Enter phone number: ","Enter email address: "
				,"Enter address: ","Enter role: "};
		
		// Array of project parameter questions.
		String[] questions = {"Enter customer name: ", "Enter architect: ", "Enter contractor: "
				, "Enter building type: ", "Enter ERF number: ", "Enter address: "
				, "Enter project name (or 'default'): ", "Project Fee: R", "Amount paid: R", "Duedate (YYYY-MM-DD): "};
		
		
		int choice;
		
		
        //Poise project management block
		while(user_in != 7) {
			
			
			// New project creation block
			if (user_in == 1) {
				// Project number variable incremented with each new project created.
				projectNum++; 
				// Project number added to parameters array.
				parameters[0] = String.valueOf(projectNum);
				
				for (int i = 0; i < questions.length; i++) {
					
					System.out.println(questions[i]);
					
					// Customer name block.
					if (i == 0) {
						
						System.out.println("First name: ");
						firstName = input1.nextLine().strip();
						System.out.println("Last Name: ");
						lastName = input1.nextLine().strip();
						parameters[i + 1] = firstName + " " + lastName;
						
						// Block creates new personnel object
						// when entered name does not match an existing customer.
						if (customer.containsKey(parameters[i+1]) == false) {
							
							System.out.println("\nNEW CUSTOMER\nEnter customer details: ");
							String[] details = new String[5]; // Array stores personnel attributes.
							details[0] = parameters[i + 1];  
							
							// Loop block populates details array, by user input.
							for (int j = 0; j < personDetails.length; j++) {
								
								if (personDetails.length - 1 == j) {
									details[j + 1] = "Customer";
									
								} else {
							
								    System.out.println(personDetails[j]);
							        details[j + 1] = input1.nextLine().strip();
							}
							
							
						}   // Personnel object created and added to person dictionary.
							personObj = new personnel(details[0],details[1],
									details[2],details[3],details[4]);
							
							customer.put(parameters[i+1], personObj);
							System.out.println("\n");
							}   
						
						// Architect name block.
						} else if (i == 1) {
						
						System.out.println("First name: ");
						firstName = input1.nextLine().strip();
						System.out.println("Last Name: ");
						lastName = input1.nextLine().strip();
						parameters[i + 1] = firstName + " " + lastName;
						
						// Block creates new personnel object
						// when entered name does not match an existing architect.
						if (architect.containsKey(parameters[i+1]) == false) {
							
							System.out.println("\nNEW ARCHITECT\nEnter architect details: ");
							String[] details = new String[5]; // Array stores personnel attributes.
							details[0] = parameters[i + 1];
							
							// Loop block populates details array, by user input.
							for (int j = 0; j < personDetails.length ; j++) {
								
								if (personDetails.length - 1 == j) {
									details[j + 1] = "Architect";
									
								} else {
							
								    System.out.println(personDetails[j]);
							        details[j + 1] = input1.nextLine().strip();
							        }
								
						}   // Personnel object created and added to person dictionary.
							personObj = new personnel(details[0],details[1],
									details[2],details[3],details[4]);
							
							architect.put(parameters[i+1], personObj);
							System.out.println("\n");
							}
					  	
					  // Contractor name block.
					} else if ( i == 2 ) {

						System.out.println("First name: ");
						firstName = input1.nextLine().strip();
						System.out.println("Last Name: ");
						lastName = input1.nextLine().strip();
						parameters[i + 1] = firstName + " " + lastName;
						
						// Block creates new personnel object
						// when entered name does not match an existing contractor.
						if (contractor.containsKey(parameters[i+1]) == false) {
							
							System.out.println("\nNEW CONTRACTOR\nEnter contractor details: ");
							String[] details = new String[5];
							details[0] = parameters[i + 1];
							
							for (int j = 0; j < personDetails.length ; j++) {
								// Role entry of attribute.
								if (personDetails.length - 1 == j) {
									details[j + 1] = "Contractor";
									
								} else {
							
								    System.out.println(personDetails[j]);
							        details[j + 1] = input1.nextLine().strip();
							        }
								
								// Personnel object created and added to person dictionary.
							    } personObj = new personnel(details[0],details[1],
									details[2],details[3],details[4]);
							    
							      contractor.put(parameters[i + 1], personObj);
							      System.out.println("\n");
							      }
						
						// Project name block	
						} else if(i == 6) {
						
						attribute = input1.nextLine().strip();
						
						// Block uses build type and last name of customer
						// to name the project if no string given or when default
						// is entered by user.
						if (attribute == "" || attribute == "default") {							
						    parameters[i + 1] = parameters[3] + " " + lastName;
						    projectID.put(parameters[i + 1], projectNum);
						    
						  // User given project name is added to the projectID dictionary.  
						} else {
							
							parameters[i + 1] = attribute;
							projectID.put(attribute, projectNum);
							}
					  
					  // Else block adds project attribute to parameters array
					  // when none of above conditions are met.	
					} else {
						
						attribute = input1.nextLine().strip();
						parameters[i + 1] = attribute;
						
						}
					}
				  		
				  // New project object created, added to projectDict dictionary.		
				  project object = new project(parameters[0],parameters[1],parameters[2], 
						parameters[3],parameters[4],parameters[5],parameters[6],parameters[7]
								,parameters[8],parameters[9],parameters[10]);
				  projectDict.put(projectNum, object);
			  
				  
			  // Block will let user view all projects later on in development.  
			} else if (user_in == 2) {
			  
			  // Block will allow user to view overdue projects later on in development.
			} else if (user_in == 3) {
				
			  // Block updates details of a project stored in projectDict
			  // dictionary. Projects can be accessed by project name or project number. 	
			} else if (user_in == 4) {
				String projName;
				System.out.println("Enter project name or project number: ");
				input1 = new Scanner(System.in);
			
				if (input1.hasNextInt() == true) {
					key = Integer.parseInt(input1.nextLine().strip());
					while(projectDict.containsKey(key) == false) {
						
						System.out.println("Project number does not exist.\nTry again.");
						key = Integer.parseInt(input1.nextLine().strip());
					}
					updateMenu();
					
				} else {
					
					projName = input1.nextLine().strip();
					// While block checks if project name exists.
					while (projectID.containsKey(projName) == false) {
						System.out.println("Project name does not exist. Check spelling.\nTry again.");
						projName = input1.nextLine().strip();
						
					}
					key = projectID.get(projName);
					updateMenu();
					
				}
				
				choice = Integer.parseInt(input1.nextLine().strip());
				
				// Due date updating block.
				if (choice == 1) {
					
					System.out.println("Enter new due date (YYYY-MM-DD): ");
					String dueDate =  input1.nextLine().strip(); // User input.
					projObj = projectDict.get(key); // Project object retrieved from dictionary.
					projObj.updateDueDate(dueDate); // Due date update.
				  
				  // Amount paid updating block.	
				} else if (choice == 2) {
					
					System.out.println("Enter the current balance: R");
					String currentBal = input1.nextLine().strip(); // User input.
					projObj = projectDict.get(key); // Project object retrieved from dictionary.
					projObj.updateAmountPaid(currentBal); // Amount paid update.

				} 
				
			
			  // Block updates personnel attributes. 
			} else if (user_in == 5) {
				int role = 0;
				
				while (role != 5) {
					
					System.out.println("\nTo update personnel contact deatils pick corresponding number: " 
							+ "\n1 - Architect \n2 - Contractor \n3 - Customer \n5 - Done" + "\n");
					role = Integer.parseInt(input1.nextLine().strip());
					int contact;
					String update;
					
					
					// Architect block.
					if (role == 1) {
						
						System.out.println("\nEnter name of architect: ");
						System.out.println("First name: ");
						firstName = input1.nextLine().strip();
						System.out.println("Last Name: ");
						lastName = input1.nextLine().strip();
						fullName = firstName + " " + lastName;
						
						// Block checks if architect name exists in the architect dictionary.
						// If it does not, user is prompted to enter architect until it matches one in 
						// in the dictionary.
						while (architect.containsKey(fullName) == false) {
							System.out.println("Architect does not exist. Check spelling.");
							System.out.println("First name: ");
							firstName = input1.nextLine().strip();
							System.out.println("Last Name: ");
							lastName = input1.nextLine().strip();
							fullName = firstName + " " + lastName;
						  
						  
						} 
							
						System.out.println("Update: \n1 - Address \n2 - Email address \n3 - Phone number");
						contact = Integer.parseInt(input1.nextLine().strip());
						
						// Block updates address. 
						if (contact == 1) {
							System.out.println("Enter a new address: ");
							update = input1.nextLine().strip(); // New address.
							architect.get(fullName).updateAddress(update); // New address applied.
							
						  // Block updates email address.
						} else if (contact == 2) {
							System.out.println("Enter a new email address: ");
							update = input1.nextLine().strip(); // New email address.
							architect.get(fullName).updateEmailAddress(update); // New email address applied.
							
						  // Block updates phone number.
						} else if (contact == 3) {
							System.out.println("Enter a new phone number: ");
							update = input1.nextLine().strip(); // New phone number.
							architect.get(fullName).updatePhoneNum(update); // New phone number applied.
							}
							
					  
					  // Contractor block.
					} else if (role == 2) {
						
						System.out.println("\nEnter name of contractor: ");
						System.out.println("First name: ");
						firstName = input1.nextLine().strip();
						System.out.println("Last Name: ");
						lastName = input1.nextLine().strip();
						fullName = firstName + " " + lastName;
						
						// Block checks if contractor name exists in the contractor dictionary.
						// If it does not, user is prompted to enter contractor until it matches one in 
						// in the dictionary.
						while (contractor.containsKey(fullName) == false) {
							System.out.println("\nContractor does not exist. Check spelling.");
							System.out.println("First name: ");
							firstName = input1.nextLine().strip();
							System.out.println("Last Name: ");
							lastName = input1.nextLine().strip();
							fullName = firstName + " " + lastName;
							}
						
						System.out.println("\nUpdate: \n1 - Address \n2 - Email address \n3 - Phone number");
						contact = Integer.parseInt(input1.nextLine().strip());
						
						// Block updates address.
						if (contact == 1) {
							System.out.println("\nEnter a new address: ");
							update = input1.nextLine().strip(); // New address.
							contractor.get(fullName).updateAddress(update); // New address applied.
							
						  // Block updates email address.	
						} else if (contact == 2) {
							System.out.println("\nEnter a new email address: ");
							update = input1.nextLine().strip(); // New email address
							contractor.get(fullName).updateEmailAddress(update); // New email address applied
							
						  // Block updates phone number.	
						} else if (contact == 3) {
							System.out.println("\nEnter a new phone number: ");
							update = input1.nextLine().strip(); // New phone number
							contractor.get(fullName).updatePhoneNum(update); // New phone number applied
							
						}
						
					  
					  // Customer block.
					} else if (role == 3) {
						
						System.out.println("\nEnter name of customer: ");
						System.out.println("First name: ");
						firstName = input1.nextLine().strip();
						System.out.println("\nLast Name: ");
						lastName = input1.nextLine().strip();
						fullName = firstName + " " + lastName;
						
						// Block checks if customer name exists in the customer dictionary.
						// If it does not, user is prompted to enter customer until it matches one in 
						// in the dictionary.
						while (customer.containsKey(fullName) == false) {
							System.out.println("\nCustomer does not exist. Check spelling.");
							System.out.println("First name: ");
							firstName = input1.nextLine().strip();
							System.out.println("\nLast Name: ");
							lastName = input1.nextLine().strip();
							fullName = firstName + " " + lastName;
							
						}
						
						System.out.println("\nUpdate: \n1 - Address \n2 - Email address \n3 - Phone number");
						contact = Integer.parseInt(input1.nextLine().strip());
						
						// Block updates address.
						if (contact == 1) {
							
							System.out.println("\nEnter a new address: ");
							update = input1.nextLine().strip(); // New address
							customer.get(fullName).updateAddress(update); // New address applied
						  
						  // Block updates email address.	
						} else if (contact == 2) {
							
							System.out.println("\nEnter a new email address: ");
							update = input1.nextLine().strip(); // New email address
							customer.get(fullName).updateEmailAddress(update); // New email address applied
							
						  // Block updates phone number.
						} else if (contact == 3) {
							
							System.out.println("\nEnter a new phone number: ");
							update = input1.nextLine().strip(); // New phone number
							customer.get(fullName).updatePhoneNum(update); // New phone number applied
							}	
					}
							}
						
				  } else if (user_in == 6) {
					  
					    String projName;
						System.out.println("Enter project name or project number: ");
						Scanner projId = input1; 
					    
						// If statement checks if user input is a number (integer)
						if (projId.hasNextInt() == true) {
							//String strInt = input1.nextLine().strip();
							key = Integer.parseInt(projId.nextLine().strip());
							
							// loop checks if project number exists in projectDict dictionary.
							while(projectDict.containsKey(key) == false) {
								
								System.out.println("Project number does not exist.\nTry again.");
								key = Integer.parseInt(input1.nextLine().strip());
							}
							
							
						} else {
							
							projName = input1.nextLine().strip();
							// While block checks if project name exists.
							while (projectID.containsKey(projName) == false) {
								System.out.println("Project name does not exist. Check spelling.\nTry again.");
								projName = input1.nextLine().strip();
								
							}
							key = projectID.get(projName);
							
						}
						
						// dateNow stores current date
						LocalDateTime dateNow = LocalDateTime.now();
						// Project object being finalized
						projObj = projectDict.get(key);
						// Updating project status to finalized
						projObj.updateStatus("Finalized"); 
						// Setting project completion date
						projObj.updateCompleteDate(dateNow.toLocalDate().toString());
						// Converting string to double 
						double totalFee = Double.parseDouble(projObj.getFee());
						// Converting string to double
						double paid = Double.parseDouble(projObj.getAmountPaid());
						// Converting double difference to string
						String amountDue = (totalFee - paid) + ""; 
						// Personnel object (customer) retrieved from project
						personObj = customer.get(projObj.getCustomer()); 
						
						// Invoice block. Conditional determines if project fee is paid for.
						// If not the, an invoice is printed out.
						if (totalFee - paid > 0.00) {
							
							System.out.println("INVOICE");
							System.out.println("-------------------------------------");
							System.out.println("Customer Details: ");
							System.out.println(personObj.toString());
							System.out.println("-------------------------------------");
							System.out.println("\nAmount due: R" + amountDue);
							System.out.println("-------------------------------------");
							System.out.println("\n\nProject Details ");
							System.out.println("-------------------------------------");
							System.out.println(projObj.toString());
							System.out.println("-------------------------------------");
						
						  // Else block prints project details, when invoice is not generated.
						} else {
							
							projObj.updateAmountPaid(projObj.getFee());
							System.out.println("Project Details\n");
							System.out.println(projObj.toString());
							
						}
					// menu method recalled.	
				  } menu();
	                user = menu1.nextLine();
	                user_in = Integer.parseInt(user);
			}
	}
			
	
// Menu method for project management options.
public static void menu() {
	String options = "\n1 - New project" + "\n2 - View existing projects. (Not available. Coming soon)" 
+ "\n3 - View overdue projects. (Not available. Coming soon)" + "\n4 - Update a project." 
			+ "\n5 - Update personnel details." 
+ "\n6 - Finalize a project"+ "\n7 - Exit"  +"\n\n";
	System.out.println(options);
	
}

// Menu used in "4 - Update a project" 
public static void updateMenu() {
	String options = "1 - Update due date" + "\n2 - Update amount paid";
	System.out.println(options);
}

}

