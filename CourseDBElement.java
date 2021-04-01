/**
 * Class: CMSC204 
 * Instructor: Alexander
 * Description: This program creates course elements and performs tasks on it.
 * Due: 3/31/2021
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Andrew Cudd  
 * @author Andrew Cudd
*/
public class CourseDBElement implements Comparable<Object>{
	private String courseID;
	private int crn;
	private int numCredits;
	private String roomNum;
	private String instructorName;
	CourseDBElement(String courseID, int crn, int numCredits, String roomNum, String instructorName){
		this.courseID = courseID;
		this.crn = crn;
		this.numCredits = numCredits;
		this.roomNum = roomNum;
		this.instructorName = instructorName;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	public String getCourseID() {
		return courseID;
	}
	public int getCRN() {
		return crn;
	}
	public int getNumCredits() {
		return numCredits;
	}
	public String getRoomNum() {
		return roomNum;
	}
	public String getInstructorName() {
		return instructorName;
	}
}
