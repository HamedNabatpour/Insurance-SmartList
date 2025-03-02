package ir.tamin.smartlisttiba.service;

import org.quartz.InterruptableJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.UnableToInterruptJobException;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class JMSMessageSenderImpl extends QuartzJobBean implements JMSMessageSender, InterruptableJob, ApplicationContextAware  {

    @Override
    public void interrupt() throws UnableToInterruptJobException {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

    }
}
