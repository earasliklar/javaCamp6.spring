package com.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrms.business.abstracts.CandidateProgrammingLanguageService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.core.results.SuccessDataResult;
import com.hrms.core.results.SuccessResult;
import com.hrms.dataAccess.abstracts.CandidateProgrammingLanguageDao;
import com.hrms.entities.concretes.CandidateProgrammingLanguage;
@Service
public class CandidateProgrammingLanguageManager implements CandidateProgrammingLanguageService{

	private CandidateProgrammingLanguageDao candidateProgrammingLanguageDao;

	public CandidateProgrammingLanguageManager(CandidateProgrammingLanguageDao candidateProgrammingLanguageDao) {
		this.candidateProgrammingLanguageDao = candidateProgrammingLanguageDao;
	}

	@Override
	public Result add(CandidateProgrammingLanguage candidateProgrammingLanguage) {
		this.candidateProgrammingLanguageDao.save(candidateProgrammingLanguage);
		return new SuccessResult("eklendi");
	}

	@Override
	public DataResult<List<CandidateProgrammingLanguage>> getAll() {
		return new SuccessDataResult<List<CandidateProgrammingLanguage>>(candidateProgrammingLanguageDao.findAll());
	}

	@Override
	public DataResult<List<CandidateProgrammingLanguage>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<List<CandidateProgrammingLanguage>>(candidateProgrammingLanguageDao.getAllByCandidateId(candidateId));
	}
	
	
}
