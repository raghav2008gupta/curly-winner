package com.example.priorityQueueTest;

import static org.junit.Assert.*;

import java.util.concurrent.ThreadLocalRandom;

import org.junit.Test;
import org.springframework.test.annotation.Repeat;

import com.example.priorityQueue.domain.WorkOrder;
import com.example.priorityQueue.domain.WorkOrderFactory;

/**
 * WorkOrderFactoryTest.java - A class for running unit test cases on the
 * WorkOrderFactory class
 *
 * @author Raghav Gupta
 * @version 1.0
 */
public class WorkOrderFactoryTest {
	/** Object of type WorkOrder */
	private WorkOrder workOrder;

	/**
	 * Test method for
	 * {@link com.example.priorityQueue.domain.WorkOrderFactory#createWorkOrder(long, long)}.
	 * Validates method execution for random IDs and dateTime values
	 */
	@Test
	@Repeat(1000)
	public void testGetWorkOrder1() {
		long id = ThreadLocalRandom.current().nextLong(1, Long.MAX_VALUE);
		long dateTime = System.currentTimeMillis() / 1000;
		workOrder = WorkOrderFactory.createWorkOrder(id, dateTime);
		if (id % 3 == 0 && id % 5 == 0)
			assertEquals(WorkOrder.idClass.MANAGEMENT.ordinal(), workOrder.getClassOfID());
		else if (id % 5 == 0)
			assertEquals(WorkOrder.idClass.VIP.ordinal(), workOrder.getClassOfID());
		else if (id % 3 == 0)
			assertEquals(WorkOrder.idClass.PRIORITY.ordinal(), workOrder.getClassOfID());
		else
			assertEquals(WorkOrder.idClass.NORMAL.ordinal(), workOrder.getClassOfID());
	}

	/**
	 * Test method for
	 * {@link com.example.priorityQueue.domain.WorkOrderFactory#createWorkOrder(long, long)}.
	 * Validates method execution for illegal inputs
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetWorkOrder2() {
		workOrder = WorkOrderFactory.createWorkOrder(0, 0);
	}

	/**
	 * Test method for
	 * {@link com.example.priorityQueue.domain.WorkOrderFactory#createWorkOrder(long, long)}.
	 * Validates method execution for illegal inputs
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetWorkOrder3() {
		workOrder = WorkOrderFactory.createWorkOrder(-1, 0);
	}

	/**
	 * Test method for
	 * {@link com.example.priorityQueue.domain.WorkOrderFactory#createWorkOrder(long, long)}.
	 * Validates method execution for illegal inputs
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetWorkOrder4() {
		workOrder = WorkOrderFactory.createWorkOrder(0, -1);
	}

}
