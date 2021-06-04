package com.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrms.business.abstracts.CandidateForeignLanguageService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.core.results.SuccessDataResult;
import com.hrms.core.results.SuccessResult;
import com.hrms.dataAccess.abstracts.CandidateForeignLanguageDao;
import com.hrms.entities.concretes.CandidateForeignLanguage;

@Service
public class CandidateForeignLanguageManager implements CandidateForeignLanguageService {

	private CandidateForeignLanguageDao candidateForeignLanguageDao;
	
	
	public CandidateForeignLanguageManager(CandidateForeignLanguageDao candidateForeignLanguageDao) {
		super();
		this.candidateForeignLanguageDao = candidateForeignLanguageDao;
	}

	@Override
	public Result add(CandidateForeignLanguage candidatForeignLanguage) {
		this.candidateForeignLanguageDao.save(candidatForeignLanguage);
		return new SuccessResult("eklendi");
	}

	@Override
	public DataResult<List<CandidateForeignLanguage>> getAll() {
		return new SuccessDataResult<>(candidateForeignLanguageDao.findAll());
	}

	@Override
	public DataResult<List<CandidateForeignLanguage>> getAllByCandidateId(int candidateId) {
	
		return new SuccessDataResult<List<CandidateForeignLanguage>>(candidateForeignLanguageDao.getAllByCandidateId(candidateId));
	}

}
