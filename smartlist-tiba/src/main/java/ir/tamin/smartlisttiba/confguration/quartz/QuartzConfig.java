package ir.tamin.smartlisttiba.confguration.quartz;

import ir.tamin.smartlisttiba.service.JMSMessageSender;
import ir.tamin.smartlisttiba.service.JMSMessageSenderImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class QuartzConfig {

    private final ApplicationContext context;
    private final DataSource dataSource;

    public QuartzConfig(DataSource dataSource, ApplicationContext context) {
        this.dataSource = dataSource;
        this.context = context;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() throws IOException {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        SpringBeanJobFactory jobFactory = new SpringBeanJobFactory();
        jobFactory.setApplicationContext(context);
        factory.setJobFactory(jobFactory);
        factory.setDataSource(dataSource);
        return factory;
    }

    @Bean
    @Scope(value = "prototype", proxyMode = ScopedProxyMode.INTERFACES)
    public JobDetailFactoryBean getJobDetailFactoryBeanForJmsMessageSender() {
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(JMSMessageSenderImpl.class);
        factoryBean.setApplicationContext(context);
        factoryBean.setDescription("Invoke Sample Job service...");
        factoryBean.setDurability(true);
        return factoryBean;
    }
}
