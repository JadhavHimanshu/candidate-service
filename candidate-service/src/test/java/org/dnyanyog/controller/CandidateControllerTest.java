package org.dnyanyog.controller;

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

import javax.net.ssl.SSLEngineResult.Status;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath; // For jsonPath

@SpringBootTest
@AutoConfigureMockMvc
public class CandidateControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void AddCandidate_Sucess() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/auth/candidate")
				.content("{ \"firstName\": \"raghav\",\r\n" + "  \"middleName\":  \"anil\",\r\n"
						+ "  \"lastName\": \"patil\",\r\n" + "  \"vacancy\": 124,\r\n"
						+ "  \"email\": \"john.doe@example.com\",\r\n" + "  \"mobile\": 9876543089,\r\n"
						+ "  \"tenant\": \"AcmeCorp\" ,\r\n" + "\"resumeMediaId\": 252} ")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(status().isOk())
				.andExpect(jsonPath("$.code").value(ResponseCode.Add_Candidate.getCode()))
		.andExpect(jsonPath("$.message").value(ResponseCode.Add_Candidate.getMessage())).andReturn();
	}

	@Test
	public void AddCandidate_Fail() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/auth/candidate")
				.content("{ \"firstName\": \"raghav\",\r\n" + "  \"middleName\":  \"anil\",\r\n"
						+ "  \"lastName\": \"patil\",\r\n" + "  \"vacancy\": 124,\r\n"
						+ "  \"email\": \"john.doe@gmail.com\",\r\n" + "  \"mobile\": 9876543089,\r\n"
						+ "  \"tenant\": \"AcmeCorp\" ,\r\n" + "\"resumeMediaId\": 252} ")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(status().isOk())
				.andExpect(jsonPath("$.code").value(ResponseCode.Candidate_Not_Found.getCode()))
				.andExpect(jsonPath("$.message").value(ResponseCode.Candidate_Not_Found.getMessage())).andReturn();

	}

	@Test
	public void UpdateCandidate_Success() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/auth/candidate")
				.content("{ \"firstName\": \"raghav\",\r\n" + "  \"middleName\": \"anil\",\r\n"
						+ "  \"lastName\": \"sharma\",\r\n" + "  \"vacancy\": 125,\r\n"
						+ "  \"email\": \"raghav123@gmail.com\",\r\n" + "  \"mobile\": 9876543044,\r\n"
						+ "  \"tenant\": \"AcmeCorp\",\r\n" + "  \"resumeMediaId\": 252 }")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(requestBuilder).andExpect(status().isOk())
				.andExpect(jsonPath("$.code").value(ResponseCode.Update_Candidate.getCode())) // Assuming
																								// Update_Candidate
																								// exists in
																								// ResponseCode
				.andExpect(jsonPath("$.message").value(ResponseCode.Update_Candidate.getMessage())).andReturn();
	}

	@Test
	public void UpdateCandidate_Fail() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/auth/candidate")
				.content("{ \"firstName\": \"raghav\",\r\n" + "  \"middleName\": \"anil\",\r\n"
						+ "  \"lastName\": \"sharma\",\r\n" + "  \"vacancy\": 125,\r\n"
						+ "  \"email\": \"raghav123@gmail.com\",\r\n" + "  \"mobile\": 9876543044,\r\n"
						+ "  \"tenant\": \"AcmeCorp\",\r\n" + "  \"resumeMediaId\": 252 }")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(jsonPath("$.code").value(ResponseCode.Candidate_Not_Found.getCode()))
				.andExpect(jsonPath("$.message").value(ResponseCode.Candidate_Not_Found.getMessage())).andReturn();
	}

	@Test
	public void SearchCandidate_Success() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/auth/candidate_search/252")
				.accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(requestBuilder).andExpect(status().isOk())
				.andExpect(jsonPath("$.code").value(ResponseCode.Search_Candidate.getCode()))
				.andExpect(jsonPath("$.message").value(ResponseCode.Search_Candidate.getMessage())).andReturn();
	}

	@Test
	public void SearchCandidate_Fail_NotFound() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/auth/candidate_search/9999")
				.accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(requestBuilder).andExpect(status().isNotFound())
				.andExpect(jsonPath("$.code").value(ResponseCode.Candidate_Not_Found.getCode()))
				.andExpect(jsonPath("$.message").value("Candidate not found")).andReturn();
	}

	@Test
	public void SearchCandidateByMobile_Success() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/auth/candidate_search_bymobile/9876543044")
				.accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(requestBuilder).andExpect(status().isOk())
				.andExpect(jsonPath("$.code").value(ResponseCode.Search_Candidate.getCode()))
				.andExpect(jsonPath("$.message").value(ResponseCode.Search_Candidate.getMessage()))
				.andExpect(jsonPath("$.data.firstname").value("raghav"))
				.andExpect(jsonPath("$.data.lastname").value("sharma")).andExpect(jsonPath("$.data.mobile").value("9876543044"))
				.andExpect(jsonPath("$.data.middleName").value("anil")).andExpect(jsonPath("$.data.email").value("raghav123@gmail.com"))
				.andExpect(jsonPath("$.data.vacancy").value("125")).andExpect(jsonPath("$.data.tenant").value("AcmeCorp"))
				.andExpect(jsonPath("$.data.resumeMediaId").value("252"))

				.andReturn();
	}

	@Test
	public void SearchCandidateByMobile_Fail_NotFound() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/auth/candidate_search_bymobile/1234567890")
				.accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(requestBuilder).andExpect(status().isNotFound())
				.andExpect(jsonPath("$.code").value(ResponseCode.Candidate_Not_Found.getCode()))
				.andExpect(jsonPath("$.message").value(ResponseCode.Candidate_Not_Found.getMessage())).andReturn();
	}

	@Test
	public void DeleteCandidate_Success() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/v1/auth/candidate_delete/252")
				.accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(requestBuilder).andExpect(status().isOk())
				.andExpect(jsonPath("$.code").value(ResponseCode.Delete_Candidate.getCode()))
				.andExpect(jsonPath("$.message").value(ResponseCode.Delete_Candidate.getMessage())).andReturn();
	}

	@Test
	public void DeleteCandidate_Fail_NotFound() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/v1/auth/candidate_delete/9999")
				.accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(requestBuilder).andExpect(status().isNotFound())
				.andExpect(jsonPath("$.code").value(ResponseCode.Candidate_Not_Found.getCode()))
				.andExpect(jsonPath("$.message").value(ResponseCode.Candidate_Not_Found.getMessage())).andReturn();
	}

}
