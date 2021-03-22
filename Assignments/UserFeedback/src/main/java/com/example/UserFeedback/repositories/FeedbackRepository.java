package com.example.UserFeedback.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.UserFeedback.entities.*;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Integer>{

}
