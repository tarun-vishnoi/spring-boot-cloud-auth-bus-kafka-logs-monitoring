package com.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consumer.pojo.RandomData;
import com.consumer.repo.RandomDataRepo;
import com.producer.ro.RandomDataRO;

@Service
public class RandomDataService {

	@Autowired
	private RandomDataRepo randomDataRepo;

	public void saveRandomData(RandomDataRO randomDataRO) {
		RandomData randomData = new RandomData();
		randomData.setId(randomDataRO.getId());
		randomData.setName(randomDataRO.getName());
		randomData.setAge(randomDataRO.getAge());
		randomData.setUuid(randomDataRO.getUuid());
		randomData.setSalary(randomDataRO.getSalary());
		randomData.setGender(randomDataRO.getGender());
		randomData.setBirthdate(randomDataRO.getBirthdate());
		randomDataRepo.save(randomData);
	}
}
