package com.yuri.schmidt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yuri.schmidt.model.Poll;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {

}
