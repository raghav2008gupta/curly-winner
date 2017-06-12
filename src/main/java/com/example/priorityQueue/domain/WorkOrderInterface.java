/**
 * 
 */
package com.example.priorityQueue.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * WorkOrderInterface.java - An interface to define structure of work orders
 *
 * @author Raghav Gupta
 * @version 1.0
 */
public interface WorkOrderInterface {
	static enum idClass {

		/** Normal work order */
		NORMAL,

		/** Priority work order */
		PRIORITY,

		/** Vip work order */
		VIP,

		/** Management work order */
		MANAGEMENT
	}

	/**
	 * Retrieve the work order ID
	 * 
	 * @return A long data type
	 */
	long getID();

	/**
	 * Retrieve the work order date and time
	 * 
	 * @return A long data type
	 */
	long getDateTime();

	/**
	 * Retrieve the class of the work order
	 * 
	 * @return An int data type
	 */
	@JsonIgnore
	int getClassOfID();

	/**
	 * Retrieve the rank of the work order
	 * 
	 * @param currentDateTime
	 *            A variable of type long. Should be a positive integer
	 * @return A long data type
	 */
	long getRankOfID(long currentDateTime);
}
