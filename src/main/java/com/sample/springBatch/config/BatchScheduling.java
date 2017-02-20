package com.sample.springBatch.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BatchScheduling {
	
	@Scheduled(cron="0 0/5 * ? * *")
	public void scheduleJob(){
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getForEntity("http://localhost:8076/launchScheduleJob", String.class);
	}

}
