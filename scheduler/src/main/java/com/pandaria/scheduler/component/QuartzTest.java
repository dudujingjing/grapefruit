package com.pandaria.scheduler.component;

import org.quartz.JobBuilder;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

@Service
public class QuartzTest {

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    public void test() {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        JobBuilder testJobBuilder = JobBuilder.newJob();
        testJobBuilder.storeDurably(false);
    }
}
