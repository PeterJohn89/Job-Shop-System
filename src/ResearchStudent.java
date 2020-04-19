
public class ResearchStudent extends Student {
	// --Constructor for Research Student
	public ResearchStudent(String researchStudentId, String researchStudentName, String researchProgramEnrolled,
			String researchJobID, String studentsJobTitle, double currentWorkingHours, String studentsCompanyName,
			int jobLength) {

		// --Super Constructor is used to call the superclass
		super(researchStudentId, researchStudentName, researchProgramEnrolled, researchJobID, studentsJobTitle,
				currentWorkingHours, studentsCompanyName, jobLength);

	}

	// --Boolean method that checks if students hours are less then 168
	public boolean addJob(double hours) {
		boolean successful = false;
		if (hours > 168.00) {
			successful = true;
		}
		return successful;
	}

}
