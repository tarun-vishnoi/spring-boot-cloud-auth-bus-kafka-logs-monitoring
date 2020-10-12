package com.producer.serialization;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

public class ObjectSerializer implements Serializer<Object> {

	@Override
	public byte[] serialize(String topic, Object data) {
		try {
			ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
			ObjectOutputStream objectStream = new ObjectOutputStream(byteStream);
			objectStream.writeObject(data);
			objectStream.flush();
			objectStream.close();
			return byteStream.toByteArray();
		} catch (IOException e) {
			throw new IllegalStateException("Can't serialize object: " + data, e);
		}
	}

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		// TODO Auto-generated method stub

	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

}
