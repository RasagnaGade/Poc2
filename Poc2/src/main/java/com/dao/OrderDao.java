package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Orders;


public interface OrderDao extends JpaRepository<Orders, Integer> {

}
