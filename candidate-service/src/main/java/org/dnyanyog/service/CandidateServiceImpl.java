package org.dnyanyog.service;

import java.util.Optional;

import org.dnyanyog.dto.CandidateRequest;
import org.dnyanyog.dto.CandidateResponse;
import org.dnyanyog.entity.Candidate;
import org.dnyanyog.repositories.CandidateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class CandidateServiceImpl implements CandidateService {
	@Autowired
	CandidateRepo repo;

	@Override
	public CandidateResponse addCandidate(CandidateRequest request) {
		CandidateResponse response = new CandidateResponse();
		Candidate data = new Candidate();
		data.setFirstName(request.getFirstName());
		data.setMiddleName(request.getMiddleName());
		data.setLastName(request.getLastName());
		data.setEmail(request.getEmail());
		data.setVacancy(request.getVacancy());
		data.setEmail(request.getEmail());
		data.setMobile(request.getMobile());
		data.setResumeMediaId(request.getResumeMediaId());
		data = repo.save(data);
		response.setMessage("Candidate Added Sucessfully");
		response.setResponseCode("0000");

		response.setFirstName(data.getFirstName());
		response.setLastName(data.getLastName());
		response.setMiddleName(data.getMiddleName());
		response.setEmail(data.getEmail());
		response.setMobile(data.getMobile());
		response.setVacancy(data.getVacancy());  
		 response.setResumeMediaId(data.getResumeMediaId());

		return response;
	}

//	@Override
//	public CandidateResponse findCandidateById(String resumeMediaId) {
//		CandidateResponse response = new CandidateResponse();
//		Optional<Candidate> candidateData = this.repo.findById(resumeMediaId);
//		if (candidateData.isEmpty()) {
//			response.setMessage("Candidate Not found ");
//			response.setResponseCode("911");
//		} else {
//			Candidate candidate = candidateData.get();
//			response.setMessage("User  Found ");
//			response.setResponseCode("0000");
//			response.setFirstName(candidate.getFirstName());
//			response.setMiddleName(candidate.getMiddleName());
//			response.setLastName(candidate.getLastName());
//			response.setEmail(candidate.getEmail());
//			response.setMobile(candidate.getMobile());
//			response.setVacancy(candidate.getVacancy());
//
//		}
//
//		return response;
//	}
//
//	@Override
//	public CandidateResponse updateCandidate(String resumeMediaId, CandidateRequest request) {
//		CandidateResponse response = new CandidateResponse();
//		Optional<Candidate> candidateData = this.repo.findById(resumeMediaId);
//		if (candidateData.isPresent()) {
//			Candidate candidate = candidateData.get();
//			candidate.setFirstName(request.getFirstName());
//			candidate.setMiddleName(request.getMiddleName());
//			candidate.setLastName(request.getLastName());
//			candidate.setEmail(request.getEmail());
//			candidate.setMobile(request.getMobile());
//			candidate.setVacancy(request.getVacancy());
//			candidate.setResumeMediaId(request.getResumeMediaId());
//			candidate = repo.save(candidate);
//			response.setMessage(" Candidate Updated ");
//			response.setResponseCode("0000");
//
//		} else {
//			response.setMessage(" User Not Found ");
//			response.setResponseCode("911");
//		}
//
//		return response;
//	}
//
//	@Override
//	public CandidateResponse deleteCandidateById(String resumeMediaId) {
//		CandidateResponse response = new CandidateResponse();
//		Optional<Candidate> candidateData = this.repo.findById(resumeMediaId);
//		if (candidateData.isPresent()) {
//			repo.deleteById(resumeMediaId);
//			response.setMessage("User Deleted Sucessfully");
//			response.setResponseCode("0000");
//
//		} else {
//			response.setMessage(" Candidate Not Found ");
//			response.setResponseCode("911");
//		}
//
//		return response;
//	}

}
