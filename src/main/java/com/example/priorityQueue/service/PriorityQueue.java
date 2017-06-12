package com.example.priorityQueue.service;

import org.apache.commons.collections4.map.*;

import com.example.priorityQueue.domain.WorkOrder;
import com.example.priorityQueue.domain.WorkOrderFactory;

import java.util.*;

/**
 * PriorityQueue.java - A class to create a priority queue for work orders
 *
 * @author Raghav Gupta
 * @version 1.0
 */
public class PriorityQueue implements PriorityQueueInterface {

	/** Class variable for singleton instance */
	private static PriorityQueue singletonPriorityQueue;

	/** Array of mapped list of different work order types */
	@SuppressWarnings("unchecked")
	private LinkedMap<Long, WorkOrder>[] queue = new LinkedMap[4];

	/**
	 * Sum of epoch time of all work orders in the priority queue
	 */
	private long sumOfTime = 0;

	/** Count of all work orders in the priority queue */
	private long totalCount = 0;

	/**
	 * Constructor
	 */
	private PriorityQueue() {
	}

	/**
	 * Retrieves a singleton instance of the class
	 * 
	 * @return An object of type PriorityQueue
	 */
	public static PriorityQueue getInstance() {
		if (singletonPriorityQueue == null) {
			singletonPriorityQueue = new PriorityQueue();
		}
		return singletonPriorityQueue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.priorityQueue.PriorityQueueInterface#enqueue(long, long)
	 */
	public boolean enqueue(long id, long dateTime) throws IllegalArgumentException {
		WorkOrder newWO = WorkOrderFactory.createWorkOrder(id, dateTime);
		int qNo = newWO.getClassOfID();
		if (queue[qNo] == null) {
			queue[qNo] = new LinkedMap<Long, WorkOrder>();
		}
		if (queue[qNo].containsKey(id))
			return false;
		queue[qNo].put(id, newWO);
		this.sumOfTime += dateTime;
		this.totalCount++;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.priorityQueue.PriorityQueueInterface#dequeue()
	 */
	public WorkOrder dequeue() {
		WorkOrder result = null;
		if (queue[3] != null && !queue[3].isEmpty()) {
			result = queue[3].get(queue[3].lastKey());
		} else {
			long currentDateTime = System.currentTimeMillis() / 1000;
			WorkOrder wo = null;
			for (int i = 2; i >= 0; i--) {
				if (queue[i] != null && !queue[i].isEmpty()) {
					wo = queue[i].get(queue[i].lastKey());
					if (result == null) {
						result = wo;
					} else {
						if (result.getRankOfID(currentDateTime) < wo.getRankOfID(currentDateTime)) {
							result = wo;
						}
					}
				}
			}
		}
		if (result != null)
			removeID(result.getID());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.priorityQueue.PriorityQueueInterface#removeID(long)
	 */
	public boolean removeID(long id) throws IllegalArgumentException {
		int qNo = WorkOrderFactory.createWorkOrder(id, 0L).getClassOfID();
		if (queue[qNo] != null && !queue[qNo].isEmpty() && queue[qNo].containsKey(id)) {
			sumOfTime -= queue[qNo].get(id).getDateTime();
			totalCount--;
			queue[qNo].remove(id);
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.priorityQueue.PriorityQueueInterface#getListOfID()
	 */
	@SuppressWarnings("unchecked")
	public LinkedList<Long> getListOfID() {
		long currentDateTime = System.currentTimeMillis() / 1000;
		HashMap<Long, Long> h = new HashMap<Long, Long>();
		for (int i = 0; i < 3; i++) {
			if (queue[i] != null) {
				for (long id : queue[i].keySet()) {
					h.put(id, queue[i].get(id).getRankOfID(currentDateTime));
				}
			}
		}
		LinkedList<Long> idList = new LinkedList<Long>();
		LinkedList<Long> temp1 = new LinkedList<Long>();
		LinkedList<Long> temp2 = new LinkedList<Long>();
		if (queue[3] != null) {
			temp1.addAll(queue[3].keySet());
			Collections.sort(temp1, Collections.reverseOrder());
		}
		if (h != null) {
			temp2.addAll(sortByRank(h).keySet());
			Collections.sort(temp2, Collections.reverseOrder());
		}
		if (temp1 != null)
			idList.addAll(temp1);
		if (temp2 != null)
			idList.addAll(temp2);
		return idList;
	}

	/**
	 * Sorts a list of IDs based on their ranks
	 * 
	 * @param map
	 *            A variable of type HashMap
	 * @return A HashMap data type with key and value as long data types
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private HashMap sortByRank(HashMap map) {
		List list = new LinkedList(map.entrySet());
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
			}
		});
		HashMap sortedList = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedList.put(entry.getKey(), entry.getValue());
		}
		return sortedList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.priorityQueue.PriorityQueueInterface#getPositionOfID(long)
	 */
	public int getPositionOfID(long id) throws IllegalArgumentException {
		if (id < 1)
			throw new IllegalArgumentException();
		boolean idExists = false;
		for (int i = 0; i < 4; i++) {
			if (queue[i] != null && !queue[i].isEmpty() && queue[i].containsKey(id)) {
				idExists = true;
				break;
			}
		}
		if (idExists == false)
			return -1;
		LinkedList<Long> idList = getListOfID();
		if (idList != null)
			return idList.indexOf(id);
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.example.priorityQueue.PriorityQueueInterface#getAvgWaitTimeOfQueue(long)
	 */
	public long getAvgWaitTimeOfQueue(long currentDateTime) throws IllegalArgumentException {
		if (currentDateTime < 0)
			throw new IllegalArgumentException();
		try {
			return (currentDateTime * totalCount - sumOfTime) / totalCount;
		} catch (ArithmeticException e) {
			return 0;
		}
	}
}
