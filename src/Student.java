
public class Student {

	// --Class Attributes
	public String studentId;
	public String studentName;
	public String programEnrolled;
	public String jobID;
	public String jobTitle;
	public double currentWorkingHours;
	public String companyName;
	public int jobLength;

	// --All set methods for Student Class
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void setStudentProgram(String programEnrolled) {
		this.programEnrolled = programEnrolled;
	}

	public void setJobID(String jobID) {
		this.jobID = jobID;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public void setCurrentWorkHours(double currentWorkingHours) {
		this.currentWorkingHours = currentWorkingHours;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setJobLength(int jobLength) {
		this.jobLength = jobLength;
	}

	// --Student Constructor
	public Student(String studentId, String studentName, String programEnrolled, String jobID, String jobTitle,
			double currentWorkingHours, String companyName, int jobLength) {

		this.studentId = studentId;
		this.studentName = studentName;
		this.programEnrolled = programEnrolled;
		this.jobID = jobID;
		this.jobTitle = jobTitle;
		this.currentWorkingHours = currentWorkingHours;
		this.companyName = companyName;
		this.jobLength = jobLength;
	}

	public double addJobHours(double hours, boolean inHolidayPeriod) throws JobException {
		if (hours < 20.00) {
			currentWorkingHours = -hours;
		} else {
			throw new JobException("Sorry " + hours + " is too enought hours for this job");
		}
		return hours;
	}

	// --Print all students details
	public void printStudentDetails() {

		System.out.printf("%-25s%-1s\n", "Students Id: ", studentId);
		System.out.printf("%-25s%-1s\n", "Students name: ", studentName);
		System.out.printf("%-25s%-1s\n", "Program: ", programEnrolled);
		System.out.printf("%-25s%-1s\n", "Job: ", jobTitle);
		System.out.printf("%-25s%-1s\n", "Current working hours ", currentWorkingHours + " hrs");
		System.out.printf("%-25s%-1s\n", "Employer: ", companyName);

	}

}
