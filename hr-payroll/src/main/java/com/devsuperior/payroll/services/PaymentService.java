package com.devsuperior.payroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.payroll.entities.Payment;
import com.devsuperior.payroll.entities.Worker;
import com.devsuperior.payroll.feignClient.WorkerFeignClient;

@Service
public class PaymentService {
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(Long workerId, Integer days) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", workerId.toString());
		Worker worker = workerFeignClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
	
}
