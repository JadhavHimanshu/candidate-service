package org.dnyanyog.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import java.util.List;
import org.dnyanyog.dto.CandidateRequest;
import org.dnyanyog.dto.CandidateResponse;
import org.dnyanyog.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping 
 @Component
public class CandidateController {

  @Autowired private CandidateService candidateService;

  @PostMapping(
      path = "/api/v1/auth/candidate",
      consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
  public CandidateResponse addOrUpdateCandidate(@Valid @RequestBody CandidateRequest request)
      throws Throwable {
    if (request.getResumeMediaId() == null || request.getResumeMediaId() <= 0) {
      return candidateService.addOrUpdateCandidate(request);  
     
 } else {
	 return candidateService.addOrUpdateCandidate(request);
   } 
  }

  @GetMapping(path = "/api/v1/auth/candidate_search/{resumeMediaId}")
  public ResponseEntity<CandidateResponse> searchCandidate(
      @Valid @PathVariable Integer resumeMediaId) {
    CandidateResponse response = candidateService.findByresumeMediaId(resumeMediaId);
    return ResponseEntity.ok(response);
  }

  @GetMapping(path = "/api/v1/auth/candidate_search_bymobile/{mobile}")
  public ResponseEntity<CandidateResponse> searchCandidatebymobile(
      @Valid @PathVariable Integer mobile) {
    CandidateResponse response = candidateService.findBymobile(mobile);
    return ResponseEntity.ok(response);
  }

  @GetMapping(
      path = "/api/v1/auth/candidates",
      produces = {"application/json", "application/xml"})
  public ResponseEntity<List<CandidateResponse>> getAllCandidates(
      @RequestBody CandidateRequest request) {
    List<CandidateResponse> candidates = candidateService.getAllCandidates(request);
    return ResponseEntity.ok(candidates);
  }

  @DeleteMapping(path = "/candidate_delete/{resumeMediaId}")
  @Transactional
  public CandidateResponse deleteCandidate(@Valid @PathVariable Integer resumeMediaId) {
    return candidateService.deleteByresumeMediaId(resumeMediaId);
  }
}
