package com.maven.zeno.consumergroup;

public class ConsumerGroupMain {
	// https://www.cnblogs.com/qizhelongdeyang/p/7355309.html
	public static void main(String[] args) {

		String brokers = "localhost:9092";
		String groupId = "group01";
		String topic = "test";
		int consumerNumber = 3;

		Thread producerThread = new Thread(new ProducerThread(brokers, topic));
		producerThread.start();

		ConsumerGroup consumerGroup = 
				new ConsumerGroup(brokers, groupId, topic, consumerNumber);
		consumerGroup.start();
	}
}
