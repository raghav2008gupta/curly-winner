package com.example.priorityQueueTest;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.example.priorityQueue.service.PriorityQueue;

/**
 * PriorityQueueTestsForNonEmptyQueue.java - A class for running unit test cases
 * on the PriorityQueue class for non empty queue. The test cases are executed
 * in a fixed chronological order denoted by the first 5 letters of the method
 * name (testA, testB, etc). Being singleton, PriorityQueue class can have only
 * a single instance thereby forcing an order for the test cases.
 *
 * @author Raghav Gupta
 * @version 1.0
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PriorityQueueTestsForNonEmptyQueue {

	/** Object of type PriorityQueue */
	private PriorityQueue priorityQueue;

	/**
	 * Retrieves the instance of PriorityQueue before execution of test cases
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		priorityQueue = PriorityQueue.getInstance();
	}

	/**
	 * Test method for
	 * {@link com.example.priorityQueue.service.PriorityQueue#enqueue(long, long)}. Testing
	 * with random list of IDs and dateTime values generated in Excel
	 */
	@Test
	public void testAEnqueueWithRandomData() {
		boolean result = true;
		long[] id = { 12088759803L, 34588725084L, 80842806155L, 111358965013L, 125765544506L, 162577145453L,
				170229718242L, 182886607971L, 246037442775L, 308592724561L, 316799572856L, 317414121682L, 332288519112L,
				339074639461L, 386412336176L, 409135488414L, 415429841945L, 447386722599L, 449046393991L, 466966510666L,
				472149153629L, 504685053298L, 524805092682L, 559956616239L, 587939361520L, 653350848180L, 663221318738L,
				698032193059L, 739481561952L, 749280136861L, 749642342899L, 755582148520L, 766451628175L, 782040967832L,
				789602895481L, 799272862638L, 807594113458L, 831692741138L, 843960375228L, 844701846156L, 850571678043L,
				854649960063L, 873118299954L, 880479761739L, 916664047480L, 945525605414L, 990269851000L,
				99999999999960L, 99999999999975L, 99999999999990L };
		long[] dateTime = { 21L, 75L, 51L, 16L, 73L, 47L, 34L, 15L, 43L, 36L, 72L, 19L, 81L, 17L, 85L, 13L, 47L, 29L,
				71L, 90L, 83L, 18L, 59L, 79L, 43L, 38L, 86L, 13L, 27L, 28L, 30L, 90L, 56L, 27L, 47L, 60L, 39L, 39L, 81L,
				78L, 54L, 53L, 15L, 16L, 11L, 15L, 27L, 97L, 21L, 43L };
		for (int i = 0; i < id.length; i++) {
			result &= priorityQueue.enqueue(id[i], dateTime[i]);
		}
		assertTrue(result);
	}

	/**
	 * Test method for {@link com.example.priorityQueue.service.PriorityQueue#getListOfID()}.
	 * Testing with random list of IDs and dateTime values generated in Excel
	 */
	@Test
	public void testBGetListOfIDWithForNonEmptyQueue() {
		long[] id = { 99999999999990L, 99999999999975L, 99999999999960L, 653350848180L, 246037442775L, 990269851000L,
				945525605414L, 916664047480L, 880479761739L, 873118299954L, 854649960063L, 850571678043L, 844701846156L,
				843960375228L, 831692741138L, 807594113458L, 799272862638L, 789602895481L, 782040967832L, 766451628175L,
				755582148520L, 749642342899L, 749280136861L, 739481561952L, 698032193059L, 663221318738L, 587939361520L,
				559956616239L, 524805092682L, 504685053298L, 472149153629L, 466966510666L, 449046393991L, 447386722599L,
				415429841945L, 409135488414L, 386412336176L, 339074639461L, 332288519112L, 317414121682L, 316799572856L,
				308592724561L, 182886607971L, 170229718242L, 162577145453L, 125765544506L, 111358965013L, 80842806155L,
				34588725084L, 12088759803L };
		LinkedList<Long> expected = new LinkedList<Long>();
		for (long l : id)
			expected.add(l);
		assertEquals(expected, priorityQueue.getListOfID());
	}

	/**
	 * Test method for
	 * {@link com.example.priorityQueue.service.PriorityQueue#getPositionOfID(long)}.
	 * Validates method execution on empty queue
	 */
	@Test
	public void testCGetPositionOfIDForNonEmptyQueue() {
		assertEquals(5, priorityQueue.getPositionOfID(990269851000L));
	}

	/**
	 * Test method for {@link com.example.priorityQueue.service.PriorityQueue#dequeue()}.
	 * Validates method execution on empty queue
	 */
	@Test
	public void testDDequeueForNonEmptyQueue() {
		assertEquals(99999999999990L, priorityQueue.dequeue().getID());
	}

	/**
	 * Test method for
	 * {@link com.example.priorityQueue.service.PriorityQueue#removeID(long)}. Validates
	 * method execution on empty queue
	 */
	@Test
	public void testERemoveForNonEmptyQueue() {
		assertTrue(priorityQueue.removeID(653350848180L));
	}
}
