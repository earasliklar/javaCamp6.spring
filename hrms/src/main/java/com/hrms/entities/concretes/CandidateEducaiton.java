package com.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidate_education")
public class CandidateEducaiton {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "candidate_education_id")
	private int id;

	@Column(name = "school_name")
	@NotNull
	@NotBlank
	private String schoolName;
	
	@Column(name = "department_name")
	@NotNull
	@NotBlank
	private String departmentName;
	
	@Column(name = "start_year")
	@NotNull
	@NotBlank
	private int startYear;
	
	@Column(name = "gradiuation_year")
	private int gradiuationYear;
	
	@OneToMany(mappedBy = "candidateEducaiton")
	private List<Candidate> candidates;
	
}
