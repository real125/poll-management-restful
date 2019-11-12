package com.yuri.schmidt.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "poll")
public class Poll {
	
	public Poll() {}
	
	public Poll(PrePoll p) {
		this.setPollName(p.getPollName());
		this.setStartDate(p.getStartDate());
		this.setEndDate(p.getEndDate());
		this.setActive(p.isActive());
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToMany(mappedBy = "poll", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Question> questions = new ArrayList<>();
	
	@Column(name = "poll_name")
	private String pollName;
	
	@Column(name = "start_date")
	private LocalDate startDate;
	
	@Column(name = "end_date")
	private LocalDate endDate;
	
	@Column(name = "activity")
	private boolean isActive;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public void addQuestion(Question q) {
		questions.add(q);
		q.setPoll(this);
	}
	
	public void removeQuestion(Question q) {
		questions.remove(q);
		q.setPoll(null);

	}

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
		return "Poll [id=" + id + ", questions=" + questions + ", pollName=" + pollName + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", isActive=" + isActive + "]";
	}
	
	
}
