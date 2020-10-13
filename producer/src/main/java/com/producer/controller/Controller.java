package com.producer.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.producer.ro.RandomDataRO;
import com.producer.service.KafkaService;
import com.producer.util.Action;

@RestController
@RequestMapping("/random-data") /*** localhost:8080/random-data ***/
public class Controller {

	@Autowired
	private KafkaService kafkaService;

	@GetMapping /*** localhost:8080/random-data?startId=1&endId=50&sort=desc ***/
	public ResponseEntity<List<RandomDataRO>> getRandomDatas(
			@RequestParam(defaultValue = "1", required = true) Integer startID,
			@RequestParam(defaultValue = "50", required = false) Integer endId,
			@RequestParam(defaultValue = "asc", required = false) String sort) {
		List<RandomDataRO> randomDatas = new ArrayList<RandomDataRO>();
		// to-do
		return new ResponseEntity<List<RandomDataRO>>(randomDatas, HttpStatus.OK);
	}

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }) /*** localhost:8080/random-data/1 ***/
	public ResponseEntity<RandomDataRO> getRandomdataById(@PathVariable String id) {
		RandomDataRO randomData = new RandomDataRO();
		// to-do
		return new ResponseEntity<RandomDataRO>(randomData, HttpStatus.OK);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }) /*** localhost:8080/random-data ***/
	public ResponseEntity<RandomDataRO> createRandomData(@Valid @RequestBody RandomDataRO randomData) {
		kafkaService.checkAction(randomData, Action.POST);
		return new ResponseEntity<RandomDataRO>(randomData, HttpStatus.CREATED);
	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE }) /*** localhost:8080/random-data/1 ***/
	public ResponseEntity<RandomDataRO> updateRandomData(@PathVariable String id,
			@Valid @RequestBody RandomDataRO randomData) {
		kafkaService.checkAction(randomData, Action.PUT);
		return new ResponseEntity<RandomDataRO>(randomData, HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/{id}") /*** localhost:8080/random-date/1 ***/
	public ResponseEntity<RandomDataRO> deleteRandomData(@PathVariable String id) {
		return new ResponseEntity<RandomDataRO>(HttpStatus.OK);
		// to-do
	}
}
