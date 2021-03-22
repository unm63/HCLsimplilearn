package com.example.UserFeedback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserFeedback.entities.Feedback;
import com.example.UserFeedback.services.FeedbackService;

@RestController
public class FeedbackController {
	
	@Autowired
	FeedbackService feedbackService;
	
	@GetMapping(value = "/feedback", produces = "application/json")
	public @ResponseBody Iterable<Feedback> getAllFeedbacks() {
        // This returns a JSON or XML with the Feedbacks
        return feedbackService.GetAllFeedback();
    }
	
	@PostMapping(value = "/feedback", consumes = "application/json")
	public Feedback addNewFeedback(@RequestBody Feedback newFeedback) {
		// TODO: Do something useful here.  
		// Add the Feedback.
		return feedbackService.addFunction(newFeedback);
		//return new Feedback();  // Change this.
	}
	
	@PostMapping(value = "/feedback", consumes = "application/x-www-form-urlencoded")
	
	public Feedback addNewFeedback2(//@RequestParam Feedback newFeedback, 
			@RequestParam(value="user", required=false, defaultValue="") String user, 
			@RequestParam(value="rating", required=false, defaultValue="") int rating, 
			@RequestParam(value="comments", required=false, defaultValue="") String comments) {
		// TODO: Do something useful here.  
		// Add the Feedback.
		Feedback newFeedback = new Feedback();
		newFeedback.setUser(user);
		newFeedback.setRating(rating);
		newFeedback.setComments(comments);
		return feedbackService.addFunction(newFeedback);
		//return new Feedback();  // Change this.
	}
	
	

}