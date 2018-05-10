import java.util.*;
import java.io.*;

/**
 * 
 * @author Shayan Rizvi
 * 
 * Reads input and creates lists of students ordered by student ID.
 * Prints the longest list, the first ten empty lists, and a list of top students.
 * 
 */
public class Program6
{
	public static void bubbleSort(ArrayList<TopStudent> topStudentList) // bubble sort for arraylists
	{
		boolean swapped = true; 
		int j = 0; 
		TopStudent personTemp;
		
		while (swapped)
		{ 
			swapped = false; 
			j++; 
			for (int i = 0; i < topStudentList.size() - j; i++) // for every object in topStudentList
			{
				if (topStudentList.get(i).getName().compareTo(topStudentList.get(i + 1).getName()) > 0)
				{
					personTemp = topStudentList.get(i); 
					topStudentList.set(i, topStudentList.get( i + 1)); // swap positions
					topStudentList.set(i + 1, personTemp);
					
					swapped = true; 
				} // end if
			} // end for
		} // end while
	} // end bubbleSort
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner in = new Scanner(new File("p6input.csv")); // declare input file
		PrintWriter out = new PrintWriter("sr6047yj.txt"); // declare output file

		ArrayList<ArrayList<Student>> masterList = new ArrayList<ArrayList<Student>>(); // initialize master list
		ArrayList<String> emptyList = new ArrayList<String>(); // initialize empty list
		ArrayList<TopStudent> topStudentList = new ArrayList<TopStudent>(); // initialize top student list
		
		for (int i = 0; i <= 999; i++) // create master list of 999 lists
		{
			ArrayList<Student> list = new ArrayList<Student>(); // create sublist
			masterList.add(list); // add sublist to master list
		} // end for
		
		while(in.hasNextLine()) // as long as there is another line in the file
		{
			String fileLine = in.nextLine();  // read in a line of data
			String [] line = fileLine.split(","); // split input and store in a list
			
			String studentID = line[0]; // assign each split input to respective variable
			String firstName = line[1];
			String lastName = line[2];
			double gpa = Double.parseDouble(line[3]);
			int credits = Integer.parseInt(line[4]);
			
			Student newStudent = new Student(studentID, firstName, lastName, gpa, credits); // create new student object
			
			int last3 = Integer.parseInt(studentID.substring(6)); // retrieve last three numbers in student ID
			
			masterList.get(last3).add(newStudent); // add new student object to appropriate list within master list
		} // end while
			
		int longestList = 0; // initialize variables
		int longestLength = 0;
		for(int i = 0; i <= 999; i++) //for every sublist in master list
		{
			if(masterList.get(i).size() > longestLength) // determine longest sublist
			{
				longestList = i;
				longestLength = masterList.get(i).size();
			}
			
			if(masterList.get(i).size() == 0) // find empty sublists within master list
			{
				String listNumber = Integer.toString(i); 
				if(listNumber.length() == 1) // adjust zeroes if needed
				{
					listNumber = "00" + listNumber;
				}
				if(listNumber.length() == 2)
				{
					listNumber = "0" + listNumber;
				}
				emptyList.add(listNumber); // record empty sublist
			}
			
			for(int j = 0; j < masterList.get(i).size(); j++) // for number of objects within the sublist
			{
				if(masterList.get(i).get(j).getGPA() >= 3.95 &&
						masterList.get(i).get(j).getCredits() >= 100) // determine top students
				{
					TopStudent newTopStudent = new TopStudent(masterList.get(i).get(j).getFirstName(), // create new top student object
							masterList.get(i).get(j).getLastName(),
							masterList.get(i).get(j).getGPA());
					topStudentList.add(newTopStudent); // add new top student object to top student list
				}
			} // end for
			
			bubbleSort(topStudentList); // sort top student list
			
		} // end for
		
		String longestListStr = masterList.get(longestList).get(0).getID().substring(6); // retrieve longest sublist number
		out.println("First Longest = " + longestListStr); // print longest sublist number
		for(int i = 0; i < longestLength; i++) // for number of objects within longest sublist
		{
			out.print(masterList.get(longestList).get(i).getID() + "\t"); // print
			out.print(masterList.get(longestList).get(i).getFirstName() + " ");
			out.println(masterList.get(longestList).get(i).getLastName());
		} // end for
		
		out.println();
		out.println("There are " + emptyList.size() + " empty lists."); // print number of empty sublists
		out.println("The first ten empty lists are:");
		
		for(int i = 0; i < 10; i++) // for 10
		{
			out.println(emptyList.get(i)); // print empty sublist number
		} // end for
		
		out.println();
		out.println("List of Top Students:");
		
		for(int i = 0; i < topStudentList.size(); i++) // for number of objects in top student list
		{
			out.printf("%-20s", topStudentList.get(i).getName()); // print
			out.printf("%5.2f", topStudentList.get(i).getGPA());
			out.println();
		} // end for
		
		in.close(); // close input file
		out.close(); // close output file
		
	} // end main

} // end 
