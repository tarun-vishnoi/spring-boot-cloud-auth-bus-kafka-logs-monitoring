package com.consumer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import com.consumer.deserialization.ObjectDeserializer;
import com.producer.ro.RandomDataRO;

@Configuration
@EnableKafka
public class KafkaConfig {

	@Bean
	public ConsumerFactory<String, RandomDataRO> consumerFactory() {
		Map<String, Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ObjectDeserializer.class);
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "random-data-group");
		config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);

		return new DefaultKafkaConsumerFactory<>(config);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, RandomDataRO> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, RandomDataRO> factory = new ConcurrentKafkaListenerContainerFactory<String, RandomDataRO>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

}
