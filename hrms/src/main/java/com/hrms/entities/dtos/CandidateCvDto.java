package com.hrms.entities.dtos;

import com.hrms.entities.concretes.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateCvDto {
    private Candidate candidate;
    private List<CandidateEducaiton> candidateEducaitons;
    private List<CandidateExperience> candidateExperiences;
    private List<CandidateImage> candidateImages;
    private List<CandidateForeignLanguage> candidateForeignLanguages;
    private List<CandidateLink> candidateLinks;
    private List<CandidateProgrammingLanguage> candidateProgrammingLanguages;
}