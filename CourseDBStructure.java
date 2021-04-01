import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface {
	protected int tableSize;
	LinkedList<CourseDBElement>[] hashTable;

	/**
	 * Use the hashcode of the CourseDatabaseElement to see if it is in the
	 * hashtable.
	 * 
	 * If the CourseDatabaseElement does not exist in the hashtable, add it to the
	 * hashtable.
	 * 
	 * @param element the CDE to be added
	 */
	CourseDBStructure(int tableSize) {
		this.tableSize = tableSize;
	}

	CourseDBStructure(String str, int tableSize) {
		this.tableSize = tableSize;
	}

	/**
	 * @param element
	 */
	public void add(CourseDBElement element) {
		int num = Math.abs(element.hashCode()) % tableSize;
		LinkedList<CourseDBElement> cdeList = hashTable[num];
		if (cdeList == null) {
			hashTable[num] = new LinkedList<CourseDBElement>();
		}
		hashTable[num].add(element);
	}

	/**
	 * Use the hashcode of the CourseDatabaseElement to see if it is in the
	 * hashtable.
	 * 
	 * If the CourseDatabaseElement is in the hashtable, return it If not, throw an
	 * IOException
	 * 
	 * @param element the CDE to be added
	 * @throws IOException
	 */
	
	/**
	 * @param crn
	 * @return next
	 */
	public CourseDBElement get(int crn) throws IOException {
		for (int i = 0; i < tableSize; i++) {
			if (hashTable[i] != null) {
				LinkedList<CourseDBElement> list = hashTable[i];
				for (CourseDBElement next : list) {
					if (next.getCRN() == crn) {
						return next;
					}
				}
			}
		}
		return null;
	}

	/**
	 * @return arrList
	 */
	public ArrayList<String> showAll() {
		ArrayList<String> arrList = new ArrayList<String>();
		for (int i = 0; i < getTableSize(); i++) {
			if (hashTable[i] != null) {
				LinkedList<CourseDBElement> list = hashTable[i];
				for (CourseDBElement next : list) {
					String str = "\n" + next;
					arrList.add(str);
				}
			}
		}
		return arrList;
	}

	/**
	 * Returns the size of the ConcordanceDataStructure (number of indexes in the
	 * array)
	 */
	public int getTableSize() {
		return tableSize;
	}
}
