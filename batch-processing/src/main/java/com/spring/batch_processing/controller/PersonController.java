package com.spring.batch_processing.controller;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/person/")
public class PersonController {

    @Autowired
    private Job job;

    @Autowired
    private JobLauncher jobLauncher;

    @PostMapping("/importData")
    public String importData(){

      final JobParameters parameter = new JobParametersBuilder()
                .addLong("startAt",System.currentTimeMillis()).toJobParameters();

      try{
          final JobExecution jobExecution = jobLauncher.run(job,parameter);
          return jobExecution.getStatus().toString();
      } catch (JobInstanceAlreadyCompleteException | JobRestartException | JobParametersInvalidException |
               JobExecutionAlreadyRunningException e)
      {
          throw new RuntimeException(e);
      }
    }
}
