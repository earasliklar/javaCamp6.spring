package com.hrms.business.abstracts;

import com.hrms.core.results.*;
import com.hrms.entities.concretes.CandidateProgrammingLanguage;

import java.util.List;
public interface CandidateProgrammingLanguageService {
	  Result add(CandidateProgrammingLanguage candidateProgrammingLanguage);
	    DataResult<List<CandidateProgrammingLanguage>> getAll();
	    DataResult<List<CandidateProgrammingLanguage>> getAllByCandidateId(int candidateId);

}
