
public class CourseworkStudent extends Student {

	public CourseworkStudent(String studentId, String studentName, String programEnrolled, String jobID,
			String jobTitle, double currentWorkingHours, String companyName, int jobLength) {

		// --Super Constructor is used to call the superclass
		super(studentId, studentName, programEnrolled, jobID, jobTitle, currentWorkingHours, companyName, jobLength);
		
	}
	
	
	public double addJobHours(double hours, boolean inHolidayPeriod, int length) throws JobException {
		
		if(inHolidayPeriod == true && length > 1) {	
			
			if (hours < 168.00) {
				currentWorkingHours = +hours;
			} else {
				throw new JobException("Sorry " + hours + "is too enought hours for this job");
			}
			
		} else if(inHolidayPeriod == false) {
			super.addJobHours(hours, inHolidayPeriod);
		}
		
		return hours;
	}

}
