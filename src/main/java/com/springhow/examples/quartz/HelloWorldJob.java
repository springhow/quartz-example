package com.springhow.examples.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorldJob implements Job {
    private static final Logger logger = LoggerFactory.getLogger(HelloWorldJob.class);

    @Override
    public void execute(JobExecutionContext context) {
        String who = context.getJobDetail().getJobDataMap().getString("who");
        logger.info("Hello {}!", who);
    }
}
