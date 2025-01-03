package org.dnyanyog.service;

import java.util.Optional;

import org.dnyanyog.common.ResponseCode;
import org.dnyanyog.dto.CandidateRequest;
import org.dnyanyog.dto.CandidateResponse;
import org.dnyanyog.encryption.EncryptionUtil;
import org.dnyanyog.entity.Candidate;
import org.dnyanyog.repositories.CandidateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CandidateServiceImpl implements CandidateService {
	@Autowired
	CandidateRepo repo;
	@Autowired
	EncryptionUtil encryptionService;

	@Override
	public CandidateResponse addCandidate(CandidateRequest request) throws Exception {
		CandidateResponse response = new CandidateResponse();
		Candidate data = Candidate.getInstance().setFirstName(request.getFirstName())
				.setMiddleName(request.getMiddleName()).setLastName(request.getLastName()).setEmail(request.getEmail())
				.setVacancy(request.getVacancy()).setEmail(request.getEmail()).setMobile(request.getMobile())
				.setResumeMediaId(encryptionService.encrypt(request.getResumeMediaId()));
		data = repo.save(data);
		response.setMessage(ResponseCode.Add_Candidate.getMessage());
		response.setResponseCode(ResponseCode.Add_Candidate.getCode());
		response.setFirstName(data.getFirstName());
		response.setLastName(data.getLastName());
		response.setMiddleName(data.getMiddleName());
		response.setEmail(data.getEmail());
		response.setMobile(data.getMobile());
		response.setVacancy(data.getVacancy());
		response.setResumeMediaId(data.getResumeMediaId());

		return response;
	}

	@Override
	public CandidateResponse findByresumeMediaId(Integer resumeMediaId) {
		CandidateResponse response = new CandidateResponse();
		Optional<Candidate> candidateData = repo.findByresumeMediaId(resumeMediaId);
		if (candidateData.isEmpty()) {
			response.setMessage(ResponseCode.Candidate_Not_Found.getMessage());
			response.setResponseCode(ResponseCode.Candidate_Not_Found.getCode());
		} else {
			Candidate candidate = candidateData.get();
			response.setMessage(ResponseCode.Search_Candidate.getMessage());
			response.setResponseCode(ResponseCode.Search_Candidate.getCode());
			response.setFirstName(candidate.getFirstName());
			response.setMiddleName(candidate.getMiddleName());
			response.setLastName(candidate.getLastName());
			response.setEmail(candidate.getEmail());
			response.setMobile(candidate.getMobile());
			response.setVacancy(candidate.getVacancy());
			response.setResumeMediaId(candidate.getResumeMediaId());

		}

		return response;
	}

	@Override
	public CandidateResponse updateCandidate(CandidateRequest request) {
		CandidateResponse response = new CandidateResponse();
		Optional<Candidate> candidateData = this.repo.findByresumeMediaId(request.getResumeMediaId());
		if (candidateData.isPresent()) {
			Candidate candidate = Candidate.getInstance().setFirstName(request.getFirstName())
					.setMiddleName(request.getMiddleName()).setLastName(request.getLastName())
					.setEmail(request.getEmail()).setMobile(request.getMobile()).setVacancy(request.getVacancy());
			candidate = repo.save(candidate);
			response.setMessage(ResponseCode.Update_Candidate.getMessage());
			response.setResponseCode(ResponseCode.Update_Candidate.getCode());
			response.setFirstName(candidate.getFirstName());
			response.setMiddleName(candidate.getMiddleName());
			response.setLastName(candidate.getLastName());
			response.setEmail(candidate.getEmail());
			response.setMobile(candidate.getMobile());
			response.setVacancy(candidate.getVacancy());
			response.setResumeMediaId(candidate.getResumeMediaId());

		} else {
			response.setMessage(ResponseCode.Candidate_Not_Found.getMessage());
			response.setResponseCode(ResponseCode.Candidate_Not_Found.getCode());
		}

		return response;
	}

	@Override
	public CandidateResponse deleteByresumeMediaId(long resumeMediaId) {
		CandidateResponse response = new CandidateResponse();
		Optional<Candidate> candidateData = this.repo.findByresumeMediaId(resumeMediaId);
		if (candidateData.isPresent()) {
			repo.deleteByresumeMediaId(resumeMediaId);
			response.setMessage(ResponseCode.Delete_Candidate.getMessage());
			response.setResponseCode(ResponseCode.Delete_Candidate.getCode());

		} else {
			response.setMessage(ResponseCode.Candidate_Not_Found.getMessage());
			response.setResponseCode(ResponseCode.Candidate_Not_Found.getCode());
		}

		return response;
	}

}
