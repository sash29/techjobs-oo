package org.launchcode.controllers;

import org.launchcode.models.Job;
import org.launchcode.models.forms.JobForm;
import org.launchcode.models.data.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping(value = "job")
public class JobController {

    private JobData jobData = JobData.getInstance();

    // The detail display for a given Job at URLs like /job?id=17
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, int id) {

        // TODO #1 - get the Job with the given ID and pass it into the view
         System.out.println("in index handler, id : " + id );
         Job job =jobData.findById(id);
         System.out.println(job.getName());
         model.addAttribute(job);
        return "job-detail";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new JobForm());
        return "new-job";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @Valid JobForm jobForm, Errors errors) {


        // TODO #6 - Validate the JobForm model, and if valid, create a
        // new Job and add it to the jobData data store. Then
        // redirect to the job detail view for the new Job.
        System.out.println(jobForm.getName());
        if (jobForm.getName().isEmpty()){
            model.addAttribute("errorMsg","Name may not be empty");

            return "new-job";
        }else{
            Job newjob = new Job();
            newjob.setName(jobForm.getName());
            newjob.setEmployer(jobData.getEmployers().findById(jobForm.getEmployerId()));
            newjob.setLocation(jobData.getLocations().findById(jobForm.getLocationId()));
            newjob.setCoreCompetency(jobData.getCoreCompetencies().findById(jobForm.getcoreCompetencyId()));
            newjob.setPositionType((jobData.getPositionTypes().findById(jobForm.getpositionTypeId())));

            jobData.add(newjob);
            model.addAttribute(newjob);
            System.out.println("added new job");
            return "job-detail";
        }
    }
}
