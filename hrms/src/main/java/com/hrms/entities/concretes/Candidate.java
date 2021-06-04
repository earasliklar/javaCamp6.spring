package com.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name="candidates")

public class Candidate extends User{
	
	@Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="national_identity")
    private String nationalIdentity;

    @Column(name="date_of_birth",columnDefinition = "DATE")
    private Date dateOfBirth;
    
    @ManyToOne()
    @JoinColumn(name = "candidate_education_id")
    private CandidateEducaiton candidateEducaiton;
    
    @OneToMany(mappedBy = "candidate")
    	
    private List<CandidateExperience> candidateExperiences;
    
    @OneToMany(mappedBy = "candidate")
    private List<CandidateForeignLanguage> candidateForeignLanguages;
  
    @OneToMany(mappedBy = "candidate")
    private List<CandidateProgrammingLanguage> candidateProgrammingLanguages;
    
    @OneToMany(mappedBy = "candidate")
    private List<CandidateLink> candidateLinks;

    @OneToMany(mappedBy = "candidate")
    private List<CandidateImage> candidateImages;

	
}