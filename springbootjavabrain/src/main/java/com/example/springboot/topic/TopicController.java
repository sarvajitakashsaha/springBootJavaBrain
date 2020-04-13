package com.example.springboot.topic;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TopicController {
	@Autowired
	private TopicService topicService;
	
	@GetMapping("/topic")
	public ResponseEntity<List<Topic>>  getAllTopics() {
		List<Topic> lst = topicService.getAllTopic();
		if(lst.size()==0) {
			throw  new DataNotFoundException("data not found");
		}
		else {
			return new ResponseEntity<List<Topic>>(lst, HttpStatus.OK);
		
	}
	}
	
	@GetMapping("/topic/{id}")
	public ResponseEntity<Optional<Topic>>  getTopic(@PathVariable("id") String id)  {
		Optional<Topic> topic = topicService.getTopic(id);
	
		if(topic.stream().count() == 0) {
		throw  new DataNotFoundException("data not found");
		}
		else return  new ResponseEntity<Optional<Topic>>(topic, HttpStatus.FOUND);
	}
	@PostMapping("/topic")
	public ResponseEntity<Topic>  addTopic(@Valid @RequestBody Topic topic) {
		Topic newTopic1 = topicService.addTopic(topic);
		System.out.println("newTopiv1 is :::::" + newTopic1);
		if(topic.getId().equals(newTopic1.getId())) {
		//	return new ResponseEntity<Topic>(newTopic1, HttpStatus.CONFLICT);
			throw new DataAlreadyPresentException(" This topic is already present");
		}else {
		return new ResponseEntity<Topic>(newTopic1, HttpStatus.CREATED);
		}
		
	}
	@PutMapping("/topic/{id}")
	public ResponseEntity<Topic> updateTopic(@RequestBody Topic topic,@PathVariable("id")String id) {
		Topic newTopic1 = topicService.updateTopic(id, topic);
		if(topic.getDescription().equals(newTopic1.getDescription()) && topic.getName().equals(newTopic1.getName()) 
				&& topic.getId().equals(newTopic1.getId())) {
			System.out.println("inside if");
			return new ResponseEntity<Topic>(newTopic1, HttpStatus.NOT_MODIFIED);
		}
		else {
		return new ResponseEntity<Topic>(newTopic1, HttpStatus.OK);
		}
		
	}
	@DeleteMapping("/topic/{id}")
	public String deleteTopic(@PathVariable("id") String id) {
		return topicService.deleteTopic(id);
		
	}
}
