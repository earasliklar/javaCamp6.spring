package com.hrms.business.abstracts;

import java.util.List;

import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.entities.abstracts.User;

public interface UserService {
	
	Result add(User user);
	
	DataResult<List<User>> getAll();
	DataResult<User> getUserByEmail(String email);

}