/**
 * The class Road that can represent the edges of a Graph of Towns. The class
 * must implement Comparable. The class stores references to the two
 * vertices(Town endpoints), the degrees between vertices, and a name, and the
 * traditional methods (constructors, getters/setters, toString, etc.), and a
 * compareTo, which compares two Road objects. Since this is a undirected graph,
 * an edge from A to B is equal to an edge from B to A.
 */
public class Road implements Comparable<Road> {
	private Town source;
	private Town destination;
	private int degrees;
	private String name;

	// Constructor
	public Road(Town source, Town destination, int degrees, String name) {
		this.source = source;
		this.destination = destination;
		this.degrees = degrees;
		this.name = name;
	}

	// Constructor with weight preset at 1
	public Road(Town source, Town destination, String name) {
		this.source = source;
		this.destination = destination;
		this.degrees = 1;
		this.name = name;
	}

	/**
	 * Returns true only if the edge contains the given town
	 * 
	 * @param town - a vertex of the graph
	 * @return true only if the edge is connected to the given vertex
	 */
	public boolean contains(Town town) {
		return (source.compareTo(town) == 0 || destination.compareTo(town) == 0);
	}

	/**
	 * To string method
	 */
	public String toString() {
		return source.getName() + " - " + destination.getName();
	}

	/**
	 * Returns the road name
	 * 
	 * @return The name of the road
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the second town on the road
	 * 
	 * @return A town on the road
	 */
	public Town getDestination() {
		return destination;
	}

	/**
	 * Returns the first town on the road
	 * 
	 * @return A town on the road
	 */
	public Town getSource() {
		return source;
	}

	/**
	 * @return 0 if the road names are the same, a positive or negative number if
	 *         the road names are not the same
	 */
	public int compareTo(Road o) {
		if (this.degrees < (o.degrees))
			return -1;
		else if (this.degrees > (o.degrees))
			return 1;
		else
			return 0;
	}

	/**
	 * Returns the distance of the road
	 * 
	 * @return the distance of the road
	 */
	public int getWeight() {
		return degrees;
	}

	/**
	 * Returns true if each of the ends of the road r is the same as the ends of
	 * this road. Remember that a road that goes from point A to point B is the same
	 * as a road that goes from point B to point A.
	 * @param r - road object to compare it to
	 */
	public boolean equals(Road r) {
		if (r.getSource().equals(source)) {
			if(r.getDestination().equals(destination)) {
				return true;
			}
		}
		else if (r.getSource().equals(destination)) {
			if(r.getDestination().equals(source)) {
				return true;
			}
		}
		return false;
	}

}