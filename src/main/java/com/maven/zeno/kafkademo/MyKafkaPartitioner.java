package com.maven.zeno.kafkademo;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;
import java.util.Random;

public class MyKafkaPartitioner implements Partitioner {
    public void configure(Map<String, ?> configs) {

    }

    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        //Integer partitionNums = cluster.partitionCountForTopic(topic);
    	int partitionNums = 3;
        // System.out.println("PNUM:"+partitionNums);
        int targetPartition = -1;
        if (key == null || keyBytes == null) {
            targetPartition = new Random().nextInt(10000) % partitionNums;
        } else {
            int hashCode = key.hashCode();
            targetPartition = hashCode % partitionNums;
            System.out.println("key: " + key + ", value: " + value + ", hashCode: " + hashCode + ", partition: " + targetPartition);
        }
        return targetPartition;
    }

    public void close() {
    }
}