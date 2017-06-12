package com.example.priorityQueue.domain;

/**
 * WorkOrderFactory.java - Factory class to generate work orders
 *
 * @author Raghav Gupta
 * @version 1.0
 */
public class WorkOrderFactory {
	/**
	 * Retrieve a work order of type NORMAL, PRIORITY, VIP or MANAGEMENT
	 * depending on ID
	 * 
	 * @param id
	 *            A variable of type long
	 * @param dateTime
	 *            A variable of type long
	 * @return An object of type WorkOrder
	 * @throws IllegalArgumentException
	 */
	public static WorkOrder createWorkOrder(long id, long dateTime) throws IllegalArgumentException {
		if (id % 3 == 0 && id % 5 == 0)
			return new Management(id, dateTime);
		if (id % 5 == 0)
			return new Vip(id, dateTime);
		if (id % 3 == 0)
			return new Priority(id, dateTime);
		return new Normal(id, dateTime);
	}
}
