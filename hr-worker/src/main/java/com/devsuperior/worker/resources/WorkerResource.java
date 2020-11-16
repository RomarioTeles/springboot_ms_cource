package com.devsuperior.worker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.worker.entities.Worker;
import com.devsuperior.worker.repositories.WorkerRepository;

@RestController
@RequestMapping(value="/workers")
public class WorkerResource {
	
	private Logger logger = LoggerFactory.getLogger(WorkerResource.class);
	
	@Value("${test.config}")
	private String testeConfig;
	
	@Autowired
	private Environment env;

	@Autowired
	private WorkerRepository repository;
	
	@GetMapping("/configs")
	public ResponseEntity<Void> getConfigs(){
		logger.info("CONFIG="+testeConfig);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> list = repository.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		logger.info("Port="+env.getProperty("server.port"));
		Worker obj = repository.findById(id).get();
		return ResponseEntity.ok(obj);
	}
	
	
}
