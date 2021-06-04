package com.hrms.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.business.abstracts.CandidateEducationService;
import com.hrms.business.abstracts.CandidateExperienceService;
import com.hrms.business.abstracts.CandidateForeignLanguageService;
import com.hrms.business.abstracts.CandidateImageService;
import com.hrms.business.abstracts.CandidateLinkService;
import com.hrms.business.abstracts.CandidateProgrammingLanguageService;
import com.hrms.business.abstracts.CandidateService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.core.results.SuccessDataResult;
import com.hrms.core.results.SuccessResult;
import com.hrms.dataAccess.abstracts.CandidateDao;
import com.hrms.entities.concretes.Candidate;
import com.hrms.entities.dtos.CandidateCvDto;


@Service
public class CandidateManager implements CandidateService{

	
	private CandidateDao candidateDao;
	private CandidateEducationService candidateEducationService;
	private CandidateExperienceService candidateExperienceService;
	private CandidateForeignLanguageService candidateForeignLanguageService;
	private CandidateImageService candidateImageService;
	private CandidateProgrammingLanguageService CandidateProgrammingLanguageService;
	private CandidateLinkService CandidateLinkService;
	
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, CandidateEducationService candidateEducationService,
			CandidateExperienceService candidateExperienceService,
			CandidateForeignLanguageService candidateForeignLanguageService,
			CandidateImageService candidateImageService,
			CandidateProgrammingLanguageService candidateProgrammingLanguageService,
			CandidateLinkService candidateLinkService) {
		this.candidateDao = candidateDao;
		this.candidateEducationService = candidateEducationService;
		this.candidateExperienceService = candidateExperienceService;
		this.candidateForeignLanguageService = candidateForeignLanguageService;
		this.candidateImageService = candidateImageService;
		CandidateProgrammingLanguageService = candidateProgrammingLanguageService;
		CandidateLinkService = candidateLinkService;
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

	@Override
	   public DataResult<Candidate> getById(int id) {
        return new SuccessDataResult<>(this.candidateDao.findById(id).get());
    }
	

	@Override
	public DataResult<CandidateCvDto> getCvByCandidateId(int candidateId) {
		CandidateCvDto candidateCvDto = new CandidateCvDto();
		candidateCvDto.setCandidate(this.getById(candidateId).getData());
		candidateCvDto.setCandidateEducaitons(this.candidateEducationService.getAllByCandidateIdOrderByGraduationYear(candidateId).getData());
		candidateCvDto.setCandidateExperiences(this.candidateExperienceService.getAllByCandidateIdOrderByLeaveDateDesc(candidateId).getData());
		candidateCvDto.setCandidateImages(this.candidateImageService.getAllByCandidateId(candidateId).getData());
		candidateCvDto.setCandidateForeignLanguages(this.candidateForeignLanguageService.getAllByCandidateId(candidateId).getData());
		candidateCvDto.setCandidateLinks(this.CandidateLinkService.getAllByCandidateId(candidateId).getData());
		candidateCvDto.setCandidateProgrammingLanguages(this.CandidateProgrammingLanguageService.getAllByCandidateId(candidateId).getData());
		return new SuccessDataResult<>(candidateCvDto);
	}

}