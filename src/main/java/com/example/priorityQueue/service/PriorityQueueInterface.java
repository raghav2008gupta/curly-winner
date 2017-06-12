/**
 * 
 */
package com.example.priorityQueue.service;

import java.util.LinkedList;

import com.example.priorityQueue.domain.WorkOrder;

/**
 * PriorityQueueInterface.java - An interface to define a Priority Queue for
 * work orders
 *
 * @author Raghav Gupta
 * @version 1.0
 */
public interface PriorityQueueInterface {

	/**
	 * Adds new work order in the queue
	 * 
	 * @param id
	 *            A variable of type long
	 * @param dateTime
	 *            A variable of type long
	 * @return A boolean data type
	 * @throws IllegalArgumentException
	 */
	boolean enqueue(long id, long dateTime) throws IllegalArgumentException;

	/**
	 * Retrieve the highest ranked work order from the queue
	 * 
	 * @return A WorkOrder data type
	 */
	WorkOrder dequeue();

	/**
	 * Remove the specified work order from the queue
	 * 
	 * @param id
	 *            A variable of type long
	 * @return A boolean data type
	 * @throws IllegalArgumentException
	 */
	boolean removeID(long id) throws IllegalArgumentException;

	/**
	 * Retrieve list of IDs of work orders in the queue in descending order of
	 * their ranks
	 * 
	 * @return A LinkedList data type
	 */
	LinkedList<Long> getListOfID();

	/**
	 * Retrieve position of the specified ID
	 * 
	 * @param id
	 *            A variable of type long
	 * @return An int data type
	 * @throws IllegalArgumentException
	 */
	int getPositionOfID(long id) throws IllegalArgumentException;

	/**
	 * Retrieve average wait time for all work orders in the priority queue
	 * 
	 * @param currentDateTime
	 *            A variable of type long
	 * @return A long data type
	 * @throws IllegalArgumentException
	 */
	long getAvgWaitTimeOfQueue(long currentDateTime) throws IllegalArgumentException;
}
