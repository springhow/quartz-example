package com.springhow.examples.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzApplication {
    public static void main(String[] args) throws SchedulerException, InterruptedException {

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        scheduler.start();

        JobDetail jobDetail = JobBuilder.newJob(HelloWorldJob.class)
                .withIdentity("my-first-job")
                .storeDurably(true)
                .usingJobData("who", "World")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("my-first-trigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("1/2 * * ? * * *"))
                .build();


        scheduler.scheduleJob(jobDetail, trigger);
        Thread.sleep(5000);
        scheduler.standby();
        Thread.sleep(5000);
        scheduler.start();
//        scheduler.unscheduleJob(new TriggerKey("my-first-trigger"));
//        scheduler.deleteJob(new JobKey("my-first-job"));
        Thread.sleep(5000);


        scheduler.shutdown();
    }
}
