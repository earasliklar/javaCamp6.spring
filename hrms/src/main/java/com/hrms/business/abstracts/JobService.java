package com.hrms.business.abstracts;

import java.util.List;

import com.hrms.entities.concretes.Job;

public interface JobService {
	List<Job> getAll();
}
