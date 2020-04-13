package com.example.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.springboot.topic.Topic;
import com.example.springboot.topic.TopicRepository;
import com.example.springboot.topic.TopicService;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicTest {
	
	@Autowired
	private TopicService service ;
	@MockBean
	private TopicRepository repository;
	 @Before
	    public void init() {
	        MockitoAnnotations.initMocks(this);
	    }
	@Test
	public void getAllTopicTest() {
		List<Topic> topic = new ArrayList<Topic>();
		topic.add(new Topic("spring","spring frame work"," spring desc"));
		topic.add(new Topic("spring1","spring frame work1"," spring desc1"));
		when(repository.findAll()).thenReturn(topic);
		assertEquals(2, service.getAllTopic().size());	
	}
	@Test
	public void getTopicTest() {
	
		Topic t1 = new Topic("spring","spring frame work"," spring desc");
		when(repository.findById("spring")).thenReturn(Optional.of(t1));
		assertEquals(Optional.of(t1),service.getTopic("spring"));
	}
	@Test 
	public void addTopicTest() {
		Topic t2 = new Topic("java","java frame work"," java desc");
		when(repository.save(t2)).thenReturn(t2);
		assertEquals("java", service.addTopic(t2).getId());
		//service.addTopic(t2);
				
	}
	@Test
	public void deleteTopicTest() {
		List<Topic> topic = new ArrayList<Topic>();
		topic.add(new Topic("spring","spring frame work"," spring desc"));
		topic.add(new Topic("spring1","spring frame work1"," spring desc1"));
		String s1 = "deleted";
		service.deleteTopic("spring");
		verify(repository,times(1)).deleteById("spring");
	}
	

	
}
