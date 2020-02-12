package com.clobjobportal.controller;


import com.clobjobportal.exceptionController.RecordNotFoundException;
import com.clobjobportal.model.JobPost;
import com.clobjobportal.repository.JobPostRepository;
import com.clobjobportal.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class JobController {


    @Autowired
    private JobPostService jobPostService;

    @RequestMapping(value= {"/postjob"}, method= RequestMethod.GET)
    public ModelAndView postjob() {
        ModelAndView model = new ModelAndView();
        JobPost jobPost = new JobPost();
        model.addObject("JobPost", jobPost);
        model.setViewName("/postjob");

        return model;
    }

    @RequestMapping(value= {"/jobpost"}, method=RequestMethod.POST)
    public ModelAndView postjob(@Valid JobPost jobPost, BindingResult bindingResult) {
        ModelAndView model = new ModelAndView();
        jobPostService.savejob(jobPost);
        model.addObject("msg", "Job Is Created successfully!");
        model.addObject("jobPost", new JobPost());
        model.setViewName("/postjob");
        return model;
    }

    @Autowired
    JobPostRepository jobPostRepository;
    @RequestMapping(value = {"/listjob"}, method= RequestMethod.GET)
    public String showJobs(Model model) {
        model.addAttribute("listjobs", jobPostRepository.findAll().stream().sorted(Comparator.comparing(JobPost::getJobtitle)).collect(Collectors.toList()));
        return "listjob";
    }






    @RequestMapping(value = {"/editjob"}, method= RequestMethod.GET)
    public String getAlljobs(Model model)
    {
        List<JobPost> list = jobPostService.getAllJobs();

        model.addAttribute("listjobs", list);
        return "editjob";
    }

    @RequestMapping(path = {"/editjobs", "/edit/{id}"})
    public String editjobById(Model model, @PathVariable("id") Optional<Long> id)
            throws RecordNotFoundException
    {
        if (id.isPresent()) {
            JobPost jobPost = jobPostService.getJobByJobId(id.get());
            model.addAttribute("jobpost", jobPost);
        } else {
            model.addAttribute("jobpost", new JobPost());
        }
        return "postjob";
    }

    @RequestMapping(path = "/delete/{id}")
    public String deleteEmployeeById(Model model, @PathVariable("id") Long id)
            throws RecordNotFoundException
    {
        jobPostService.deleteJobById(id);
        return "redirect:/";
    }

    @RequestMapping(path = "/Jobpost", method = RequestMethod.POST)
    public String createOrUpdateEmployee(JobPost jobPost)
    {
        jobPostService.createOrUpdateJobs(jobPost);
        return "redirect:/";
    }




}
