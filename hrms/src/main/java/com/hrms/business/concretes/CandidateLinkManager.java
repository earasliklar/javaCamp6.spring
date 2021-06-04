package com.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.business.abstracts.CandidateLinkService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.core.results.SuccessDataResult;
import com.hrms.core.results.SuccessResult;
import com.hrms.dataAccess.abstracts.CandidateLinkDao;
import com.hrms.entities.concretes.CandidateLink;
@Service
public class CandidateLinkManager implements CandidateLinkService {
	
	private CandidateLinkDao candidateLinkDao;
	
	@Autowired
	public CandidateLinkManager(CandidateLinkDao candidateLinkDao) {
		super();
		this.candidateLinkDao = candidateLinkDao;
	}

	@Override
	public Result add(CandidateLink candidateLink) {
		this.candidateLinkDao.save(candidateLink);
		return new SuccessResult("eklendi");
	}

	@Override
	public DataResult<List<CandidateLink>> getAll() {
		return new SuccessDataResult<List<CandidateLink>>(candidateLinkDao.findAll());
	}

	@Override
	public DataResult<List<CandidateLink>> getAllByCandidateId(int candidateId) {
		
		return new SuccessDataResult<List<CandidateLink>>(candidateLinkDao.getAllByCandidateId(candidateId));
	}

}
