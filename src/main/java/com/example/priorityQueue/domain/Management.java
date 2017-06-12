package com.example.priorityQueue.domain;

/**
 * Management.java - A class to create work orders of type MANAGEMENT
 *
 * @author Raghav Gupta
 * @version 1.0
 */
public class Management extends WorkOrder {
	/**
	 * Constructor - calls super class constructor
	 * 
	 * @see com.example.priorityQueue.domain.WorkOrder#WorkOrder(long, long)
	 */
	public Management(long id, long dateTime) {
		super(id, dateTime);
	}

	/* (non-Javadoc)
	 * @see com.example.priorityQueue.WorkOrder#getClassOfID()
	 */
	public int getClassOfID() {
		return idClass.MANAGEMENT.ordinal();
	}

	/* (non-Javadoc)
	 * @see com.example.priorityQueue.WorkOrder#getRankOfID(long)
	 */
	public long getRankOfID(long currentDateTime) {
		long seconds = currentDateTime - getDateTime();
		return seconds;
	}
}
