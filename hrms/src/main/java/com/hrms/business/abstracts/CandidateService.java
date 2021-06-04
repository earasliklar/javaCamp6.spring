package com.hrms.business.abstracts;

import java.util.List;

import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.entities.concretes.Candidate;
import com.hrms.entities.dtos.CandidateCvDto;


public interface CandidateService {

	Result add(Candidate candidate);
	DataResult<Candidate> getById(int id);
	DataResult<List<Candidate>> getAll();
	DataResult<Candidate> getCandidateByNationalIdentity(String nationalIdentity);
	DataResult<CandidateCvDto> getCvByCandidateId(int candidateId);
}