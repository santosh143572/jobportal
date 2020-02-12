package com.clobjobportal.service;


import com.clobjobportal.exceptionController.RecordNotFoundException;
import com.clobjobportal.model.JobPost;
import com.clobjobportal.repository.JobPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class JobPostServiceImpl  implements JobPostService {

        @Autowired
        private JobPostRepository jobPostRepository;

        @Override
        public void savejob(JobPost jobPost) {
                jobPostRepository.save(jobPost);

        }


        @Override
        public List<JobPost> getAllJobs()
        {
                List<JobPost> result = (List<JobPost>) jobPostRepository.findAll();

                if(result.size() > 0) {
                        return result;
                } else {
                        return new ArrayList<JobPost>();
                }
        }


        @Override
        public JobPost getJobByJobId(long id) throws RecordNotFoundException
        {
                Optional<JobPost> jobPost = jobPostRepository.findById(id);

                if(jobPost.isPresent()) {
                        return jobPost.get();
                } else {
                        throw new RecordNotFoundException("No Jobs record exist for given id");
                }
        }



        @Override
        public JobPost createOrUpdateJobs(JobPost jobPost)
        {
                        Optional<JobPost> jobPostOptional = jobPostRepository.findById(jobPost.getJobid());

                        if(jobPostOptional.isPresent())
                        {
                                JobPost newjob = jobPostOptional.get();
                                newjob.setJobid(jobPost.getJobid());
                                newjob.setJobtitle(jobPost.getJobtitle());
                                newjob.setDescription(jobPost.getDescription());

                                newjob = jobPostRepository.save(newjob);

                                return newjob;
                        } else {
                                jobPost = jobPostRepository.save(jobPost);

                                return jobPost;
                        }

        }

        @Override
        public void deleteJobById(Long id) throws RecordNotFoundException
        {
                Optional<JobPost> jobPostOptional = jobPostRepository.findById(id);

                if(jobPostOptional.isPresent())
                {
                        //JobPostRepository.deleteById(id);
                }
                else {
                        throw new RecordNotFoundException("No jobs record exist for given id");
                }
        }









}
