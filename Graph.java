
// Graph class implementation
import java.util.*;
import java.util.Map.Entry;

public class Graph implements GraphInterface<Town, Road> {

	private Set<Town> towns;
	private Set<Road> roads;

	public Graph() {
		towns = new HashSet<Town>();
		roads = new HashSet<Road>();
	}

	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		for (Road road : roads) {
			if ((road.getSource().compareTo(sourceVertex) == 0
					&& road.getDestination().compareTo(destinationVertex) == 0)
					|| (road.getDestination().compareTo(sourceVertex) == 0
							&& road.getSource().compareTo(destinationVertex) == 0)) {
				return road;
			}
		}
		return null;
	}

	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Road road = new Road(sourceVertex, destinationVertex, weight, description);
		roads.add(road);
		sourceVertex.addAdjacentTown(destinationVertex, weight);
		destinationVertex.addAdjacentTown(sourceVertex, weight);
		return road;
	}

	public boolean addVertex(Town v) {
		return towns.add(v);
	}

	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		for (Road road : roads) {
			if (road.contains(sourceVertex) && road.contains(destinationVertex)) {
				return true;
			}
		}
		return false;
	}

	public boolean containsVertex(Town v) {
		for (Town town : towns) {
			if (town.getName().compareToIgnoreCase(v.getName()) == 0) {
				return true;
			}
		}
		return false;
	}

	public Set<Road> edgeSet() {
		return roads;
	}

	public Set<Road> edgesOf(Town v) {
		Set<Road> list = new HashSet<Road>();
		for (Road road : this.roads) {
			if (road.contains(v)) {
				list.add(road);
			}
		}
		return list;
	}

	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Road road = new Road(sourceVertex, destinationVertex, weight, description);
		roads.remove(road);
		return road;
	}

	public boolean removeVertex(Town v) {
		return towns.remove(v);
	}

	public Set<Town> vertexSet() {
		return towns;
	}

	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		dijkstraShortestPath(sourceVertex);
		ArrayList<String> list = new ArrayList<String>();
		LinkedList<Town> listOfTowns = destinationVertex.getShortestPath();
		for (int i = 0; i < listOfTowns.size(); i++) {
			list.add(listOfTowns.get(i).toString());
		}
		list.add(destinationVertex.toString());
		return list;
	}

	public void dijkstraShortestPath(Town sourceVertex) {
		sourceVertex.setDistance(0);
		Set<Town> list1 = new HashSet<>();
		Set<Town> list2 = new HashSet<>();
		list2.add(sourceVertex);
		while (list2.size() != 0) {
			Town currentTown = getLow(list2);
			list2.remove(currentTown);
			for (Entry<Town, Integer> entry : currentTown.getAdjacentTowns().entrySet()) {
				Town adjTown = entry.getKey();
				Integer edgedistance = entry.getValue();
				if (!list1.contains(adjTown)) {
					getMin(adjTown, edgedistance, currentTown);
					list2.add(adjTown);
				}
			}
			list1.add(currentTown);
		}
	}

	private static Town getLow(Set<Town> list) {
		Town low = null;
		int lowInt = Integer.MAX_VALUE;
		for (Town town : list) {
			int townDistance = town.getDistance();
			if (townDistance < lowInt) {
				lowInt = townDistance;
				low = town;
			}
		}
		return low;
	}

	private static void getMin(Town town, Integer edge, Town sourceTown) {
		Integer sourceTownDistance = sourceTown.getDistance();
		if (sourceTownDistance + edge < town.getDistance()) {
			town.setDistance(sourceTownDistance + edge);
			LinkedList<Town> list = new LinkedList<>(sourceTown.getShortestPath());
			list.add(sourceTown);
			town.setShortestPath(list);
		}
	}
}