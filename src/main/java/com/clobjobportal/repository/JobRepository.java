package com.clobjobportal.repository;

import com.clobjobportal.model.JobDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<JobDetail,Long> {



}
