package org.dnyanyog.service;

import org.dnyanyog.dto.CandidateRequest;
import org.dnyanyog.dto.CandidateResponse;
import org.springframework.data.jpa.repository.Query;

public interface CandidateService {
	public CandidateResponse addCandidate(CandidateRequest request);
 
	@Query(value = "SELECT * FROM Candidate c WHERE c.resume_id = resume_id " , nativeQuery = true )
	public CandidateResponse findByresumeMediaId(Integer resumeMediaId);

	public CandidateResponse updateCandidate(CandidateRequest request);

	public CandidateResponse deleteByresumeMediaId(long resumeMediaId);
	 

}
