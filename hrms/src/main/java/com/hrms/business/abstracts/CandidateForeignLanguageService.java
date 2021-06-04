package com.hrms.business.abstracts;

import com.hrms.core.results.*;
import com.hrms.entities.concretes.CandidateForeignLanguage;
import java.util.List;

public interface CandidateForeignLanguageService {
	 Result add(CandidateForeignLanguage candidatForeignLanguage);
	    DataResult<List<CandidateForeignLanguage>> getAll();
	    DataResult<List<CandidateForeignLanguage>> getAllByCandidateId(int candidateId);

}
