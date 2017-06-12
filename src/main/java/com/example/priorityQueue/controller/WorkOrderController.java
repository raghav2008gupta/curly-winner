package com.example.priorityQueue.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.priorityQueue.domain.WorkOrder;
import com.example.priorityQueue.service.PriorityQueue;

/**
 * WorkOrderController.java - Resource controller class to handle HTTP requests
 *
 * @author Raghav Gupta
 * @version 1.0
 */
@RestController
public class WorkOrderController implements WorkOrderControllerInterface {

	/** An instance of the PriorityQueue class */
	private static PriorityQueue priorityQueue = PriorityQueue.getInstance();

	/* (non-Javadoc)
	 * @see com.example.priorityQueue.WorkOrderControllerInterface#enqueue(java.lang.String, java.lang.String)
	 */
	public HashMap<String, Boolean> enqueue(@RequestParam(value = "id") String id,
			@RequestParam(value = "datetime") String dateTime) throws IllegalArgumentException {
		HashMap<String, Boolean> result = new HashMap<String, Boolean>();
		result.put("status", priorityQueue.enqueue(Long.parseLong(id), Long.parseLong(dateTime)));
		return result;
	}

	/* (non-Javadoc)
	 * @see com.example.priorityQueue.WorkOrderControllerInterface#dequeue()
	 */
	public HashMap<String, WorkOrder> dequeue() {
		HashMap<String, WorkOrder> result = new HashMap<String, WorkOrder>();
		result.put("WorkOrder", priorityQueue.dequeue());
		return result;
	}

	/* (non-Javadoc)
	 * @see com.example.priorityQueue.controller.WorkOrderControllerInterface#removeID(java.lang.String)
	 */
	public HashMap<String, Boolean> removeID(@RequestParam(value = "id") String id) throws IllegalArgumentException {
		HashMap<String, Boolean> result = new HashMap<String, Boolean>();
		result.put("status", priorityQueue.removeID(Long.parseLong(id)));
		return result;
	}

	/* (non-Javadoc)
	 * @see com.example.priorityQueue.controller.WorkOrderControllerInterface#getListOfID()
	 */
	public HashMap<String, LinkedList<Long>> getListOfID() {
		HashMap<String, LinkedList<Long>> result = new HashMap<String, LinkedList<Long>>();
		result.put("list", priorityQueue.getListOfID());
		return result;
	}

	/* (non-Javadoc)
	 * @see com.example.priorityQueue.controller.WorkOrderControllerInterface#getAvgWaitTimeOfQueue(java.lang.String)
	 */
	public HashMap<String, Long> getAvgWaitTimeOfQueue(@RequestParam(value = "datetime") String currentDateTime)
			throws IllegalArgumentException {
		HashMap<String, Long> result = new HashMap<String, Long>();
		result.put("avgwaittime", priorityQueue.getAvgWaitTimeOfQueue(Long.parseLong(currentDateTime)));
		return result;
	}

	/* (non-Javadoc)
	 * @see com.example.priorityQueue.controller.WorkOrderControllerInterface#getPositionOfID(java.lang.String)
	 */
	public HashMap<String, Integer> getPositionOfID(@RequestParam(value = "id") String id) throws IllegalArgumentException {
		int pos = priorityQueue.getPositionOfID(Long.parseLong(id));
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		result.put("position", pos >= 0 ? pos : null);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.example.priorityQueue.WorkOrderControllerInterface#handleBadRequests(javax.servlet.http.HttpServletResponse)
	 */
	public void handleBadRequests(HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.BAD_REQUEST.value(), "Invalid arguments");
	}
}
