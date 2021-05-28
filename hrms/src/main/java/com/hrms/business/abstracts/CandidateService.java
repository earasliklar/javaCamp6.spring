package com.hrms.business.abstracts;

import java.util.List;

import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.entities.concretes.Candidate;


public interface CandidateService {

	Result add(Candidate candidate);
	
	DataResult<List<Candidate>> getAll();
	DataResult<Candidate> getCandidateByNationalIdentity(String nationalIdentity);
}