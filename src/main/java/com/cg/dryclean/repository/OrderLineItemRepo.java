package com.cg.dryclean.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.dryclean.entity.OrderLineItem;

public interface OrderLineItemRepo extends JpaRepository<OrderLineItem, Integer> {

}
