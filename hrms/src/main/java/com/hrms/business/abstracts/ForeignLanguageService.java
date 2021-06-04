package com.hrms.business.abstracts;

import java.util.List;

import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.entities.concretes.ForeignLanguage;

public interface ForeignLanguageService {
	Result add (ForeignLanguage foreignLanguage);
	DataResult<List<ForeignLanguage>> getAll();

}
