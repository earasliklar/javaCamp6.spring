  
package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.CandidateForeignLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateForeignLanguageDao extends JpaRepository<CandidateForeignLanguage,Integer> {
    List<CandidateForeignLanguage> getAllByCandidateId(int candidateId);
}