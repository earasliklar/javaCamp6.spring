package com.hrms.business.abstracts;

import java.util.List;

import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.entities.concretes.CandidateEducaiton;

public interface CandidateEducationService {
	Result add(CandidateEducaiton candidateEducaiton);
	DataResult<List<CandidateEducaiton>> getAll();
	DataResult<List<CandidateEducaiton>> getAllByCandidateIdOrderByGraduationYear(int candidateId);

}
