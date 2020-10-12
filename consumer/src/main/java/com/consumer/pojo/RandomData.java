package com.consumer.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "random_data")
public class RandomData implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "random_data_generator")
	@SequenceGenerator(name = "random_data_generator", sequenceName = "random_data_id_seq", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;
	@Column(name = "uuid")
	private UUID uuid;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "gender", nullable = false)
	private String gender;
	@Column(name = "age")
	private Integer age;
	@Column(name = "salary")
	private Float salary;
	@Column(name = "birthdate")
	private Date birthdate;

	public RandomData() {
	}

	public RandomData(Integer id, String name, String gender, Integer age, Float salary, Date birthdate) {
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
