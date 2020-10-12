package com.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.producer.kafka.KafkaPublisher;
import com.producer.ro.RandomDataRO;
import com.producer.util.Action;

@Service
public class KafkaService {

	@Autowired
	private KafkaPublisher kafkaPublisher;

	public void checkAction(RandomDataRO randomData, Action action) {
		Integer partition = null;
		String key = null;
		switch (action) {
		case GET:
			partition = 0;
			key = Action.GET.getValue();
			break;
		case POST:
			partition = 1;
			key = Action.POST.getValue();
			break;
		case PUT:
			partition = 2;
			key = Action.PUT.getValue();
			break;
		case DELETE:
			partition = 3;
			key = Action.DELETE.getValue();
			break;
		default:

		}
		kafkaPublisher.publisher(randomData, partition, key);
	}
}
