package com.te.streams.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.streams.bean.Address;

@Repository
public interface AddressDao  extends JpaRepository<Address, Integer>{

	
}
