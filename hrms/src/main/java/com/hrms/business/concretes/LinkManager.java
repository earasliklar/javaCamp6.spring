package com.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrms.business.abstracts.LinkService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.core.results.SuccessDataResult;
import com.hrms.core.results.SuccessResult;
import com.hrms.dataAccess.abstracts.LinkDao;
import com.hrms.entities.concretes.Link;
@Service
public class LinkManager implements LinkService{

	private LinkDao linkDao;

	public LinkManager(LinkDao linkDao) {
		super();
		this.linkDao = linkDao;
	}

	@Override
	public Result add(Link link) {
		this.linkDao.save(link);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<Link>> getAll() {
		return new SuccessDataResult<List<Link>>(linkDao.findAll());
	}
	
	
}
