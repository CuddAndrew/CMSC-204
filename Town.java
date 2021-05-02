
/**
 * Represents an town as a node of a graph. The Town class holds the name of the town and a list of adjacent towns, and other fields as desired, and the traditional methods (constructors, getters/setters, toString, etc.). It will implement the Comparable interface These are the minimum methods that are needed. Please feel free to add as many methods as you need.
 */
import java.util.*;

public class Town implements Comparable<Town> {
	private String nameOfTown;
	private Map<Town, Integer> adjacentTowns;
	private LinkedList<Town> shortestPath;
	private Integer distance;

	// Constructor. Requires town's name.
	public Town(String nameOfTown) {
		this.nameOfTown = nameOfTown;
		this.adjacentTowns = new HashMap<Town, Integer>();
		this.shortestPath = new LinkedList<Town>();
		this.distance = Integer.MAX_VALUE;
	}

	// Copy Constructor
	public Town(Town templateTown) {
		this.nameOfTown = templateTown.getName();
		this.adjacentTowns = templateTown.getAdjacentTowns();
		this.shortestPath = templateTown.getShortestPath();
		this.distance = templateTown.getDistance();
	}

	/**
	 * Returns the town's name
	 * 
	 * @return town's name
	 */
	public String getName() {
		return nameOfTown;
	}

	/**
	 * @return 0 if names are equal, a positive or negative number if the names are
	 *         not equal
	 */
	public int compareTo(Town o) {
		if (nameOfTown.compareToIgnoreCase(o.nameOfTown) > 0)
			return 1;
		else if (nameOfTown.compareToIgnoreCase(o.nameOfTown) < 0)
			return -1;
		else
			return 0;
	}

	/**
	 * To String method
	 * 
	 * @return the town name
	 */
	public String toString() {
		return nameOfTown;
	}

	/**
	 * @return the hashcode for the name of the town.
	 */
	public int getHashCode() {
		return adjacentTowns.hashCode();
	}

	/**
	 * @param town
	 * @return true if the town names are equal, false if not
	 */
	public boolean equals(Town town) {
		if (town.getName().equals(getName())) {
			return true;
		}
		return false;
	}

	/**
	 * Returns adjacentTowns
	 * 
	 * @return adjacentTowns
	 */
	public Map<Town, Integer> getAdjacentTowns() {
		return adjacentTowns;
	}

	/**
	 * sets the name of a town
	 * 
	 * @param nameOfTown
	 */
	public void setName(String nameOfTown) {
		this.nameOfTown = nameOfTown;
	}

	/**
	 * sets adjacent towns
	 * 
	 * @param AdjTowns
	 */
	public void setAdjTowns(Map<Town, Integer> AdjTowns) {
		this.adjacentTowns = AdjTowns;
	}

	/**
	 * ads an adjacent town
	 * 
	 * @param destinationTown
	 * @param distance
	 */
	public void addAdjacentTown(Town destinationTown, int distance) {
		this.adjacentTowns.put(destinationTown, distance);
	}

	/**
	 * returns the shortest path
	 * 
	 * @return shortestPath
	 */
	public LinkedList<Town> getShortestPath() {
		return shortestPath;
	}

	/**
	 * sets the distance
	 * 
	 * @param distance
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}

	/**
	 * returns the distance
	 * 
	 * @return distance
	 */
	public int getDistance() {
		return distance;
	}

	/**
	 * sets the shortest path
	 * 
	 * @param shortestPath
	 */
	public void setShortestPath(LinkedList<Town> shortestPath) {
		this.shortestPath = shortestPath;
	}
}