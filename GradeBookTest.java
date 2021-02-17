package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	GradeBook one;
	GradeBook two;
	@BeforeEach
	void setUp() throws Exception {
		one = new GradeBook(5);
		two = new GradeBook(5);
		one.addScore(80);
		one.addScore(70);
		two.addScore(95);
		two.addScore(85);
		two.addScore(75);
	}

	@AfterEach
	void tearDown() throws Exception {
		one = null;
		two = null;
	}

	@Test
	void testAddScore() {
		assertTrue(one.toString().equals("80.0 70.0 0.0 0.0 0.0 "));
		assertTrue(two.toString().equals("95.0 85.0 75.0 0.0 0.0 "));
	}
	
	@Test
	void testSum() {
		assertEquals(150, one.sum(), .0001);
		assertEquals(255, two.sum(), .0001);
	}
	
	@Test
	void testMinimum() {
		assertEquals(70, one.minimum(), .001);
		assertEquals(75, two.minimum(), .001);
	}
	
	@Test
	void testFinalScore() {
		assertEquals(80, one.finalScore(), .001);
		assertEquals(180, two.finalScore(), .001);
	}
}
