package com.lti.eshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.eshopping.model.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order,Integer>{

}
