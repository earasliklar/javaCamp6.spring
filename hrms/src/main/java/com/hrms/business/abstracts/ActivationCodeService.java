package com.hrms.business.abstracts;

import com.hrms.core.results.Result;
import com.hrms.entities.concretes.ActivationCode;

public interface ActivationCodeService {

	Result add(ActivationCode code);
}