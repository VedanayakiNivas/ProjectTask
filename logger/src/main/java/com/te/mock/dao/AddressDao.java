package com.te.mock.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.mock.bean.Address;

@Repository
public interface AddressDao extends JpaRepository<Address, Integer> {

}
