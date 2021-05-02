import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Road_Student_Test {
	private Road road;
	private Town town = new Town("Silver Spring");
	private Town town2 = new Town("Rockville");
	@Before
	public void setUp() throws Exception {
		road = new Road(town, town2, 1, "270");
	}

	@After
	public void tearDown() throws Exception {
		road = null;
	}

	@Test
	public void testContains() {
		assertEquals(true, road.contains(town));
	}

	@Test
	public void testToString() {
		assertEquals("Silver Spring - Rockville", road.toString());
	}
	
	@Test
	public void testGetName() {
		assertEquals("270", road.getName());
	}
	
	@Test
	public void testGetDestination() {
		assertEquals(town2, road.getDestination());
	}
	
	@Test
	public void testGetSource() {
		assertEquals(town, road.getSource());
	}
	
	@Test
	public void testEquals() {
		assertEquals(true, road.equals(road));
	}
}
