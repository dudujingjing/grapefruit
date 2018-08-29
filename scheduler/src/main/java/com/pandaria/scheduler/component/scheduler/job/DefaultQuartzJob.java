package com.pandaria.scheduler.component.scheduler.job;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DefaultQuartzJob extends QuartzJobBean implements MethodInvokingJob {

    private Log logger = LogFactory.getLog(getClass());

    public static final String EXECUTE_METHOD = "startTask";

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        Date fireTime = context.getFireTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String jobKeyName = context.getJobDetail().getKey().getName();
        logger.info(String.format("Job: %s trigger fired at %s", jobKeyName, sdf.format(fireTime)));
        startTask();
    }

    @Override
    public void startTask() {

        System.out.println("Start to counting...");
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " ,");
        }
    }
}
