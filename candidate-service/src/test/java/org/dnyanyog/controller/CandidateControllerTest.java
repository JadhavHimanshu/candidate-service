package org.dnyanyog.controller;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.dnyanyog.common.ResponseCode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status; // For checking status code
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath; // For jsonPath

@SpringBootTest
@AutoConfigureMockMvc
public class CandidateControllerTest {
  @Autowired private MockMvc mockMvc;

  @Test
  public void AddCandidate() throws Exception {
      RequestBuilder requestBuilder = MockMvcRequestBuilders
          .post("/api/v1/auth/candidate")
          .content("{ \"firstName\": \"raghav\",\r\n"
                  + "  \"middleName\":  \"anil\",\r\n"
                  + "  \"lastName\": \"patil\",\r\n"
                  + "  \"vacancy\": 124,\r\n"
                  + "  \"email\": \"john.doe@example.com\",\r\n"
                  + "  \"mobile\": 98765430,\r\n"
                  + "  \"tenant\": \"AcmeCorp\" ,\r\n"
                  + "\"resumeMediaId\": 252} ")
          .contentType(MediaType.APPLICATION_JSON)
          .accept(MediaType.APPLICATION_JSON);
          mockMvc.perform(requestBuilder)
          .andExpect(status().isOk())  
          .andExpect(jsonPath("$.code").value(ResponseCode.Add_Candidate.getCode()))  
          .andExpect(jsonPath("$.message").value(ResponseCode.Add_Candidate.getMessage()))
          .andReturn(); 
  }
  
 
}
