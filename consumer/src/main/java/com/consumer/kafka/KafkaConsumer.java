package com.consumer.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

import com.consumer.service.RandomDataService;
import com.consumer.util.Action;
import com.producer.ro.RandomDataRO;

@Component
public class KafkaConsumer {

	@Autowired
	private RandomDataService randomDataService;

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

	@KafkaListener(topicPartitions = { @TopicPartition(topic = "random-data-topic", partitions = "1") })
	public void consumer4Post(ConsumerRecord<String, RandomDataRO> consumerRecord) {
		try {
			if (consumerRecord != null) {
				if (consumerRecord.key().equals(Action.POST.getValue())) {
					randomDataService.saveRandomData(consumerRecord.value());
					LOGGER.info("KafkaConsumer :: Data received successfully.");
					LOGGER.debug("KafkaConsumer :: Topic : " + consumerRecord.topic() + ", Partition : "
							+ consumerRecord.partition() + ", Offset : " + consumerRecord.offset() + ", Key : "
							+ consumerRecord.key() + ".");
				} else {
					LOGGER.warn("KafkaConsumer :: Data received with wrong key.");
				}
			}
		} catch (Exception e) {
			LOGGER.error("KafkaConsumer :: Exception." + e.getMessage());
			e.printStackTrace();
		}
	}

	@KafkaListener(topicPartitions = { @TopicPartition(topic = "random-data-topic", partitions = { "0", "2" }) })
	public void consumer4GetPut(ConsumerRecord<String, RandomDataRO> consumerRecord) {
		try {
			if (consumerRecord != null) {
				// TO-DO
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
