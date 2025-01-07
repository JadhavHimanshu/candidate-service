package org.dnyanyog.service;

import org.dnyanyog.dto.CandidateRequest;
import org.dnyanyog.dto.CandidateResponse;

public interface CandidateService {
  public CandidateResponse addCandidate(CandidateRequest request) throws Throwable;

  public CandidateResponse findByresumeMediaId(Integer resumeMediaId);

  public CandidateResponse updateCandidate(CandidateRequest request);

  public CandidateResponse deleteByresumeMediaId(long resumeMediaId);
}
