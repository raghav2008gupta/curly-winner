/**
 * 
 */
package com.example.priorityQueue.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.priorityQueue.domain.WorkOrder;

/**
 * WorkOrderControllerInterface.java - An interface for Resource Controller to
 * handle HTTP requests
 *
 * @author Raghav Gupta
 * @version 1.0
 */
public interface WorkOrderControllerInterface {

	/**
	 * Map /enqueue requests to {@link com.example.priorityQueue.service.PriorityQueue#enqueue(long, long)}.
	 * 
	 * @param id
	 *            A variable of type long
	 * @param dateTime
	 *            A variable of type long
	 * @return A map entry of type <String, Boolean>
	 * @throws IllegalArgumentException
	 */
	@RequestMapping("/enqueue")
	HashMap<String, Boolean> enqueue(@RequestParam(value = "id") String id,
			@RequestParam(value = "datetime") String dateTime) throws IllegalArgumentException;

	/**
	 * Map /dequeue requests to {@link com.example.priorityQueue.service.PriorityQueue#dequeue()}.
	 * 
	 * @return A map entry of type <String, WorkOrder>
	 */
	@RequestMapping("/dequeue")
	HashMap<String, WorkOrder> dequeue();

	/**
	 * Map /remove requests to {@link com.example.priorityQueue.service.PriorityQueue#removeID(long)}.
	 * 
	 * @param id
	 *            A variable of type long
	 * @return A map entry of type <String, Boolean>
	 * @throws IllegalArgumentException
	 */
	@RequestMapping("/remove")
	HashMap<String, Boolean> removeID(@RequestParam(value = "id") String id) throws IllegalArgumentException;

	/**
	 * Map /list requests to {@link com.example.priorityQueue.service.PriorityQueue#getListOfID()}.
	 * 
	 * @return A map entry of type <String, LinkedList<Long>>
	 */
	@RequestMapping("/list")
	HashMap<String, LinkedList<Long>> getListOfID();

	/**
	 * Map /avgwait requests to {@link com.example.priorityQueue.service.PriorityQueue#getAvgWaitTimeOfQueue(long)}.
	 * 
	 * @param currentDateTime
	 *            A variable of type long
	 * @return A map entry of type <String, Long>
	 * @throws IllegalArgumentException
	 */
	@RequestMapping("/avgwait")
	HashMap<String, Long> getAvgWaitTimeOfQueue(@RequestParam(value = "datetime") String currentDateTime)
			throws IllegalArgumentException;

	/**
	 * Map /position requests to {@link com.example.priorityQueue.service.PriorityQueue#getPositionOfID(long)}.
	 * 
	 * @param id
	 *            A variable of type long
	 * @return A map entry of type <String, Integer>
	 * @throws IllegalArgumentException
	 */
	@RequestMapping("/position")
	HashMap<String, Integer> getPositionOfID(@RequestParam(value = "id") String id) throws IllegalArgumentException;

	/**
	 * Exception handler for bad requests
	 * 
	 * @param response
	 * @throws IOException
	 */
	@ExceptionHandler({ IllegalArgumentException.class, NullPointerException.class })
	void handleBadRequests(HttpServletResponse response) throws IOException;
}
