package com.yuri.schmidt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.yuri.schmidt.dao.PollRepository;
import com.yuri.schmidt.model.Poll;
import com.yuri.schmidt.model.PrePoll;
import com.yuri.schmidt.model.Question;

@Service
public class PollManagementService {

	@Autowired
	private PollRepository dao;
	
	/*
	 * Deleting by Id
	 */
	public String deleteById(Long id) {
		if (dao.findById(id).isPresent()) {
			dao.deleteById(id);
			return "DELETED";
		} 
		return "The ID is out of range";
	}
	
	/*
	 * Saving to db
	 */
	public void save(PrePoll prePoll) {
	Poll poll = new Poll(prePoll);
		for (Question q : prePoll.getQuestions()) {
			poll.addQuestion(q);
		}
		dao.saveAndFlush(poll);
	}
	
	/*
	 * Updating item by Id 
	 * !!!!!! ONLY Poll object WITHOUT Question objects !!!!! FOR SIMPLICITY
	 */
	public String update(PrePoll prePoll, Long id) {
	
	Optional<Poll> pollOptional = dao.findById(id);
	if (pollOptional.isPresent()) { //if id is valid
		Poll poll = pollOptional.get();
		poll.setPollName(prePoll.getPollName());
		poll.setStartDate(prePoll.getStartDate());
		poll.setEndDate(prePoll.getEndDate());
		poll.setActive(prePoll.isActive());
		dao.flush();
		return "UPDATED";
	}
		return "The ID is out of range"; //id is not valid
	}
	
	/*
	 * Get all polls sorted by, paginated
	 */
	public List<Poll> findAll(String by, int pageNumber, int pageSize) {
		
		String sortBy = "";
		if (by.equals("byname")) {
			sortBy = "pollName";
		} else if(by.equals("bydate")){
			sortBy = "startDate";
		} else {
			return dao.findAll();
			}
		
		Pageable sortedPageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
		Page<Poll> page = dao.findAll(sortedPageable);
		return page.toList();
	}
}
