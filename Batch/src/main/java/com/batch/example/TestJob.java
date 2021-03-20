package com.batch.example;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class TestJob extends QuartzJobBean {
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("자동실행 잡");
	}
}
