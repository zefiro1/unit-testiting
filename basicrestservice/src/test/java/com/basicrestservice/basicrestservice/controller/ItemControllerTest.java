package com.basicrestservice.basicrestservice.controller;

import com.basicrestservice.basicrestservice.bussines.ItemBusinessService;
import com.basicrestservice.basicrestservice.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
class ItemControllerTest {
  @Autowired
  private MockMvc mockMvc;
  @MockBean
  private ItemBusinessService businessService;

  @Test
  void dummyItem() throws Exception {
    //CALL GET "/hello-world" application/json
    RequestBuilder request = MockMvcRequestBuilders
        .get("/dummy-item")
        .accept(MediaType.APPLICATION_JSON);

    MvcResult mvcResult = mockMvc.perform(request)
        .andExpect(status().isOk())
        .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
        .andReturn();

  }

  @Test
  void itemFromBusinesService() throws Exception {

    when(businessService.retriveHardcodedItem()).thenReturn(
        new Item(2,"Item2",10,10)
    );



    //CALL GET "/hello-world" application/json
    RequestBuilder request = MockMvcRequestBuilders
        .get("/item-from-business-service")
        .accept(MediaType.APPLICATION_JSON);

    MvcResult mvcResult = mockMvc
        .perform(request)
        .andExpect(status().isOk())
        .andExpect(content().json("{id:2,name:Item2,price:10,quantity:10}"))
        .andReturn();

  }

  @Test
  void retriveAllItems() throws Exception {


    when(businessService.retriveAllItems()).thenReturn(
        Arrays.asList(new Item(2,"Item2",10,10),new Item(3,"Item3",10,10))
    );



    //CALL GET "/hello-world" application/json
    RequestBuilder request = MockMvcRequestBuilders
        .get("/all-items-from-database")
        .accept(MediaType.APPLICATION_JSON);

    MvcResult mvcResult = mockMvc
        .perform(request)
        .andExpect(status().isOk())
        .andExpect(content().json("[{id:2,name:Item2,price:10,quantity:10},{id:3,name:Item3,price:10,quantity:10}]"))
        .andReturn();


  }
}