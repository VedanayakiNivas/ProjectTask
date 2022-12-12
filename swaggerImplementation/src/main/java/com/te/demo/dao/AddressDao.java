package com.te.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.demo.bean.Address;
@Repository
public interface AddressDao extends JpaRepository<Address, Integer>{

}
