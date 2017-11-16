package com.aisino.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

	@Scheduled(fixedRate=1000)
	public void testScheduled(){
		System.out.println("hello "+ System.currentTimeMillis());
	}
}
