package com.producer.util;

public enum Action {

	GET("GET"), POST("POST"), PUT("PUT"), DELETE("DELETE");

	private String value;

	private Action(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
