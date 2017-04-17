package com.lance.quartz.common.job;

import com.lance.quartz.common.MyApplicationContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.web.client.RestTemplate;

/**
 * 该方法仅仅用来测试每分钟执行
 * @author lance
 */
public class MinuteJob implements Job{
	Logger logger = LogManager.getLogger(getClass());

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		RestTemplate RestTemplate= (org.springframework.web.client.RestTemplate) MyApplicationContext.getBean("restTemplate");
		String myurl=context.getJobDetail().getJobDataMap().getString("url");
		logger.info("service url: {}",myurl );
		String s= RestTemplate.getForEntity(myurl, String.class).getBody();
	}
}