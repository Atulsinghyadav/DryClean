package com.cg.dryclean.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.dryclean.entity.Orders;
import com.cg.dryclean.entity.Usernames;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Integer> {
	 
//	List<Orders> findAllByUsernamesId(int id);
}
