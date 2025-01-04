package org.dnyanyog.controller;

import org.dnyanyog.CandidateServiceMain;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = CandidateServiceMain.class)
public class CandidateTestController {
	@Autowired
	MockMvc mockMvc;

	@Test
	public void AddCandidate() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/auth/addcandidate")
				.content("{\n" + "  \"firstName\": \"himanshu\",\n" + "  \"middleName\": \"sharad\",\n"
						+ "  \"lastName\": \"jadhav\",\n" + "  \"vacancy\": 123,\n"
						+ "  \"email\": \"jadhavhimanshu1231@gmail.com\",\n" + "  \"mobile\": 9876543023,\n"
						+ "  \"tenant\": \"AcmeCorp\",\n" + "  \"resumeMediaId\": 103\n" + "}")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Candidate Added Sucessfully"))
				.andReturn();
	}

	@Test
	public void updateCandidate() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/auth/candidate_update")
				.content("\"firstName\": \"raghav\",\n" + "  \"middleName\":  \"anil\",\n"
						+ "  \"lastName\": \"patil\",\n" + "  \"vacancy\": 123,\n"
						+ "  \"email\": \"john.doe@example.com\",\n" + "  \"mobile\": 9876543045,\n"
						+ "  \"tenant\": \"AcmeCorp\" ,\n" + "\"resumeMediaId\": 252} ")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Candidate Updated Sucessfully"))
				.andReturn();

	}
	@Test
	public void searchCandidateSucess() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("api/v1/auth/candidate_search/").content("")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("raghav"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.middleName").value("anil"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("patil"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.email").value("9876543043")) 
				.andExpect(MockMvcResultMatchers.jsonPath("$.mobile").value("john.doe@example.com"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.tenant").value("AcmeCorp"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.resumeMediaId").value("223"))


				.andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Candidate Found")).andReturn();

	}
	@Test
	public void candidateNotFound() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("api/v1/auth/candidate_search/")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Candidate Not Found")).andReturn();

	}
	@Test
	public void deletebyId() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/auth/candidate_delete/")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Candidate Deleted Sucessfully"))
				.andReturn();
	}

}
