package com.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.entities.concretes.CandidateEducaiton;

public interface CandidateEducationDao extends JpaRepository<CandidateEducaiton, Integer>{
	
	List<CandidateEducaiton> getAllByIdOrderByGradiuationYear(int candidateId);

}
