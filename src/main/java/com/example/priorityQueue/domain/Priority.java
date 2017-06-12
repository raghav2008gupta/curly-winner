package com.example.priorityQueue.domain;

/**
 * Priority.java - A class to create work orders of type PRIORITY
 *
 * @author Raghav Gupta
 * @version 1.0
 */
public class Priority extends WorkOrder {
	/**
	 * Constructor - calls super class constructor
	 * 
	 * @see com.example.priorityQueue.domain.WorkOrder#WorkOrder(long, long)
	 */
	public Priority(long id, long dateTime) {
		super(id, dateTime);
	}

	/* (non-Javadoc)
	 * @see com.example.priorityQueue.WorkOrder#getClassOfID()
	 */
	public int getClassOfID() {
		return idClass.PRIORITY.ordinal();
	}

	/* (non-Javadoc)
	 * @see com.example.priorityQueue.WorkOrder#getRankOfID(long)
	 */
	public long getRankOfID(long currentDateTime) {
		long seconds = currentDateTime - getDateTime();
		return (long) Math.max(3, seconds * (Math.log(seconds)));
	}
}
