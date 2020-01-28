package com.clobjobportal.controller;

import com.clobjobportal.model.JobDetail;
import com.clobjobportal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

@RequestMapping(value = "/job/post")
@CrossOrigin(origins = "*")
public class JobController {
@Autowired
    JobService jobService;

@PostMapping
public @ResponseBody String save(@RequestBody JobDetail jobDetail){

    System.out.println(jobDetail.getTitle());
    if(jobDetail !=null)
    jobService.save(jobDetail);
    System.out.println(jobDetail.getTitle());
    return "200 ok : job saved sucessfully";
}


}
