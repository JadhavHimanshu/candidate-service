package org.dnyanyog.controller;

import org.dnyanyog.dto.CandidateRequest;
import org.dnyanyog.dto.CandidateResponse;
import org.dnyanyog.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CandidateController {
	
	@Autowired
	private CandidateService candidateService;

	@PostMapping("/addCandidate")
	public CandidateResponse addCandidate(@RequestBody CandidateRequest request) {
		return candidateService.addCandidate(request);

	} 

////	@GetMapping("/searchCandidate{resumeMediaId}")
////	public CandidateResponse searchCandidate(@PathVariable String resumeMediaId) {
////		return candidateService.findCandidateById(resumeMediaId);
////
////	}
////
////	@PostMapping("/updateCandidate")
////	public CandidateResponse updateCandidate(@PathVariable String resumeMediaId,
////			@RequestBody CandidateRequest request) {
////		return candidateService.updateCandidate(resumeMediaId, request);
////	}
////
////	@DeleteMapping("/deleteCandidate ")
////	public CandidateResponse deleteCandidate(@PathVariable String resumeMediaId) {
////		return candidateService.deleteCandidateById(resumeMediaId);
////	}
////
}
