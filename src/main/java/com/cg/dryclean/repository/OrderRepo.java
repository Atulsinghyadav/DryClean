package com.cg.dryclean.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.dryclean.entity.Orders;


@Repository
public interface OrderRepo extends JpaRepository<Orders, Integer> {
	 

}
