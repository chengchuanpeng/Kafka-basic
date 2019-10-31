package com.maven.zeno.consumerthread;

import com.maven.zeno.consumergroup.ConsumerGroup;
import com.maven.zeno.consumergroup.ProducerThread;

public class ConsumerThreadMain {

	public static void main(String[] args) {
		
		String brokers = "localhost:9092";
		String groupId = "group01";
		String topic = "test";
		int consumerNumber = 3;

		Thread producerThread = new Thread(new ProducerThread(brokers, topic));
		producerThread.start();

		ConsumerThread consumerThread = new ConsumerThread(brokers, groupId, topic);
        consumerThread.start(3);
	}

}
