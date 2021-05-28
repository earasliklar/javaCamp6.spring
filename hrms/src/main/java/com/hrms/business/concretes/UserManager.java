package com.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.business.abstracts.UserService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.core.results.SuccessDataResult;
import com.hrms.core.results.SuccessResult;
import com.hrms.dataAccess.abstracts.UserDao;
import com.hrms.entities.abstracts.User;

@Service
public class UserManager implements UserService{

	private UserDao userDao;
	

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}


	@Override
	public Result add(User user) {
		this.userDao.save(user);
	    return new SuccessResult("Kullanıcı başarıyla eklendi.");
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll());
	}

	@Override
	public DataResult<User> getUserByEmail(String email) {

		return new SuccessDataResult<User>(this.userDao.findUserByEmail(email));
	}

}