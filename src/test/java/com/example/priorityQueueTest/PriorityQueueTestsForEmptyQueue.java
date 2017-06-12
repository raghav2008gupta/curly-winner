package com.example.priorityQueueTest;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import com.example.priorityQueue.service.PriorityQueue;

/**
 * PriorityQueueTestsForEmptyQueue.java - A class for running unit test cases on
 * the PriorityQueue class
 *
 * @author Raghav Gupta
 * @version 1.0
 */
public class PriorityQueueTestsForEmptyQueue {

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
	 * Test method for {@link com.example.priorityQueue.service.PriorityQueue#dequeue()}.
	 * Validates method execution on empty queue
	 */
	@Test
	public void testDequeueOnEmptyQueue() {
		assertNull(priorityQueue.dequeue());
	}

	/**
	 * Test method for
	 * {@link com.example.priorityQueue.service.PriorityQueue#removeID(long)}. Validates
	 * method execution on empty queue
	 */
	@Test
	public void testRemoveOnEmptyQueue() {
		assertFalse(priorityQueue.removeID(1));
	}

	/**
	 * Test method for
	 * {@link com.example.priorityQueue.service.PriorityQueue#getPositionOfID(long)}.
	 * Validates method execution on empty queue
	 */
	@Test
	public void testGetPositionOfIDOnEmptyQueue() {
		assertEquals(-1, priorityQueue.getPositionOfID(1));
	}

	/**
	 * Test method for
	 * {@link com.example.priorityQueue.service.PriorityQueue#getPositionOfID(long)}.
	 * Validates method execution for illegal IDs
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetPositionOfIDForIllegalArguments() {
		priorityQueue.getPositionOfID(0);
	}

	/**
	 * Test method for {@link com.example.priorityQueue.service.PriorityQueue#getListOfID()}.
	 * Validates method execution on empty queue
	 */
	@Test
	public void testGetListOfIDOnEmptyQueue() {
		assertEquals(new LinkedList<Long>(), priorityQueue.getListOfID());
	}

	/**
	 * Test method for
	 * {@link com.example.priorityQueue.service.PriorityQueue#getAvgWaitTimeOfQueue(long)}.
	 * Validates method execution on empty queue
	 */
	@Test
	public void testGetAvgWaitTimeOfQueueOnEmptyQueue() {
		assertEquals(0, priorityQueue.getAvgWaitTimeOfQueue(System.currentTimeMillis() / 1000));
	}

	/**
	 * Test method for
	 * {@link com.example.priorityQueue.service.PriorityQueue#getAvgWaitTimeOfQueue(long)}.
	 * Validates method execution for illegal date & time inputs
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetAvgWaitTimeOfQueueForIllegalArguments() {
		priorityQueue.getAvgWaitTimeOfQueue(-1);
	}
}
