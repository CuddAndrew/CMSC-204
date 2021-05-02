import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Town_STUDENT_Test {
	private Town town;
	private Town town2;
	
	@Before
	public void setUp() throws Exception {
		town = new Town("Silver Spring");
		town2 = new Town("Rockville");
	}

	@After
	public void tearDown() throws Exception {
		town = null;
		town2 = null;
	}

	@Test
	public void testGetName() {
		assertEquals("Silver Spring", town.getName());
	}

	@Test
	public void testToString() {
		assertEquals("Silver Spring", town.toString());
	}
	
	@Test
	public void testGetHashCode() {
		assertEquals(0, town.getHashCode());
	}
	
	@Test
	public void testEquals() {
		assertEquals(false, town.equals(town2));
	}
}
