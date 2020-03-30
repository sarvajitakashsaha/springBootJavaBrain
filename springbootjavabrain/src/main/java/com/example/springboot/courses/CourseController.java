package com.example.springboot.courses;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.topic.Topic;

@RestController
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/topic/{id}/course")
	public List<Course> getAllCourses() {
		return courseService.getAllCourses();
	}
	
	@GetMapping("/topic/{topicId}/course/{id}")
	public Optional<Course> getCourse(@PathVariable("id") String id) {
		return courseService.getCourse(id);
		
	}
	@PostMapping("/topic/{topicId}/course")
	public Course addCourse(@RequestBody Course course,@PathVariable("topicId") String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		return courseService.addCourse(course);
	}
	@PutMapping("/topic/{topicId}/course/{id}")
	public Course updateCourse(@RequestBody Course course,@PathVariable("id")String id,@PathVariable("topicId") String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		return courseService.updateCourse(course);
		
	}
	@DeleteMapping("/topic/{topicId}/course/{id}")
	public String deleteCourse(@PathVariable("id") String id) {
		return courseService.deleteCourse(id);
		
	}
}
