package com.clobjobportal.controller;

import com.clobjobportal.model.JobDetail;
import com.clobjobportal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class JobController {
@Autowired
    JobService jobService;

@RequestMapping(value = "/job/post",consumes = "application/json")
public @ResponseBody String save(JobDetail jobDetail){

    jobService.save(jobDetail);

    return "200 ok : job saved sucessfully";
}


}
