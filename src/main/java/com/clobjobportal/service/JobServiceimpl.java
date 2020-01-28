package com.clobjobportal.service;

import com.clobjobportal.model.JobDetail;
import com.clobjobportal.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobServiceimpl implements JobService {

    @Autowired
    JobRepository jobRepository;

    @Override
    public void save(JobDetail jobDetail) {
        System.out.println("saving job details");
        jobRepository.save(jobDetail);
    }
}
