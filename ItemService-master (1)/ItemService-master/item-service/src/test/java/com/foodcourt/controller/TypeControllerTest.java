package com.foodcourt.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.foodcourt.model.Category;
import com.foodcourt.model.ItemType;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(TypeControllerTest.class)
public class TypeControllerTest {
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	

	private MockMvc mockMvc;
	
	@MockBean
	private TypeController typeController;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testIsOk() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/typecloud/itemtype/1")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	@Test
	public void testNotFound() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/typecloud/itemtype/")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
		
	}
	
	@Test
	public void testSave()throws Exception{
		
		ItemType itemType= new ItemType();
		itemType.setId(1);
		itemType.setName("Perfume");
		Category category= new Category();
		category.setId(1);
		itemType.setCategory(category);
		
		ObjectMapper objectMapper= new ObjectMapper();
		String str= objectMapper.writeValueAsString(itemType);
		mockMvc.perform(MockMvcRequestBuilders.post("/typecloud/category/1/itemtype/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(str)).andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	public void testUpdate()throws Exception{
		
		ItemType itemType= new ItemType();
		itemType.setId(1);
		itemType.setName("Soap");
		Category category= new Category();
		category.setId(1);
		itemType.setCategory(category);
		
		ObjectMapper objectMapper= new ObjectMapper();
		String str= objectMapper.writeValueAsString(itemType);
		mockMvc.perform(MockMvcRequestBuilders.put("/typecloud/category/1/itemtype/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(str)).andExpect(MockMvcResultMatchers.status().isOk());
	}


	@Test
	public void testDelete()throws Exception{
		
		ItemType itemType= new ItemType();
		itemType.setId(1);
	
		
		ObjectMapper objectMapper= new ObjectMapper();
		String str= objectMapper.writeValueAsString(itemType);
		mockMvc.perform(MockMvcRequestBuilders.delete("/typecloud/category/1/itemtype/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(str)).andExpect(MockMvcResultMatchers.status().isOk());
	}
}
