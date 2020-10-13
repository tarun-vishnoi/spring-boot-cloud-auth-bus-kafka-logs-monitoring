package com.consumer.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consumer.pojo.RandomData;

public interface RandomDataRepo extends JpaRepository<RandomData, Integer> {

}
