package com.pandaria.scheduler.configuration;

import org.quartz.Job;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class QuartzConfiguration {

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        // this allows to update triggers in DB when updating settings in config file:
        factoryBean.setOverwriteExistingJobs(false);
        factoryBean.setStartupDelay(10);
        factoryBean.setAutoStartup(true);
        factoryBean.setApplicationContextSchedulerContextKey("pandaria-scheduler");
        return factoryBean;
    }

    @Bean
    public Scheduler getScheduler(@Autowired SchedulerFactoryBean schedulerFactoryBean) {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        return scheduler;
    }

}
