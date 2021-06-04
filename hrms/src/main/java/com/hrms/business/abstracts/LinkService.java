package com.hrms.business.abstracts;

import java.util.List;

import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.entities.concretes.Link;

public interface LinkService {
	Result add(Link link);
	DataResult<List<Link>> getAll();

}
