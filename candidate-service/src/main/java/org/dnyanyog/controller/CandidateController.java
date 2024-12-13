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

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
public class CandidateController {

	@Autowired
	private CandidateService candidateService;

	@PostMapping(path = "/api/v1/auth/addcandidate", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	public CandidateResponse addCandidate(@Valid @RequestBody CandidateRequest request) {
		return candidateService.addCandidate(request);

	}

	@GetMapping(path = "/api/v1/auth/candidate_search/{resumeMediaId}")

	public CandidateResponse searchCandidate( @Valid @PathVariable Integer resumeMediaId) {
		return candidateService.findByresumeMediaId(resumeMediaId);

	}

	@PostMapping(path = "/api/v1/auth/candidate_update", consumes = { "application/json",
			"application/xml" }, produces = { "application/json", "application/xml " })
	public CandidateResponse updateCandidate(@Valid @RequestBody CandidateRequest request) {
		return candidateService.updateCandidate(request);
	}

	@DeleteMapping(path = "/api/v1/auth/candidate_delete/{resumeMediaId}")
	@Transactional
	public CandidateResponse deleteCandidate( @Valid @PathVariable long resumeMediaId) {
		return candidateService.deleteByresumeMediaId(resumeMediaId);
	}

}
