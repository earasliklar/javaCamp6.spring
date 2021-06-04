package com.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="candidate_links")
public class CandidateLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "link")
    private String link_address;

    @ManyToOne()
    @JsonIgnore()
    @JoinColumn(name = "link_id")
    private Candidate candidate;

    @ManyToOne()
    @JsonIgnore()
    @JoinColumn(name = "link_type_id")
    private Link link;
}