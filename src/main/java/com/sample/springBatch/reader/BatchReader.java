package com.sample.springBatch.reader;

import org.springframework.batch.item.ItemReader;

public class BatchReader implements ItemReader<String> {
	int count=0;
    String [] messages = {"Hi","hello","nandini"};
	@Override
	public String read() throws Exception {
		  if(count<messages.length){
			  return messages[count++];
		  }else{
			  count=0;
		  }
		  return null;
	}
	

}
