
/*
 * class JobShopSystem
 * 
 * Implements the data storage and functional requirements
 * for a menu-driven program that manages casual Job applications.
 * 
 * This is the start-up code for Assignment 3 and you should
 * work off this program - the features described in the
 * specification for Stages 5, 6 and 7 should be implemented in 
 * this class.
 * 
 */

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;


public class JobShopSystem {
	
	private static Student[] studentlist = new Student[20];
	private static boolean inHolidayPeriod = false;

	private static ArrayList<JobAd> JobAdList = new ArrayList<JobAd>();
	//private static ArrayList<JobAd> JobAdList = new ArrayList<JobAd>();
	private static int currentStudent;

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws JobException {
		String selection;

		do {
			
			//--Research Student File reader & Stores in object array
			BufferedReader jaFile = null;
			
			try {

				//--Read from Job Ad to get all jobs
				jaFile = new BufferedReader(new FileReader("JobAd.txt"));
				
				String currLine = jaFile.readLine();
				while (currLine != null) {
					
					String[] splitComma = currLine.split(",");
					//--Create a array and split all String 
					String jobId = splitComma[0];
					String JobTitle = splitComma[1];
					String companyName = splitComma[2];
					String jobHours = splitComma[3];
					String jobLength = splitComma[4];
					
					double workHours = Double.parseDouble(jobHours);
					int jLength = Integer.parseInt(jobLength);
					
					//--After converting to correct Strings to double and int put into JobAd object
					JobAd JobAd = new JobAd(jobId, JobTitle, companyName, workHours, jLength);
					//--Also put into arrayList
					JobAdList.add(JobAd);
					
					currLine = jaFile.readLine();
				}
				jaFile.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			
			//--Course work Student File reader & Stores in object array
			BufferedReader csFile = null;
			
			try {
				//--Read from file
				csFile = new BufferedReader(new FileReader("CourseworkStudent.txt"));
				
				String currLine = csFile.readLine();
				while (currLine != null) {
					
					String[] splitComma = currLine.split(",");
					String studentId = splitComma[0];
					String studentName = splitComma[1];
					String programEnrolled = splitComma[2];
					String jobID = splitComma[3];
					String jobTitle = splitComma[4]; 
					String currentWorkingHours = splitComma[5];
					String companyName = splitComma[6];
					String jobLength = splitComma[7];
					int jLength = Integer.parseInt(jobLength);
					double workHours = Double.parseDouble(currentWorkingHours);
					
					//--Getting all the correct string put into a CourseWorkStudent
					Student StudentObj = new CourseworkStudent(studentId, studentName, programEnrolled, jobID, jobTitle, workHours, companyName, jLength);
					studentlist[currentStudent] = StudentObj;
					currentStudent++;
					
					currLine = csFile.readLine();
				}
				csFile.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			
			//--Research Student Student File reader & Stores in object array
			BufferedReader inFile = null;
			
			try {
				inFile = new BufferedReader(new FileReader("ResearchStudent.txt"));
				
				String currLine = inFile.readLine();
				while (currLine != null) {
					
					String[] splitComma = currLine.split(",");
					String studentId = splitComma[0];
					String studentName = splitComma[1];
					String programEnrolled = splitComma[2];
					String jobID = splitComma[3];
					String jobTitle = splitComma[3]; 
					String currentWorkingHours = splitComma[4];
					String companyName = splitComma[5];
					String jobLength = splitComma[6];
					int jLength = Integer.parseInt(jobLength);
					double workHours = Double.parseDouble(currentWorkingHours);
					
					//--Research Student Object
					Student ResearchStudentObj = new ResearchStudent(studentId, studentName, programEnrolled, jobID, jobTitle, workHours, companyName, jLength);
					studentlist[currentStudent] = ResearchStudentObj;
					currentStudent++;
					currLine = inFile.readLine();
				}
				inFile.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	
			
			
			// display menu options
			System.out.println("   ***** Job Shop System Menu *****\n");
			System.out.println("A. Add New Coursework Student");
			System.out.println("B. Add New Research Student");
			System.out.println("C. View Student (job seeker) Information");
			System.out.println("D. Add New Casual Position");
			System.out.println("E. Apply for a casual Job");
			System.out.println("F. Display Students Report");
			System.out.println("G. View Casual Jobs");
			System.out.println("H. Toggle holiday period");
			System.out.println("X. Exit the program");
			System.out.println();

			// prompt user to enter selection
			System.out.print("Enter selection: ");
			selection = sc.nextLine();

			System.out.println();

			// validate selection input length
			if (selection.length() != 1) {
				System.out.println("Error - invalid selection!");
			} else {

				// process user's selection
				switch (selection.toUpperCase()) {
				case "A":
					addNewCourseworkStudent();
					break;

				case "B":
					addNewResearchStudent();
					break;

				case "C":
					viewStudentInformation();
					break;

				case "D":
					addNewCasualJob();
					break;

				case "E":
					applyCasualJob();
					break;

				case "F":
					displayStudentsReport();
					break;

				case "G":
					viewCasualJobs();
					break;

				case "H":
					toggleHolidayPeriod();
					break;

				case "X":
					System.out.println("Exiting the program...");
					break;

				default:
					System.out.println("Error - invalid selection!");
				}
			}
			System.out.println();
			
		} while (!selection.equalsIgnoreCase("X"));

	}

//	private static Student findAstudent(String ID) {
//
//		/*
//		 * Optional - you can implement code to search for a student and return it here
//		 * (after which the relevant methods below can call this method when they need
//		 * to locate a specific student).
//		 * 
//		 * NOTE: It is also acceptable to implement (repeat) your search code inside
//		 * each of the methods below which need to locate a specific student
//		 * 
//		 */
//
//		return null;
//	}

	private static void addNewCourseworkStudent() {
		/*
		 * Implement application level code to facilitate adding a new course work
		 * Student to the system here.
		 * 
		 * Note that the array in which the collection of Student objects is being
		 * stored and a Scanner called 'sc' have been declared at the top of the class
		 * and you can refer to them here inside this inside method as required.
		 */

		System.out.println("Please enter your student ID Number");
		String studentId = sc.nextLine();

		// --Validation
		while (studentId.isEmpty()) {
			System.out.println("Please enter a vaid Student Id");
			studentId = sc.nextLine();
		}

		// --Get Students full name from user
		System.out.println("Please enter your Full Name");
		String fullName = sc.nextLine();

		// --Validation
		while (fullName.isEmpty()) {
			System.out.println("Please enter a vaid Full Name");
			fullName = sc.nextLine();
		}

		// --Get Students enrolled program
		System.out.println("Please enter your Enrolled Program");
		String programEnrolled = sc.nextLine();

		// --Validation
		while (programEnrolled.isEmpty()) {
			System.out.println("Please enter a vaid Enrolled Program");
			programEnrolled = sc.nextLine();
		}

		// --Insert empty Job information for now, user will override this information
		// later
		String jobID = "N/A";
		String jobTitle = "N/A";
		double currentWorkingHours = 0.0;
		String companyName = "N/A";
		int jobLength = 0;

		// --Add override to job hours
		// --Create a object with the information given by the users
		Student newStudent = new CourseworkStudent(studentId, fullName, programEnrolled, jobID, jobTitle,
				currentWorkingHours, companyName, jobLength);

		// --Insert object -newStudent- into array -StudentArray-
		studentlist[currentStudent] = newStudent;
		// --Adding 1 to currentStudent
		currentStudent += 1;
		
		//--Add new object to file
		try {
			BufferedWriter outFile = new BufferedWriter(new FileWriter("CourseworkStudent.txt", true));
			outFile.write(studentId + "," + fullName + "," + programEnrolled + "," + jobID
					+ "," + jobTitle + "," + currentWorkingHours + "," + companyName + "," + jobLength);
			outFile.newLine();
			outFile.close();
			System.out.println("User Saved....");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


	}

	private static void addNewResearchStudent() {
		/*
		 * Implement application level code to facilitate adding a new research Student
		 * to the system here.
		 * 
		 * Note that the array in which the collection of Student objects is being
		 * stored and a Scanner called 'sc' have been declared at the top of the class
		 * and you can refer to them here inside this inside method as required.
		 */

		// --Get the Research Students id
		System.out.println("Please enter your Research Student Number");
		String researchStudentId = sc.nextLine();

		// --Validation
		while (researchStudentId.isEmpty()) {
			System.out.println("Please enter a vaid Student Id");
			researchStudentId = sc.nextLine();
		}

		// --Get the Research Students Full Name
		System.out.println("Please enter your Full Name");
		String researchFullName = sc.nextLine();

		// --Validation
		while (researchFullName.isEmpty()) {
			System.out.println("Please enter a vaid Full Name");
			researchFullName = sc.nextLine();
		}

		// --Get the Research Students Enrolled Program
		System.out.println("Please enter your Enrolled Program");
		String researchProgramEnrolled = sc.nextLine();

		// --Validation
		while (researchProgramEnrolled.isEmpty()) {
			System.out.println("Please enter a vaid Enrolled Program");
			researchProgramEnrolled = sc.nextLine();
		}

		// --Insert empty Job information for now, user will override this information
		// later
		String researchID = "N/A";
		String researchJobTitle = "N/A";
		double unlimitedWorkingHours = 0.0;
		String researchCompanyName = "N/A";
		int jobLength = 0;

		// --Create a object with the information given by the users
		ResearchStudent newResearchStudent = new ResearchStudent(researchStudentId, researchFullName,
				researchProgramEnrolled, researchID, researchJobTitle, unlimitedWorkingHours, researchCompanyName,
				jobLength);

		// Insert object into
		// array--------------------------------------------------------------------------------------------------
		// newResearchStudent.setCurrentWorkHours(unlimitedWorkingHours);

		// --Insert object -newStudent- into array -StudentArray-
		studentlist[currentStudent] = newResearchStudent;
		// --Adding 1 to currentStudent
		currentStudent += 1;

		
		//--Add new object to file
		try {
			BufferedWriter outFile = new BufferedWriter(new FileWriter("ResearchStudent.txt", true));
			outFile.write(researchStudentId + "," + researchFullName + "," + researchProgramEnrolled + "," + researchID
					+ "," + researchJobTitle + "," + unlimitedWorkingHours + "," + researchCompanyName + ","
					+ jobLength);
			outFile.newLine();
			outFile.close();
			System.out.println("User Saved....");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void viewStudentInformation() {
		/*
		 * Implement application level code to facilitate displaying a student
		 * information given studentID here.
		 * 
		 * Note that the array in which the collection of Student objects is being
		 * stored and a Scanner called 'sc' have been declared at the top of the class
		 * and you can refer to them here inside this inside method as required.
		 */
		// --Get Students Id number from user
		System.out.println("Please enter your student ID");
		String currentStudentId = sc.nextLine();

		// --Validation
		while (currentStudentId.isEmpty()) {
			System.out.println("Please enter a vaid Student Id");
			currentStudentId = sc.nextLine();
		}

		// --While too to search users id with object id
		int x = 0;
		// --This Boolean will check if results are true if false will return a error
		// message
		boolean results = false;
		while (x < currentStudent) {
			// --Check every id in the array that that is equals to the users inputed Id
			if (currentStudentId.toLowerCase().equals(studentlist[x].studentId.toLowerCase())) {
				studentlist[x].printStudentDetails();
				results = true;
			}

			x++;
		}
		// --If no results are returned then error message will appear
		if (results == false) {
			System.out.println("\n Sorry Invalid Id");
		}

	}

	private static void addNewCasualJob() {
		/*
		 * Implement application level code to facilitate adding a new Casual Job to the
		 * system here.
		 * 
		 */

		System.out.println("Please enter the Job ID");
		String JobID = sc.nextLine();

		while (JobID.isEmpty()) {
			System.out.println("Please enter a valid Job ID");
			JobID = sc.nextLine();
		}

		System.out.println("Please enter the Job Title");
		String JobTitle = sc.nextLine();

		while (JobTitle.isEmpty()) {
			System.out.println("Please enter a valid Job Title");
			JobTitle = sc.nextLine();
		}

		System.out.println("Please enter the Employer");
		String Employer = sc.nextLine();

		while (Employer.isEmpty()) {
			System.out.println("Please enter a valid Employer");
			Employer = sc.nextLine();
		}

		System.out.println("Please enter hours per week");
		double HoursPerWeek = sc.nextDouble();

		while (HoursPerWeek == 0.0) {
			System.out.println("Please enter a hours per week");
			HoursPerWeek = sc.nextDouble();
		}

		System.out.println("Please enter the Job Length");
		int JobLength = sc.nextInt();

		while (JobLength == 0.0) {
			System.out.println("Please enter a vaid Job Length");
			JobLength = sc.nextInt();
		}

		
		JobAd JobAd = new JobAd(JobID, JobTitle, Employer, HoursPerWeek, JobLength);
		JobAdList.add(JobAd);
		
		try {
			BufferedWriter outFile = new BufferedWriter(new FileWriter("JobAd.txt", true));
			outFile.write(JobID + "," + JobTitle + "," + Employer + "," + HoursPerWeek + "," + JobLength);
			outFile.newLine();
			outFile.close();
			System.out.println("User Saved....");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void applyCasualJob() throws JobException {
		/*
		 * Implement application level code to facilitate application of a casual Job
		 * here. JobAd objects are stored in the array defined as part of Assignment
		 * requirements
		 * 
		 */
		
		// --Get users id to search for
		System.out.println("Please enter your student ID");
		String currentStudentId = sc.nextLine();

		// --Validation
		while (currentStudentId.isEmpty()) {
			System.out.println("Please enter a vaid Student Id");
			currentStudentId = sc.nextLine();
		}
		
		int x = 0;
		boolean FoundStudentId = false;
		boolean jobValidation = false;
		boolean error = false;
		// --Loop through student array to find the current students ID
		while (x < currentStudent && jobValidation == false) {
		
			// --Check if the current students Id is equal to a Students ID in the Array
			if (currentStudentId.toLowerCase().equals(studentlist[x].studentId.toLowerCase())) {
				
				System.out.println("Please enter the Job ID");
				String JobID = sc.nextLine();

				// --Validation
				while (JobID.isEmpty()) {
					System.out.println("Please enter a vaid Job ID");
					JobID = sc.nextLine();
				}

				
				int i = 0;
				//--Loop through arraylist of jobs
				while (i < JobAdList.size() && jobValidation == false) {
					
					//--Check if the users input matches Array List
					if (JobAdList.get(i).JobID.equals(JobID.toLowerCase())) {
						
						//--Get the job work hours
						double JobHours = JobAdList.get(i).HoursPerWeek;
						
								try {
									//--run add Job Hours to check for errors
									studentlist[x].addJobHours(JobHours, inHolidayPeriod);
									//--If their are no Job Exception code will run 
									studentlist[x].setJobID(JobAdList.get(i).JobID);
									studentlist[x].setJobTitle(JobAdList.get(i).JobTitle);
									studentlist[x].setCompanyName(JobAdList.get(i).Employer);
									studentlist[x].setCurrentWorkHours(JobAdList.get(i).HoursPerWeek);
									studentlist[x].setJobLength(JobAdList.get(i).JobLength);
									
									System.out.println("Congratulations you got the Job");
									//--Remove JobAd for Array List 
									JobAdList.remove(x);

									//--Boolean Validations
									jobValidation = true;
									error = false;
									
								} catch (JobException e) {
									System.out.println(e.getMessage());
									error = true;
								} 
									
					} // --End of Job id if statement
					i++;
				} // -- End of Job Array list while loop
				
				if (jobValidation == false && error == false) {
					System.out.println("Sorry Job doesn't excist");
				}
				
				if(jobValidation == true) {
					try {
						//Enter in Student file
						BufferedWriter outFile = new BufferedWriter(new FileWriter("Students.txt", true));
						
						outFile.write(studentlist[x].studentId + "," + studentlist[x].studentName + "," + studentlist[x].programEnrolled
								+ "," + studentlist[x].jobID + "," + studentlist[x].jobTitle + "," + studentlist[x].currentWorkingHours
								+ "," + studentlist[x].companyName + "," + studentlist[x].jobLength);
						
						
						outFile.newLine();
						outFile.close();
						
						System.out.println("User Saved....");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					
				}
				
				jobValidation = true;
				FoundStudentId = true;
			} // --Check id if statement

	

			x++;
		} // --While loop
		
		if (FoundStudentId == false) {
			System.out.println("Sorry Invalid Student Id");
		}

	}// --applyCasualJob end

	private static void displayStudentsReport() {
		/*
		 * Implement application level code to display Students report currently stored
		 * in the system here. Note that the array in which the collection of student
		 * objects is being stored and a Scanner called 'sc' have been declared at the
		 * top of the class and you can refer to them here inside this inside method as
		 * required.
		 */
		// --While loop throught array
		int x = 0;
		while (x < currentStudent) {
			// --Check every id in the array that that is equals to the users inputed Id
			studentlist[x].printStudentDetails();
			System.out.println("\n");
		x++;
		}

	}

	private static void viewCasualJobs() {
		/*
		 * Implement application level code to display all casual jobs currently stored
		 * in the system here.
		 *
		 */
		for (JobAd show : JobAdList) {
			show.printJobAd();
		}

	}

	private static void toggleHolidayPeriod() {
		/*
		 * Implement application level code to trigger Holiday period. Note: Holiday
		 * period is only 1 month and is between teaching periods.
		 */
		inHolidayPeriod = !(inHolidayPeriod);
		if (inHolidayPeriod == true) {
			System.out.println("Toggle Holiday Period on");
		} else {
			System.out.println("Toggle Holiday Period off");
		}
		

	}

}