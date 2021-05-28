package com.hrms.business.concretes;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.business.abstracts.ActivationCodeService;
import com.hrms.core.results.Result;
import com.hrms.core.results.SuccessResult;
import com.hrms.dataAccess.abstracts.ActivationCodeDao;
import com.hrms.entities.concretes.ActivationCode;



@Service
public class ActivationCodeManager implements ActivationCodeService{
	
private ActivationCodeDao verificationCodeDao;
	
	@Autowired
	public ActivationCodeManager(ActivationCodeDao activationCodeDao, ActivationCodeDao verificationCodeDao) {
		super();
		this.verificationCodeDao = verificationCodeDao;
	}

	@Override
	public Result add(ActivationCode code) {
		this.verificationCodeDao.save(code);
		return new SuccessResult("Kod kaydedildi.");
	}

}