/** @author Shayan Rizvi
 * Top Student class containing name and GPA.
 */

public class TopStudent
{
	private String name;
	private double gpa;
	
	public TopStudent(String firstname, String lastname, double GPA)
	{
		name = lastname + ", " + firstname;
		gpa = GPA;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getGPA()
	{
		return gpa;
	}
}
