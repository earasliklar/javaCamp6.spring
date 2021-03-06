package com.hrms.business.abstracts;

import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.entities.concretes.CandidateExperience;
import java.util.List;
public interface CandidateExperienceService {
	 Result add(CandidateExperience candidateExperience);
	    DataResult<List<CandidateExperience>> getAll();
	    DataResult<List<CandidateExperience>> getAllByCandidateIdOrderByLeaveDateDesc(int candidateId);

}
