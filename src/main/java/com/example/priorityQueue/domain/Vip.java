package com.example.priorityQueue.domain;

/**
 * Vip.java - A class to create work orders of type VIP
 *
 * @author Raghav Gupta
 * @version 1.0
 */
public class Vip extends WorkOrder {
	/**
	 * Constructor - calls super class constructor
	 * 
	 * @see com.example.priorityQueue.domain.WorkOrder#WorkOrder(long, long)
	 */
	public Vip(long id, long dateTime) {
		super(id, dateTime);
	}

	/* (non-Javadoc)
	 * @see com.example.priorityQueue.WorkOrder#getClassOfID()
	 */
	public int getClassOfID() {
		return idClass.VIP.ordinal();
	}

	/* (non-Javadoc)
	 * @see com.example.priorityQueue.WorkOrder#getRankOfID(long)
	 */
	public long getRankOfID(long currentDateTime) {
		long seconds = currentDateTime - getDateTime();
		return (long) Math.max(4, 2 * seconds * (Math.log(seconds)));
	}
}
