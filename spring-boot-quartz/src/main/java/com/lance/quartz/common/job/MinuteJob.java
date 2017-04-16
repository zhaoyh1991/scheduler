package com.lance.quartz.common.job;

import com.alibaba.fastjson.JSONObject;
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
		logger.info("JobName: {}", context.getJobDetail().getKey().getName());
		RestTemplate RestTemplate= (org.springframework.web.client.RestTemplate) MyApplicationContext.getBean("restTemplate");
		String url="http://gc.ditu.aliyun.com/geocoding?a=苏州市";
		String s= RestTemplate.getForEntity(url, String.class).getBody();
		System.out.println(s);
	}
}