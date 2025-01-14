package org.dnyanyog.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import org.dnyanyog.common.ResponseCode;
import org.dnyanyog.dto.CandidateRequest;
import org.dnyanyog.dto.CandidateResponse;
import org.dnyanyog.encryption.EncryptionUtil;
import org.dnyanyog.entity.Candidate;
import org.dnyanyog.mapper.CandidateMapper;
import org.dnyanyog.repositories.CandidateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateServiceImpl implements CandidateService {
  @Autowired CandidateRepo repo;
  @Autowired EncryptionUtil encryptionService;

  private String generatedcandidateId() {
    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    StringBuilder Id = new StringBuilder();
    Random random = new Random();
    for (int i = 0; i < 12; i++) {
      Id.append(characters.charAt(random.nextInt(characters.length())));
    }
    return Id.toString();
  }

  @Override
  public CandidateResponse addCandidate(CandidateRequest request) throws Exception {
    String Id = generatedcandidateId();
    String encryptedResumeId = encryptionService.encrypt(request.getResumeMediaId());
    Candidate candidate = CandidateMapper.toEntity(request, encryptedResumeId);
    Candidate saveCandidate = repo.save(candidate);
    return CandidateMapper.toDto(
        saveCandidate,
        ResponseCode.Add_Candidate.getMessage(),
        ResponseCode.Add_Candidate.getCode());
  }

  @Override
  public CandidateResponse findByresumeMediaId(Integer resumeMediaId) {
    Optional<Candidate> candidateData = repo.findByresumeMediaId(resumeMediaId);
    if (candidateData.isPresent()) {
      return CandidateMapper.toDto(
          candidateData.get(),
          ResponseCode.Search_Candidate.getMessage(),
          ResponseCode.Search_Candidate.getCode());
    } else {
      CandidateResponse response = new CandidateResponse();
      response.setMessage(ResponseCode.Candidate_Not_Found.getMessage());
      response.setResponseCode(ResponseCode.Candidate_Not_Found.getCode());
      return response;
    }
  }

  @Override
  public CandidateResponse updateCandidate(CandidateRequest request) throws Exception {
    CandidateResponse response = new CandidateResponse();
    Optional<Candidate> candidateData = this.repo.findByresumeMediaId(request.getResumeMediaId());
    if (candidateData.isPresent()) {
      String encryptedResumeMediaId = encryptionService.encrypt(request.getResumeMediaId());
      Candidate updateCandidate = CandidateMapper.toEntity(request, encryptedResumeMediaId);
      Candidate saveCandidate = repo.save(updateCandidate);
      return CandidateMapper.toDto(
          saveCandidate,
          ResponseCode.Update_Candidate.getMessage(),
          ResponseCode.Update_Candidate.getCode());
    } else {
      response.setMessage(ResponseCode.Candidate_Not_Found.getMessage());
      response.setResponseCode(ResponseCode.Candidate_Not_Found.getCode());
      return response;
    }
  }

  @Override
  public CandidateResponse deleteByresumeMediaId(long resumeMediaId) {
    CandidateResponse response = new CandidateResponse();
    Optional<Candidate> candidateData = this.repo.findByresumeMediaId(resumeMediaId);
    if (candidateData.isPresent()) {
      int rowsDeleted = repo.deleteByresumeMediaId(resumeMediaId);
      if (rowsDeleted > 0) {
        response.setMessage(ResponseCode.Delete_Candidate.getMessage());
        response.setResponseCode(ResponseCode.Delete_Candidate.getCode());
      }

    } else {
      response.setMessage(ResponseCode.Candidate_Not_Found.getMessage());
      response.setResponseCode(ResponseCode.Candidate_Not_Found.getCode());
    }

    return response;
  }

  @Override
  public List<CandidateResponse> getAllCandidates(CandidateRequest request) {
    List<Candidate> candidates = repo.findAll();
    List<CandidateResponse> response =
        candidates.stream()
            .map(
                candidateEntity ->
                    CandidateMapper.toDto(
                        candidateEntity,
                        ResponseCode.Search_Candidate.getMessage(),
                        ResponseCode.Search_Candidate.getCode()))
            .collect(Collectors.toList());
    return response;
  }

  @Override
  public CandidateResponse findBymobile(Integer mobile) {
    Optional<Candidate> candidateData = repo.findBymobile(mobile);
    if (candidateData.isPresent()) {
      return CandidateMapper.toDto(
          candidateData.get(),
          ResponseCode.Search_Candidate.getMessage(),
          ResponseCode.Search_Candidate.getCode());
    } else {
      CandidateResponse response = new CandidateResponse();
      response.setMessage(ResponseCode.Candidate_Not_Found.getMessage());
      response.setResponseCode(ResponseCode.Candidate_Not_Found.getCode());
      return response;
    }
  }
}
