package com.demo.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.quizapp.dao.QuestionDao;
import com.demo.quizapp.dao.QuizDao;
import com.demo.quizapp.model.Question;
import com.demo.quizapp.model.QuestionWrapper;
import com.demo.quizapp.model.Quiz;
import com.demo.quizapp.model.Response;

@Service
public class QuizService {
	
	@Autowired
	QuizDao quizdao;
	@Autowired
	QuestionDao questiondao ;
	
	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
	    try {
	        List<Question> questions = questiondao.findRandomQuestionsByCategory(category, numQ);

	        if (questions == null || questions.isEmpty()) {
	            return new ResponseEntity<>("No questions found for the given category", HttpStatus.NOT_FOUND);
	        }

	        Quiz quiz = new Quiz();
	        quiz.setTitle(title);
	        quiz.setQuestions(questions);

	        quizdao.save(quiz);

	        return new ResponseEntity<>("Quiz created successfully", HttpStatus.CREATED);

	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}


	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		// TODO Auto-generated method stub
		try {
		Optional<Quiz> quiz=quizdao.findById(id);
		List<Question> questionsFromDB=quiz.get().getQuestions();
		List<QuestionWrapper> questionsForUser=new ArrayList<>();
		for(Question q: questionsFromDB)
		{
			QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestion_title(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			questionsForUser.add(qw);
		}
		
		return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
		
	
	}catch(Exception e) {
        e.printStackTrace(); // You can use a logger in real apps
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		// TODO Auto-generated method stub
		try {
		Quiz quiz=quizdao.findById(id).get();
		List<Question>questions=quiz.getQuestions();
		int right=0;
		int i=0;
		for(Response response:responses)
		{
			if(response.getResponse().equals(questions.get(i).getRight_answer()))
				right++;
			
			i++;
		}
		
		return new ResponseEntity<>(right,HttpStatus.OK);
	}catch(Exception e) {
        e.printStackTrace(); 
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
}
}