package com.sample.springBatch.writter;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class BatchWritter implements ItemWriter<String>{

	@Override
	public void write(List<? extends String> items) throws Exception {
		for(String s: items){
			System.out.println("Value::::"+s);
		}
		
	}

}
