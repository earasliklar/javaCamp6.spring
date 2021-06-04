package com.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.business.abstracts.CandidateExperienceService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.core.results.SuccessDataResult;
import com.hrms.core.results.SuccessResult;
import com.hrms.dataAccess.abstracts.CandidateExperienceDao;
import com.hrms.entities.concretes.CandidateExperience;

@Service
public class CandidateExperienceManager implements CandidateExperienceService {
	 private CandidateExperienceDao candidateExperienceDao;
	 @Autowired
	public CandidateExperienceManager(CandidateExperienceDao candidateExperienceDao) {
		super();
		this.candidateExperienceDao = candidateExperienceDao;
	}

	@Override
	public Result add(CandidateExperience candidateExperience) {
		this.candidateExperienceDao.save(candidateExperience);
		return  new SuccessResult("eklendi");
	}

	@Override
	public DataResult<List<CandidateExperience>> getAll() {
		return new SuccessDataResult<>(this.candidateExperienceDao.findAll());
		
	}

	@Override
	public DataResult<List<CandidateExperience>> getAllByCandidateIdOrderByLeaveDateDesc(int candidateId) {
		return new SuccessDataResult<>(this.candidateExperienceDao.getAllByCandidateIdOrderByLeaveDateDesc(candidateId));
	}
	

}
