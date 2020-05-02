package com.example.springboot.topic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TopicRepository extends JpaRepository<Topic, String> {
	@Query(value  = "SELECT * FROM TOPIC WHERE description = ?1",nativeQuery = true)
	Topic findByDesc(String desc);

}
