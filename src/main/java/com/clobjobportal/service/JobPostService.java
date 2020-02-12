package com.clobjobportal.service;


import com.clobjobportal.exceptionController.RecordNotFoundException;
import com.clobjobportal.model.JobPost;

import java.util.List;

public interface JobPostService  {

    public void savejob(JobPost jobPost);

    public List<JobPost> getAllJobs();
    public JobPost getJobByJobId(long id) throws RecordNotFoundException;
    public JobPost createOrUpdateJobs(JobPost jobPost);
    public void deleteJobById(Long id);

}
