package com.sample.springBatch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sample.springBatch.processor.BatchProcessor;
import com.sample.springBatch.reader.BatchReader;
import com.sample.springBatch.writter.BatchWritter;

@Configuration
public class BatchConfig {
	@Autowired
	JobBuilderFactory jobBuilderFactory;
	@Autowired
	StepBuilderFactory stepBuilderFactory;

	@Bean
	public Job job() {
		return jobBuilderFactory.get("SampleJob")
				.incrementer(new RunIdIncrementer())
				.flow(step1())
				.end()
				.build();

	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1")
				.<String,String>chunk(1)
				.reader(new BatchReader())
				.processor(new BatchProcessor())
				.writer(new BatchWritter())
				.build();

	}
}
