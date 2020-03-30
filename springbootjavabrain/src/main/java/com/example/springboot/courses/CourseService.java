package com.example.springboot.courses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	@Autowired
	CourseRepository courseRepository;
//	private List<Course> topics = new ArrayList<Course>((List<Course>) Arrays.asList(
//				new Course("spring","spring frame work"," spring desc"),
//				new Course("java","java 8 application"," java desc"),
//				new Course("sql","my sql"," sql desc"),
//				new Course("docker","deployement with docker","docker desc")
//				));
	
 public List<Course> getAllCourses(){
	 return courseRepository.findAll();
 }
 public Optional<Course> getCourse(String id) {
	// return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	 return courseRepository.findById(id);
 }
 public Course addCourse(Course topic) {
//	 topics.add(topic);
//	 return topic;
	 courseRepository.save(topic);
	 return topic;
 }
 public Course updateCourse(Course topic) {
//	 for(int i = 0 ; i <topics.size();i++) {
//		 Topic t = topics.get(i);
//		 if(t.getId().equals(id)) {
//			 topics.set(i,topic);
//		 }
//	 }
//	 
//	 return topic;
	 return courseRepository.save(topic); 
 }
public String  deleteCourse(String id) {
	
//	 for(int i = 0 ; i <topics.size();i++) {
//		  Topic t = topics.get(i);
//		 if(t.getId().equals(id)) {
//			 topics.remove(i);
//		 }
//	 }
//	 return "deleted";
	courseRepository.deleteById(id);
	return "deleted";
}
 
}
