package com.example.demo.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ContextConfiguration
public class BookControllerIntegrationTest {

  @LocalServerPort
  private int port;

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void getBook_success() throws Exception {
    mockMvc.perform(get("/v1/book/3")
                    .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
  }

  @Test
  public void getBookByTitle() throws Exception {
    mockMvc.perform(get("/v1/book/byTitle")
                    .queryParam("title", "Dune")
                    .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
  }
}
