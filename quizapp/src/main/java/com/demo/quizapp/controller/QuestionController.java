package com.demo.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.quizapp.model.Question;
import com.demo.quizapp.service.QuestionService;

@RestController
@RequestMapping("/questions")
public class QuestionController {
	@Autowired
	QuestionService questionservice;
	@GetMapping("/allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions()
	{
		return questionservice.getAllQuestions();
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category)
	{
		return questionservice.getQuestionsByCategory(category);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question)
	{
		return questionservice.addQuestion(question);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteQuestionById(@PathVariable int id)
	{
		return questionservice.deleteQuestionById(id);
	}
	
	
}
