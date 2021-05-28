package com.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;
import com.hrms.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer>{
	
	JobPosition findByJobTitle(String title);

}