package com.consumer.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.consumer.service.RandomDataService;
import com.consumer.util.Action;
import com.producer.ro.RandomDataRO;

@Component
public class KafkaConsumer {

	@Autowired
	private RandomDataService randomDataService;

	@KafkaListener(topics = "random-data-topic")
	public void consumer(ConsumerRecord<String, RandomDataRO> consumerRecord) {
		if (consumerRecord != null) {
			if (consumerRecord.key().equals(Action.POST.getValue())) {
				randomDataService.saveRandomData(consumerRecord.value());
			} else {
				System.out.println("TO=============DO");
			}
		}
	}
}
