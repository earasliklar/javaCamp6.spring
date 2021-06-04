package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.CandidateProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateProgrammingLanguageDao extends JpaRepository<CandidateProgrammingLanguage,Integer> {
    List<CandidateProgrammingLanguage> getAllByCandidateId(int candidateId);
}