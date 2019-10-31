package com.maven.zeno.kafkademo;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

public class KafkaProducerOps {
	public static void main(String[] args) throws IOException {

		Properties properties = new Properties();
		InputStream in = KafkaProducerOps.class.getClassLoader().getResourceAsStream("producer.properties");
		properties.load(in);

		String[] fruits = new String[] { "apple", "banana", "orange", "grape" };
		Producer<String, String> producer = new KafkaProducer<String, String>(properties);
		Random random = new Random();
		int start = 1;
		for (int i = start; i <= start + 9; i++) {
			String topic = properties.getProperty(Constants.KAFKA_PRODUCER_TOPIC);
			String key = i + "";
			String value = "The fruit, <--" + fruits[random.nextInt(fruits.length)] + "-->is freash~";
			ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(topic, key, value);
			producer.send(producerRecord);
		}
		producer.close();
		// String topic = properties.getProperty(Constants.KAFKA_PRODUCER_TOPIC);
		/*
		 * String key = "1"; String value = "What I eat today is:";
		 * ProducerRecord<String, String> producerRecord = new ProducerRecord<String,
		 * String>(topic, key, value); producer.send(producerRecord); producer.close();
		 */
	}

}
