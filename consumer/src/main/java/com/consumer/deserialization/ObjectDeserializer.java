package com.consumer.deserialization;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

public class ObjectDeserializer implements Deserializer<Object> {

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object deserialize(String topic, byte[] data) {
		try {
			ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(data));
			Object object = inputStream.readObject();
			return object;
		} catch (IOException | ClassNotFoundException e) {
			throw new IllegalStateException("Can't deserialize object: " + data, e);
		}
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

}
