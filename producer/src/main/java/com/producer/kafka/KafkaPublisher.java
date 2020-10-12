package com.producer.kafka;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.producer.ro.RandomDataRO;

@Component
public class KafkaPublisher {

	@Autowired
	private KafkaTemplate<String, RandomDataRO> kafkaTemplate;

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaPublisher.class);

	/**
	 * 
	 * topic will have four partition and will be assigned as below :
	 * 
	 * 0 - Get, 1 - Post, 2 - Put, 3 - Delete.
	 */

	public void publisher(RandomDataRO randomData, Integer partition, String key) {
		ListenableFuture<SendResult<String, RandomDataRO>> listenableFuture = kafkaTemplate
				.send(new ProducerRecord<String, RandomDataRO>("random-data-topic", partition, key, randomData));
		listenableFuture.addCallback(new ListenableFutureCallback<SendResult<String, RandomDataRO>>() {

			@Override
			public void onSuccess(SendResult<String, RandomDataRO> result) {
				LOGGER.info("KafkaPublisher :: Data sent successfully.");
				LOGGER.debug("KafkaPublisher :: Topic : " + result.getRecordMetadata().topic() + ", Partition : "
						+ result.getRecordMetadata().partition() + ", Offset : " + result.getRecordMetadata().offset()
						+ ".");
			}

			@Override
			public void onFailure(Throwable ex) {
				LOGGER.error("KafkaPublisher :: Error : " + ex);
			}
		});
	}
}
