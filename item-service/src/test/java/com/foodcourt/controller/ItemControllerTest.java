package com.foodcourt.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.RETURNS_MOCKS;

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
import com.foodcourt.model.Item;
import com.foodcourt.model.UOM;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(ItemControllerTest.class)
public class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemController itemController;
	
	@Test
	public void testIsOk() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/item/item")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testNotFound() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/item")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}
	@Test
	public void testSave()throws Exception
	{
		Item item= new Item();
		item.setId(1L);
		item.setName("Panadol");
		item.setUnitPrice(new BigDecimal(10));
		item.setSalesPrice(new BigDecimal(15));
		//item.setQuentity(100);
		item.setDiscount(new BigDecimal(2));
		
		UOM uom= new UOM();
		uom.setName("Boxes");
		item.setUom(uom);
		
		Batch batch = new Batch();
		batch.setId(1);
		//item.setBatch(batch);
		
		ObjectMapper objectMapper= new ObjectMapper();
		String str= objectMapper.writeValueAsString(item);
		mockMvc.perform(MockMvcRequestBuilders.post("/item/item")
				.contentType(MediaType.APPLICATION_JSON)
				.content(str)).andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	public void testUpdate()throws Exception
	{
		Item item= new Item();
		item.setId(1L);
		item.setSalesPrice(new BigDecimal(17));
	//	item.setQuentity(100);
		item.setDiscount(new BigDecimal(2));
		
		UOM uom= new UOM();
		uom.setName("Boxes");
		item.setUom(uom);
		
		Batch batch = new Batch();
		batch.setId(1);
	//	item.setBatch(batch);
		
		ObjectMapper objectMapper= new ObjectMapper();
		String str= objectMapper.writeValueAsString(item);
		mockMvc.perform(MockMvcRequestBuilders.put("/item/item")
				.contentType(MediaType.APPLICATION_JSON)
				.content(str)).andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	public void testDelete()throws Exception
	{
		Item item= new Item();
		item.setId(1L);
		item.setSalesPrice(new BigDecimal(17));
	//	item.setQuentity(100);
		item.setDiscount(new BigDecimal(2));
		UOM uom= new UOM();
		uom.setName("Boxes");
		item.setUom(uom);
		Batch batch = new Batch();
		batch.setId(1);
	//	item.setBatch(batch);
		ObjectMapper objectMapper= new ObjectMapper();
		String str= objectMapper.writeValueAsString(item);
		mockMvc.perform(MockMvcRequestBuilders.delete("/item/item")
				.contentType(MediaType.APPLICATION_JSON)
				.content(str)).andExpect(MockMvcResultMatchers.status().isOk());
	}
}
