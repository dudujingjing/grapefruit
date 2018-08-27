package com.pandaria.scheduler.configuration;

import org.quartz.Job;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class QuartzConfiguration {

    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        // this allows to update triggers in DB when updating settings in config file:
        factoryBean.setOverwriteExistingJobs(true);
        factoryBean.setStartupDelay(10);
        factoryBean.setAutoStartup(true);
        factoryBean.setApplicationContextSchedulerContextKey("pandaria-scheduler");
        return factoryBean;
    }

    public JobDetailFactoryBean getJobDetailFactoryBean(Class<? extends Job> clazz, String groupName, String targetObject) {
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(clazz);
        jobDetailFactoryBean.setDurability(true);
        jobDetailFactoryBean.setRequestsRecovery(true);
        jobDetailFactoryBean.setGroup(groupName);
        Map<String, String> jobDataMap = new HashMap<String, String>();
        jobDataMap.put("targetObject", targetObject);
        jobDataMap.put("targetMethod", "execute");
        jobDetailFactoryBean.setJobDataAsMap(jobDataMap);
        return jobDetailFactoryBean;
    }
}
