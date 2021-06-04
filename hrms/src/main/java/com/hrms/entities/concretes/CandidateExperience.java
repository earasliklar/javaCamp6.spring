package com.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidate_experince")
public class CandidateExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "workplace_name")
	@NotBlank
	@NotNull
	private String workplaceName;
	
	@Column(name = "position")
	@NotBlank
	@NotNull
	private String position;
	
	@Column(name = "start_date")
	@NotNull
	@NotBlank
	private int startDate;
	
	@Column(name = "end_date")
	private int leaveDate;
	
	@ManyToOne
	@JsonIgnore()
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;

}
