package com.demo.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.quizapp.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz,Integer> {
	

}
