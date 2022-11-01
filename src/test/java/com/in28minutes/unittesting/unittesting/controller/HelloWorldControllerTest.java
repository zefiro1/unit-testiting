package com.in28minutes.unittesting.unittesting.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;


@WebMvcTest(HelloWorldController.class)
class HelloWorldControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void helloWorld() throws Exception {
    //CALL GET "/hello-world" application/json
    RequestBuilder request = MockMvcRequestBuilders
        .get("/hello-world")
        .accept(MediaType.APPLICATION_JSON);
    MvcResult mvcResult = mockMvc.perform(request).andReturn();

    //verify "Hello World"
    assertEquals("Hello World",mvcResult.getResponse().getContentAsString());



  }
}