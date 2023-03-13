package com.cg.dryclean.rest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cg.dryclean.entity.Addresses;
import com.cg.dryclean.service.UserService;

@CrossOrigin(origins= "http://localhost:3000")
@RestController
public class AddressController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getAllAddress")
	public ResponseEntity<List<Addresses>> findAllAddresses()
	{
		List<Addresses> addrs=userService.findAllAddresses();
		return ResponseEntity.ok(addrs);
	}
	
//	@GetMapping("address/{addressid}")
//	public ResponseEntity<Addresses> findAddressById(@PathVariable("addressid") int addressid)
//	{
//		Addresses addr=userService.findAddressById(addressid);
//		return ResponseEntity.ok(addr);
//	}
	@GetMapping("address/{addressid}")
	  public ResponseEntity<Addresses> findAddressById(@PathVariable("addressid") int addressid)
	  {
	    Addresses addr=userService.findAddressById(addressid);
	    return ResponseEntity.ok(addr);
	  }
	
	@RequestMapping(value="/addAddress",method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity<String> addAddress(@RequestBody Addresses address)
	{
		userService.addAddress(address);
		return ResponseEntity.ok("Address Saved");
	}
	
	
	@PutMapping("/address/{addressid}")
	 public Addresses updateAddress(@PathVariable int addressid, @RequestBody Addresses address) 
	{
	    return userService.updateAddress(addressid, address);
	}	
	
}
