package com.yuri.schmidt.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yuri.schmidt.model.Poll;
import com.yuri.schmidt.model.PrePoll;
import com.yuri.schmidt.service.PollManagementService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "PollManagementControllerApi", produces = MediaType.APPLICATION_JSON_VALUE)
public class PollManagementConroller {
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(PollManagementConroller.class);
	
	@Autowired
	private PollManagementService service;

	//TESTING APP FUNCTIONALITY
	@GetMapping("/greeting")
	@ApiOperation("Testing REST functionality")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
	public String greeting() {
		return "Wellcome to the Poll Management RESTful service";
	}
	
	/*
	 * Get all polls sorted by, paginated
	 */
	
	@GetMapping("/findall/{sortby}/{pagenumber}/{pagesize}")
	@ApiOperation("Gets all polls sorted by and paginated")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Poll.class)})
	public List<Poll> findPollsByFieldsSortingWihtPagination(@ApiParam(value="sort options",allowableValues = "byname, bydate",allowEmptyValue = false)
															@PathVariable("sortby") String sortBy, //by 'name' or by 'date'
															@ApiParam(value = "which page number")
															@PathVariable("pagenumber") int pageNumber, //page nubber beginning from zero
															@ApiParam(value = "how many pages")
															@PathVariable("pagesize") int pageSize) { //number of pages
		
		return service.findAll(sortBy, pageNumber, pageSize);
	}

	/*
	 * Creates a poll in the Data Base
	 */

	@PostMapping("/createpoll")
	@ApiOperation("Creates a poll in the Database")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
	public String createPoll(@ApiParam(value = "Request body" , hidden = true)@RequestBody PrePoll prePoll) {
		logger.info("RequestBody to create");
		service.save(prePoll);
		System.out.println("BOOLEAN " + prePoll.isActive() + "  " + prePoll.getPollName());
		return "CREATED";
	}
	
	/*
	 * Updating item by Id 
	 * !!!!!! ONLY Poll object WITHOUT Question objects !!!!! FOR SIMPLICITY
	 */
	@PutMapping("/update/{pollId}")
	@ApiOperation("Updates 'Poll' item in DB by id")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
	public String updateItems(@ApiParam(hidden = true)@RequestBody PrePoll prePoll, @ApiParam(value = "Id of the poll item in DB")@PathVariable("pollId") Long pollId){
		logger.info("Updating item with Id: " + pollId);
		return service.update(prePoll, pollId);
	}
	
	
	/*
	 * Deletes a poll from the table 'poll' by id of the poll
	 */
	
	@DeleteMapping("/deletepoll/{pollId}")
	@ApiOperation("Deletes a poll object from the table 'poll' by id of the poll")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
	public String deletePoll(@ApiParam(value = "Id of the poll item in DB")@PathVariable("pollId") Long pollId) {
		
		return service.deleteById(pollId);
	}
	
}
