import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {

	private CourseDBStructure cds;
	private String courseID;
	private int crn;
	private int numCredits;
	private String roomNum;
	private String instructorName;

	/**
	 * @param id, crn, credits, roomNum, instructor
	 */
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement element = new CourseDBElement(id, crn, credits, roomNum, instructor);
		cds.add(element);
	}

	/**
	 * @param crn
	 * @return CourseDBElement
	 */
	public CourseDBElement get(int crn) throws IOException {
		return cds.get(crn);
	}

	/**
	 * @param input
	 */
	public void readFile(File input) throws FileNotFoundException {
		File file = new File("courses.txt");
		if (file.exists()) {
			Scanner inputFile = new Scanner(file);
			while (inputFile.hasNextLine()) {
				courseID = inputFile.nextLine();
				crn = inputFile.nextInt();
				numCredits = inputFile.nextInt();
				roomNum = inputFile.nextLine();
				instructorName = inputFile.nextLine();
			}
			inputFile.close();
		}
		CourseDBElement element = new CourseDBElement(courseID, crn, numCredits, roomNum, instructorName);
		cds.add(element);
	}

	/**
	 * @return ArrayList<String>
	 */
	public ArrayList<String> showAll() {
		return cds.showAll();
	}
}
