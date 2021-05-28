package com.hrms.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.business.abstracts.CandidateService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.core.results.SuccessDataResult;
import com.hrms.core.results.SuccessResult;
import com.hrms.dataAccess.abstracts.CandidateDao;
import com.hrms.entities.concretes.Candidate;

;

@Service
public class CandidateManager implements CandidateService{

	
	private CandidateDao candidateDao;
	
	

	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	@Override
	public Result add(Candidate candidate) {
		this.candidateDao.save(candidate);
      return new SuccessResult("Aday başarıyla eklendi.");
	}
	
	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll());
	}

	@Override
	public DataResult<Candidate> getCandidateByNationalIdentity(String nationalIdentity) {
		return new SuccessDataResult<Candidate>(this.candidateDao.findCandidateByNationalIdentity(nationalIdentity));
	}

}