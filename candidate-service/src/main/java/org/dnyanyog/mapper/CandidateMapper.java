package org.dnyanyog.mapper;

import org.dnyanyog.dto.CandidateRequest;
import org.dnyanyog.dto.CandidateResponse;
import org.dnyanyog.entity.Candidate;

public class CandidateMapper {
  public static Candidate toEntity(CandidateRequest request, String encryptedResumeId) {
    return Candidate.getInstance()
        .setFirstName(request.getFirstName())
        .setMiddleName(request.getMiddleName())
        .setLastName(request.getLastName())
        .setEmail(request.getEmail())
        .setMobile(request.getMobile())
        .setResumeMediaId(request.getResumeMediaId())
        .setVacancy(request.getVacancy()); 
       
    
  }

  public static CandidateResponse toDto(Candidate candidate, String code , String message) {
    CandidateResponse response = new CandidateResponse();
    response.setMessage(message);
    response.setCode(code);
    response.setFirstName(candidate.getFirstName());
    response.setMiddleName(candidate.getMiddleName());
    response.setLastName(candidate.getLastName());
    response.setEmail(candidate.getEmail());
    response.setResumeMediaId(candidate.getResumeMediaId());
    response.setMobile(candidate.getMobile());
    response.setVacancy(candidate.getVacancy());
    response.setCandidatecode(candidate.getCandidatecode());
    response.setCandidateId(candidate.getCandidateId());
    return response;
  }
}
