package com.producer.ro;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.validation.constraints.NotNull;

public class RandomDataRO implements Serializable {

	@NotNull(message = "Id can not be null.")
	private Integer id;
	private UUID uuid;
	@NotNull(message = "Name can not be null.")
	private String name;
	@NotNull(message = "gender can not be null.")
	private String gender;
	private Integer age;
	private Float salary;
	private Date birthdate;

	public RandomDataRO() {
	}

	public RandomDataRO(Integer id, String name, String gender, Integer age, Float salary, Date birthdate) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.salary = salary;
		this.birthdate = birthdate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

}
