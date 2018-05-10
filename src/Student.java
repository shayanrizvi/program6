/** @author Shayan Rizvi
 * Student class containing student ID, first name, last name, GPA, and completed credits.
 */

public class Student
{
	private String studentID;
	private String firstName;
	private String lastName;
	private double gpa;
	private int credits;
	
	public Student(String id, String firstname, String lastname, double GPA, int completedCredits)
	{
		studentID = id;
		firstName = firstname;
		lastName = lastname;
		gpa = GPA;
		credits = completedCredits;
	}
	
	public String getID()
	{
		return studentID;
	}
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public double getGPA()
	{
		return gpa;
	}
	
	public int getCredits()
	{
		return credits;
	}
}
