package org.dnyanyog.service;

import java.util.List;
import org.dnyanyog.dto.CandidateRequest;
import org.dnyanyog.dto.CandidateResponse;

public interface CandidateService {
  public CandidateResponse addOrUpdateCandidate(CandidateRequest request) throws Throwable;

  public CandidateResponse findByresumeMediaId(Integer resumeMediaId);

  public CandidateResponse updateCandidate(CandidateRequest request) throws Exception;

  public CandidateResponse deleteByresumeMediaId(long resumeMediaId);

  public List<CandidateResponse> getAllCandidates(CandidateRequest requet);

  public CandidateResponse findBymobile(Integer mobile);
}
