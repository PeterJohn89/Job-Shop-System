
public class JobAd {
	// JobID, Job title, Employer, number of hours per week, job length
	public String JobID;
	public String JobTitle;
	public String Employer;
	public double HoursPerWeek;
	public int JobLength;

	public void setJobID(String JobID) {
		this.JobID = JobID;
	}

	public void setJobTitle(String JobTitle) {
		this.JobTitle = JobTitle;
	}

	public void setEmployer(String Employer) {
		this.Employer = Employer;
	}

	public void setHoursPerWeek(double HoursPerWeek) {
		this.HoursPerWeek = HoursPerWeek;
	}

	public void setJobLength(int JobLength) {
		this.JobLength = JobLength;
	}

	// Constructor
	public JobAd(String JobID, String JobTitle, String Employer, double HoursPerWeek, int JobLength) {
		this.JobID = JobID;
		this.JobTitle = JobTitle;
		this.Employer = Employer;
		this.HoursPerWeek = HoursPerWeek;
		this.JobLength = JobLength;
	}

	// Print details of Job Ad
	public void printJobAd() {
		System.out.printf("%-25s%-1s\n", "Job Id: ", JobID);
		System.out.printf("%-25s%-1s\n", "Job Title: ", JobTitle);
		System.out.printf("%-25s%-1s\n", "Employer: ", Employer);
		System.out.printf("%-25s%-1s\n", "Hours per Week: ", HoursPerWeek);
		System.out.printf("%-25s%-1s\n", "Job Length ", JobLength + " hrs");
	}

}
