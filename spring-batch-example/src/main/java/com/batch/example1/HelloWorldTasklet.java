package com.batch.example1;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class HelloWorldTasklet implements Tasklet {


	public RepeatStatus execute(final StepContribution contribution, final ChunkContext chunkContext) throws Exception {
		
		System.out.println("처리시작");
		
		
		System.out.println("처리끝");
		
		return null;
		
	}

}
