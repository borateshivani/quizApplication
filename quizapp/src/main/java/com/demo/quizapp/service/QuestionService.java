package com.demo.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.quizapp.dao.QuestionDao;
import com.demo.quizapp.model.Question;

@Service
public class QuestionService {
	@Autowired
	QuestionDao questiondao;

	public ResponseEntity<List<Question>> getAllQuestions() {
		// TODO Auto-generated method stub
		try {
		return new ResponseEntity<>(questiondao.findAll(),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		// TODO Auto-generated method stub
		try {
		return new ResponseEntity<>(questiondao.findByCategory(category),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuestion(Question question) {
		// TODO Auto-generated method stub
		try {
		questiondao.save(question);
		return new ResponseEntity<>("Question Added",HttpStatus.CREATED);
		}catch (Exception e){
			return new ResponseEntity<>("Failed To Add Question",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<String> deleteQuestionById(int id) {
		// TODO Auto-generated method stub
		try {
		questiondao.deleteById(id);
		return new ResponseEntity<>("Question Deleted",HttpStatus.NO_CONTENT);
		}catch(Exception e) {
			return new ResponseEntity<>("Failed To Delete Question",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
