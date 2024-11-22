package org.dnyanyog.service;

import org.dnyanyog.dto.CandidateRequest;
import org.dnyanyog.dto.CandidateResponse;

public interface CandidateService {
	public CandidateResponse addCandidate(CandidateRequest request);

//	public CandidateResponse findCandidateById(String resumeMediaId);
//
//	public CandidateResponse updateCandidate(String resumeMediaId, CandidateRequest request);
//
//	public CandidateResponse deleteCandidateById(String resumeMediaId);

}
