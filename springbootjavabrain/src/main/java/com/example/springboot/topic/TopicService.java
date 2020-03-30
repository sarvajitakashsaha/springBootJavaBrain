package com.example.springboot.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	@Autowired
	TopicRepository topicRepository;
	private List<Topic> topics = new ArrayList<Topic>((List<Topic>) Arrays.asList(
				new Topic("spring","spring frame work"," spring desc"),
				new Topic("java","java 8 application"," java desc"),
				new Topic("sql","my sql"," sql desc"),
				new Topic("docker","deployement with docker","docker desc")
				));
	
 public List<Topic> getAllTopic(){
	 return topicRepository.findAll();
 }
 public Optional<Topic> getTopic(String id) {
	 Optional<Topic> topic = topicRepository.findById(id);
	// return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
//	 if(topic.stream().count() == 0) {
//		 throw new DataNotFoundException("msg not found");
//	 }
	 
	 return topic;
	 
 }
 public Topic addTopic(Topic topic) {
//	 topics.add(topic);
//	 return topic;
	 topicRepository.save(topic);
	 return topic;
 }
 public Topic updateTopic(String id,Topic topic) {
//	 for(int i = 0 ; i <topics.size();i++) {
//		 Topic t = topics.get(i);
//		 if(t.getId().equals(id)) {
//			 topics.set(i,topic);
//		 }
//	 }
//	 
//	 return topic;
	 Topic updatedTopic = topicRepository.save(topic);
	 return  updatedTopic;
 }
public String  deleteTopic(String id) {
	
//	 for(int i = 0 ; i <topics.size();i++) {
//		  Topic t = topics.get(i);
//		 if(t.getId().equals(id)) {
//			 topics.remove(i);
//		 }
//	 }
//	 return "deleted";
	topicRepository.deleteById(id);
	return "deleted";
}
 
}
