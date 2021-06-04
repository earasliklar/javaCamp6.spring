package com.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.entities.concretes.Link;

public interface LinkDao extends JpaRepository<Link, Integer>{

}
