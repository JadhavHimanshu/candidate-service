package org.dnyanyog.service;

import java.util.Optional;
import org.dnyanyog.CandidateServiceMain;
import org.dnyanyog.common.ResponseCode;
import org.dnyanyog.dto.CandidateRequest;
import org.dnyanyog.dto.CandidateResponse;
import org.dnyanyog.entity.Candidate;
import org.dnyanyog.repositories.CandidateRepo;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.testng.Assert;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = CandidateServiceMain.class)
public class CandidateServiceTest {
  @Mock CandidateRepo repo;
  @InjectMocks CandidateServiceImpl candidateService;
  @Autowired MockMvc mockMvc;

  @Test
  public void AddCandidate() throws Exception {
    CandidateRequest request = new CandidateRequest();
    request.setFirstName("himanshu");
    request.setMiddleName("sharad");
    request.setLastName("jadhav");
    request.setVacancy(3);
    request.setMobile(899947474);
    request.setResumeMediaId(23);
    request.setTenant("xyz");
    request.setEmail("jadhavhimanshu@1345gmail.com");
    Candidate candidateEntity = new Candidate();
    candidateEntity
        .setResumeMediaId(2)
        .setFirstName("himanshu")
        .setLastName("jadhav")
        .setMiddleName("sharad")
        .setEmail("jadhavhimanshu1345@gmail.com")
        .setMobile(899947474)
        .setVacancy(3);
    Mockito.when(repo.save(Mockito.any())).thenReturn(candidateEntity);
    CandidateResponse response = candidateService.addOrUpdateCandidate(request);
   
    Assert.assertEquals(ResponseCode.Add_Candidate.getCode(), response.getCode());
    Assert.assertEquals(ResponseCode.Add_Candidate.getMessage(), response.getMessage());
    Assert.assertNotNull(response);
  }

  @Test
  public void updateCandidate() throws Exception {
    CandidateRequest updateRequest = new CandidateRequest();
    updateRequest.setFirstName("himanshu");
    updateRequest.setMiddleName("sharad");
    updateRequest.setLastName("jadhav");
    updateRequest.setVacancy(5);
    updateRequest.setMobile(899947475);
    updateRequest.setResumeMediaId(23);
    updateRequest.setTenant("xyz");
    updateRequest.setEmail("jadhavhimanshu123@gmail.com");
    Candidate candidateEntity = new Candidate();
    candidateEntity
        .setFirstName("himanshu")
        .setMiddleName("sharad")
        .setLastName("jadhav")
        .setMobile(899947474)
        .setVacancy(3)
        .setEmail("jadhavhimanshu@1345gmail.com")
        .setResumeMediaId(23); 
     Mockito.when(repo.findByresumeMediaId(23)).thenReturn(Optional.of(candidateEntity));
    Mockito.when(repo.save(Mockito.any())).thenReturn(candidateEntity);
    CandidateResponse response = candidateService.addOrUpdateCandidate(updateRequest);

    Mockito.when(repo.findByresumeMediaId(23)).thenReturn(Optional.of(candidateEntity));

    Mockito.when(repo.save(Mockito.any())).thenAnswer(invocation -> invocation.getArgument(0));
   
   
    Assert.assertEquals(ResponseCode.Update_Candidate.getCode(), response.getCode());
    Assert.assertEquals(ResponseCode.Update_Candidate.getMessage(), response.getMessage());
  
    Assert.assertNotNull(response);
  }

  @Test
  public void updateCandidate_NotFound() throws Exception {
    CandidateRequest updateRequest = new CandidateRequest();
    updateRequest.setResumeMediaId(24); // Non-existent ID
    updateRequest.setFirstName("himanshu");
    updateRequest.setMiddleName("sharad");
    updateRequest.setLastName("jadhav");
    updateRequest.setVacancy(5);
    updateRequest.setMobile(899947475);
    updateRequest.setTenant("xyz");
    updateRequest.setEmail("jadhavhimanshu123@gmail.com");
    Mockito.when(repo.findByresumeMediaId(24)).thenReturn(Optional.empty());
    CandidateResponse response = candidateService.addOrUpdateCandidate(updateRequest);
    Assert.assertNotNull(response, "Response should not be null");
   
    Assert.assertEquals(ResponseCode.Candidate_Not_Found.getCode(), response.getCode());
    Assert.assertEquals(ResponseCode.Candidate_Not_Found.getMessage(), response.getMessage());
   
    Mockito.verify(repo, Mockito.never()).save(Mockito.any());
  }

  @Test
  public void findByResumeMediaId_Success() throws Exception {
    Candidate existingCandidate = new Candidate();
    existingCandidate.setResumeMediaId(23);
    existingCandidate.setFirstName("Himanshu");
    existingCandidate.setMiddleName("Sharad");
    existingCandidate.setLastName("Jadhav");
    existingCandidate.setVacancy(5);
    existingCandidate.setMobile(899947475);
    existingCandidate.setEmail("jadhavhimanshu123@gmail.com");
    Mockito.when(repo.findByresumeMediaId(23)).thenReturn(Optional.of(existingCandidate));
    CandidateResponse response = candidateService.findByresumeMediaId(23);
  
    Assert.assertEquals(ResponseCode.Search_Candidate.getCode(), response.getCode());
    Assert.assertEquals(ResponseCode.Search_Candidate.getMessage(), response.getMessage());
   
    Mockito.verify(repo).findByresumeMediaId(23);
  }

  @Test
  public void findByResumeMediaId_NotFound() throws Exception {
    Mockito.when(repo.findByresumeMediaId(23)).thenReturn(Optional.empty());
    CandidateResponse response = candidateService.findByresumeMediaId(23);
  
    Assert.assertEquals(ResponseCode.Candidate_Not_Found.getCode(), response.getCode());
    Assert.assertEquals(ResponseCode.Candidate_Not_Found.getMessage(), response.getMessage());
    Mockito.verify(repo).findByresumeMediaId(23);
  }

  @Test
  public void deleteById_Success() throws Exception {
    Candidate existingCandidate = new Candidate();
    existingCandidate.setResumeMediaId(23);
    existingCandidate.setFirstName("Himanshu");
    existingCandidate.setMiddleName("Sharad");
    existingCandidate.setLastName("Jadhav");
    existingCandidate.setVacancy(5);
    existingCandidate.setMobile(899947475);
    existingCandidate.setEmail("jadhavhimanshu123@gmail.com");
    Mockito.when(repo.findByresumeMediaId(23)).thenReturn(Optional.of(existingCandidate));
    Mockito.when(repo.deleteByresumeMediaId(23)).thenReturn(1);

    CandidateResponse response = candidateService.deleteByresumeMediaId(23);
    Assert.assertEquals(ResponseCode.Delete_Candidate.getCode(), response.getCode());
    Assert.assertEquals(ResponseCode.Delete_Candidate.getMessage(), response.getMessage());

    Mockito.verify(repo).findByresumeMediaId(23);

    Mockito.verify(repo).deleteByresumeMediaId(23);
  }
}
