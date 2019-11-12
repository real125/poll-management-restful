package com.yuri.schmidt.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrePoll {
	
	public PrePoll() {}
	
	
	
public PrePoll(List<Question> questions, String pollName, LocalDate startDate, LocalDate endDate,
			boolean isActive) {
		super();
		this.questions = questions;
		this.pollName = pollName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.isActive = isActive;
	}



private List<Question> questions = new ArrayList<>();
	
	private String pollName;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private boolean isActive;

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public String getPollName() {
		return pollName;
	}

	public void setPollName(String pollName) {
		this.pollName = pollName;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "PrePoll questions=" + questions + ", pollName=" + pollName + ", startDate=" + startDate + ", endDate="
				+ endDate + ", isActive=" + isActive + "]";
	}
	


}
