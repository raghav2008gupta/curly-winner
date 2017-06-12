package com.example.priorityQueue.domain;

/**
 * WorkOrder.java - Abstract class for different types of work order
 *
 * @author Raghav Gupta
 * @version 1.0
 */
public abstract class WorkOrder implements WorkOrderInterface {
	/** Stores work order id */
	private long id;

	/** Stores work order epoch time */
	private long dateTime;

	/**
	 * Constructor
	 * 
	 * @param id
	 *            A variable of type long. Should be between 1 and
	 *            9223372036854775807
	 * @param dateTime
	 *            A variable of type long. Should be a positive integer
	 * @throws IllegalArgumentException
	 */
	public WorkOrder(long id, long dateTime) throws IllegalArgumentException {
		if (id < 1 || dateTime < 0)
			throw new IllegalArgumentException();
		this.id = id;
		this.dateTime = dateTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.priorityQueue.WorkOrderInterface#getID()
	 */
	public long getID() {
		return this.id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.priorityQueue.WorkOrderInterface#getDateTime()
	 */
	public long getDateTime() {
		return this.dateTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.priorityQueue.WorkOrderInterface#getClassOfID()
	 */
	public abstract int getClassOfID();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.priorityQueue.WorkOrderInterface#getRankOfID(long)
	 */
	public abstract long getRankOfID(long currentDateTime);
}
