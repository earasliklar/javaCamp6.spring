package com.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrms.business.abstracts.ForeignLanguageService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.core.results.SuccessDataResult;
import com.hrms.core.results.SuccessResult;
import com.hrms.dataAccess.abstracts.ForeignLanguageDao;
import com.hrms.entities.concretes.ForeignLanguage;
@Service
public class ForeignLanguageManager implements ForeignLanguageService{
	
	private ForeignLanguageDao foreignLanguageDao;

	public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao) {
		super();
		this.foreignLanguageDao = foreignLanguageDao;
	}

	@Override
	public Result add(ForeignLanguage foreignLanguage) {
		this.foreignLanguageDao.save(foreignLanguage);
		return new SuccessResult("eklendi");
	}

	@Override
	public DataResult<List<ForeignLanguage>> getAll() {
		
		return new SuccessDataResult<List<ForeignLanguage>>(foreignLanguageDao.findAll());
	}
	

}
