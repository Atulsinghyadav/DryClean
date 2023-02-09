package com.cg.dryclean.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.dryclean.entity.Addresses;
import com.cg.dryclean.entity.Usernames;
import com.cg.dryclean.repository.AddressRepo;
import com.cg.dryclean.repository.UsersRepo;

@Service
public class UserService {
	
	@Autowired
	private UsersRepo usersRepo;
	@Autowired
	private AddressRepo addressRepo;
	
	
	public List<Usernames> getAllUsers() 
	{
	    return usersRepo.findAll();
	}
	public Usernames getUser(int userid)
	{
		    return usersRepo.findById(userid).get();
	}
	public Usernames addUser(Usernames user)
	{
		return usersRepo.save(user);
	}
	
	public Usernames changePassword(int id, Usernames user)
	{
		Usernames existingUser = usersRepo.findById(id).get();
		existingUser.setPassword(user.getPassword());
		return usersRepo.save(existingUser);
	}
	public Usernames updateUser(int id, Usernames user)
	{
		Usernames existingUser = usersRepo.findById(id).get();
		existingUser.setName(user.getName());
		existingUser.setEmail(user.getEmail());
		existingUser.setPassword(user.getPassword());
		existingUser.setContactNo(user.getContactNo());
		existingUser.setRole(user.getRole());
		existingUser.setAddress(user.getAddress());
		return usersRepo.save(existingUser);
	}
	
	
	
	public List<Addresses> findAllAddresses()
	{
		return addressRepo.findAll();
	}
	
	public Addresses addAddress(Addresses address)
	{
		
		return addressRepo.save(address);
	}
	
	public Addresses findAddressById(int id)
	{
		return addressRepo.findById(id).get();
	}
	
	public Addresses updateAddress(int id, Addresses address) 
	{
		Addresses existingAdd = addressRepo.findById(id).get();
		existingAdd.setDoorNo(address.getDoorNo());
		existingAdd.setStreet(address.getStreet());
		existingAdd.setArea(address.getArea());
		existingAdd.setCity(address.getCity());
		existingAdd.setState(address.getState());
		existingAdd.setPincode(address.getPincode());
		return addressRepo.save(existingAdd);
	}
	public void deleteAddressById(int addressid)
	{
		addressRepo.deleteById(addressid);
	}
	 
}