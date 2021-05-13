package com.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.entities.concretes.Job;

public interface JobDao extends JpaRepository<Job, Integer> {

}
