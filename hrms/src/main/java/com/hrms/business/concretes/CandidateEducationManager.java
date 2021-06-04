package com.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.business.abstracts.CandidateEducationService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.core.results.SuccessDataResult;
import com.hrms.core.results.SuccessResult;
import com.hrms.dataAccess.abstracts.CandidateEducationDao;
import com.hrms.entities.concretes.CandidateEducaiton;

@Service
public class CandidateEducationManager implements CandidateEducationService {

	private CandidateEducationDao candidateEducationDao;
	
	
	@Autowired
	public CandidateEducationManager(CandidateEducationDao candidateEducationDao) {
		super();
		this.candidateEducationDao = candidateEducationDao;
	}

	@Override
	public Result add(CandidateEducaiton candidateEducaiton) {
		this.candidateEducationDao.save(candidateEducaiton);
		return new SuccessResult("Eklendi");
	}

	@Override
	public DataResult<List<CandidateEducaiton>> getAll() {
		
		return new SuccessDataResult<List<CandidateEducaiton>>(candidateEducationDao.findAll());
	}

	@Override
	public DataResult<List<CandidateEducaiton>> getAllByCandidateIdOrderByGraduationYear(int candidateId) {
		return  new SuccessDataResult<>(candidateEducationDao.getAllByIdOrderByGradiuationYear(candidateId));
	}
	
	

}
