import java.io.File;
import java.util.*;
import java.util.Map.Entry;

public class TownGraphManager implements TownGraphManagerInterface {
	private ArrayList<Town> towns;
	private ArrayList<Road> roads;

	public TownGraphManager() {
		towns = new ArrayList<Town>();
		roads = new ArrayList<Road>();
	}

	public boolean addRoad(String town1, String town2, int weight, String description) {
		Town sourceVertex = new Town(town1);
		Town destinationVertex = new Town(town2);
		sourceVertex.addAdjacentTown(destinationVertex, weight);
		destinationVertex.addAdjacentTown(sourceVertex, weight);
		Road road = new Road(sourceVertex, destinationVertex, weight, description);
		roads.add(road);
		return true;
	}

	public String getRoad(String town1, String town2) {
		Town sourceVertex = null;
		Town destinationVertex = null;
		for (int i = 0; i < towns.size(); i++) {
			if (towns.get(i).getName().equals(town1)) {
				sourceVertex = towns.get(i);
			}
			if (towns.get(i).getName().equals(town2)) {
				destinationVertex = towns.get(i);
			}
		}
		for (Road road : roads) {
			if ((road.getSource().compareTo(sourceVertex) == 0
					&& road.getDestination().compareTo(destinationVertex) == 0)
					|| (road.getDestination().compareTo(sourceVertex) == 0
							&& road.getSource().compareTo(destinationVertex) == 0)) {
				return road.getName();
			}
		}
		return null;
	}

	public boolean addTown(String v) {
		Town town = new Town(v);
		return towns.add(town);
	}

	public boolean containsTown(String v) {
		for (Town town : towns) {
			if (town.getName().compareToIgnoreCase(v) == 0)
				return true;
		}
		return false;
	}

	public boolean containsRoadConnection(String town1, String town2) {
		Town sourceVertex = null;
		Town destinationVertex = null;
		for (int i = 0; i < towns.size(); i++) {
			if (towns.get(i).getName().equals(town1)) {
				sourceVertex = towns.get(i);
			}
			if (towns.get(i).getName().equals(town2)) {
				destinationVertex = towns.get(i);
			}
		}
		for (Road road : roads) {
			if (road.contains(sourceVertex) && road.contains(destinationVertex))
				return true;
		}
		return false;
	}

	public ArrayList<String> allRoads() {
		ArrayList<String> result = new ArrayList<String>();
		for (int i = 0; i < roads.size(); i++) {
			result.add(roads.get(i).getName());
		}
		return result;
	}

	public boolean deleteRoadConnection(String town1, String town2, String road) {
		Town sourceVertex = null;
		Town destinationVertex = null;
		for (int i = 0; i < towns.size(); i++) {
			if (towns.get(i).getName().equals(town1)) {
				sourceVertex = towns.get(i);
			}
			if (towns.get(i).getName().equals(town2)) {
				destinationVertex = towns.get(i);
			}
		}

		Road r = new Road(sourceVertex, destinationVertex, road);
		return roads.remove(r);
	}

	public boolean deleteTown(String v) {
		Town sourceVertex = null;
		for (int i = 0; i < towns.size(); i++) {
			if (towns.get(i).getName().equals(v)) {
				sourceVertex = towns.get(i);
			}
		}
		return towns.remove(sourceVertex);
	}

	public ArrayList<String> allTowns() {
		ArrayList<String> result = new ArrayList<String>();
		for (int i = 0; i < towns.size(); i++) {
			result.add(towns.get(i).getName());
		}
		return result;
	}

	public ArrayList<String> getPath(String town1, String town2) {
		Town sourceVertex = new Town(town1);
		Town destinationVertex = new Town(town2);
		dijkstraShortestPath(sourceVertex);
		ArrayList<String> sp = new ArrayList<String>();
		LinkedList<Town> listOfTowns = destinationVertex.getShortestPath();
		for (int i = 0; i < listOfTowns.size(); i++) {
			sp.add(listOfTowns.get(i).toString());
		}
		sp.add(destinationVertex.toString());
		return sp;
	}

	public void dijkstraShortestPath(Town sourceVertex) {
		sourceVertex.setDistance(0);
		Set<Town> setOfTowns1 = new HashSet<>();
		Set<Town> setOfTowns2 = new HashSet<>();
		setOfTowns2.add(sourceVertex);
		while (setOfTowns2.size() != 0) {
			Town currentTown = getLowestDistanceTown(setOfTowns2);
			setOfTowns2.remove(currentTown);
			for (Entry<Town, Integer> entry : currentTown.getAdjacentTowns().entrySet()) {
				Town adjTown = entry.getKey();
				Integer edgedistance = entry.getValue();
				if (!setOfTowns1.contains(adjTown)) {
					findMinDistance(adjTown, edgedistance, currentTown);
					setOfTowns2.add(adjTown);
				}
			}
			setOfTowns1.add(currentTown);
		}
	}

	private static Town getLowestDistanceTown(Set<Town> setOfTowns) {
		Town lowDistanceTown = null;
		int lowDistance = Integer.MAX_VALUE;
		for (Town town : setOfTowns) {
			int townDistance = town.getDistance();
			if (townDistance < lowDistance) {
				lowDistance = townDistance;
				lowDistanceTown = town;
			}
		}
		return lowDistanceTown;
	}

	private static void findMinDistance(Town evaluationTown, Integer edgeWeigh, Town sourceTown) {
		Integer sourceTownDistance = sourceTown.getDistance();
		if (sourceTownDistance + edgeWeigh < evaluationTown.getDistance()) {
			evaluationTown.setDistance(sourceTownDistance + edgeWeigh);
			LinkedList<Town> sp = new LinkedList<>(sourceTown.getShortestPath());
			sp.add(sourceTown);
			evaluationTown.setShortestPath(sp);
		}
	}

	public Town getTown(String name) {
		Town town = new Town(name);
		return town;
	}

	public void populateTownGraph(File selectedFile) {

	}
}
