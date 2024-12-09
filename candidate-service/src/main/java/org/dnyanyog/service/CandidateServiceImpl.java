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
public class CandidateServiceImpl implements CandidateService {
	@Autowired
	CandidateRepo repo;

	@Override
	public CandidateResponse addCandidate(CandidateRequest request) {
		CandidateResponse response = new CandidateResponse();
		Candidate data = Candidate.getInstance().setFirstName(request.getFirstName())
				.setMiddleName(request.getMiddleName()).setLastName(request.getLastName()).setEmail(request.getEmail())
				.setVacancy(request.getVacancy()).setEmail(request.getEmail()).setMobile(request.getMobile())
				.setResumeMediaId(request.getResumeMediaId());
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

	@Override
	public CandidateResponse findByresumeMediaId(Integer resumeMediaId) {
		CandidateResponse response = new CandidateResponse();
		Optional<Candidate> candidateData = repo.findByresumeMediaId(resumeMediaId);
		if (candidateData.isEmpty()) {
			response.setMessage("Candidate Not found ");
			response.setResponseCode("911");
		} else {
			Candidate candidate = candidateData.get();
			response.setMessage("Candidate  Found ");
			response.setResponseCode("0000");
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
			response.setMessage(" Candidate Updated ");
			response.setResponseCode("0000");
			response.setFirstName(candidate.getFirstName());
			response.setMiddleName(candidate.getMiddleName());
			response.setLastName(candidate.getLastName());
			response.setEmail(candidate.getEmail());
			response.setMobile(candidate.getMobile());
			response.setVacancy(candidate.getVacancy());
			response.setResumeMediaId(candidate.getResumeMediaId());

		} else {
			response.setMessage(" User Not Found ");
			response.setResponseCode("911");
		}

		return response;
	}

	@Override
	public CandidateResponse deleteByresumeMediaId(long resumeMediaId) {
		CandidateResponse response = new CandidateResponse();
		Optional<Candidate> candidateData = this.repo.deleteByresumeMediaId(resumeMediaId);
		if (candidateData.isPresent()) {
			repo.deleteByresumeMediaId(resumeMediaId);
			response.setMessage("Candidate Deleted Sucessfully");
			response.setResponseCode("0000");

		} else {
			response.setMessage(" Candidate Not Found ");
			response.setResponseCode("911");
		}

		return response;
	}

}
