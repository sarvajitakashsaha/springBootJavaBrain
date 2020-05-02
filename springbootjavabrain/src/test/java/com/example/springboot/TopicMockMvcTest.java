package com.example.springboot;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.springboot.topic.Topic;
import com.example.springboot.topic.TopicController;

@RunWith(SpringJUnit4ClassRunner.class)
public class TopicMockMvcTest {

	@InjectMocks
	TopicController controller;
	private MockMvc mockMvc;
	
	@Before 
	public void setUp() throws Exception{
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	@Test
	public void getAllTopicsTest() throws Exception {
		List<Topic> topic = new ArrayList<Topic>();
		topic.add(new Topic("spring","spring frame work"," spring desc"));
		topic.add(new Topic("spring1","spring frame work1"," spring desc1"));
		mockMvc.perform(
				get("/topic").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect((ResultMatcher) jsonPath("$",Matchers.anyList().size()));
							
	}
}
