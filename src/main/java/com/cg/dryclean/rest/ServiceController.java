package com.cg.dryclean.rest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.dryclean.entity.Services;
import com.cg.dryclean.service.OrderService;

@RestController
public class ServiceController {
	
	@Autowired
	private OrderService serviceService;
	
	@GetMapping("/getAllServices")
	public ResponseEntity <List<Services>> findAllServices()
	{
		List<Services> serv = serviceService.findAllServices();
		return ResponseEntity.ok(serv);	
	}
	
	@PostMapping("/addNewService")
	public ResponseEntity<String> addNewService(@RequestBody Services service)
	{	
		serviceService.addService(service);
		return ResponseEntity.ok("Service Saved");
	}
	
}
