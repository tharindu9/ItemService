package com.foodcourt.controller;

import static org.junit.Assert.*;

import java.math.BigDecimal;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.foodcourt.model.Batch;
import com.foodcourt.model.Category;
import com.foodcourt.model.Item;
import com.foodcourt.model.UOM;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(ItemControllerTest.class)
public class CategoryControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CategoryController categoryController;
	

	@Test
	public void testIsOk() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/category/category")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	public void testNotFound() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/category")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}
	@Test
	public void testSave()throws Exception
	{
		Category category= new Category();
		category.setId(1);
		category.setName("Pain-Killers");
		
		ObjectMapper objectMapper= new ObjectMapper();
		String str= objectMapper.writeValueAsString(category);
		mockMvc.perform(MockMvcRequestBuilders.post("/category/category")
				.contentType(MediaType.APPLICATION_JSON)
				.content(str)).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testUpdate()throws Exception
	{
		Category category= new Category();
		category.setId(1);
		category.setName("Medicine");
		
		ObjectMapper objectMapper= new ObjectMapper();
		String str= objectMapper.writeValueAsString(category);
		mockMvc.perform(MockMvcRequestBuilders.put("/category/category/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(str)).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testDelete()throws Exception
	{
		Category category= new Category();
		category.setId(1);
		
		ObjectMapper objectMapper= new ObjectMapper();
		String str= objectMapper.writeValueAsString(category);
		mockMvc.perform(MockMvcRequestBuilders.delete("/category/category/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(str)).andExpect(MockMvcResultMatchers.status().isOk());
	}
}
