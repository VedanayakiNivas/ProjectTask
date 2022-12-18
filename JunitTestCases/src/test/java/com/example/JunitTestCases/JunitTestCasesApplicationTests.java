package com.example.JunitTestCases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.JunitTestCases.bean.User;
import com.example.JunitTestCases.dao.UserDao;
import com.example.JunitTestCases.service.UserService;

@SpringBootTest
class JunitTestCasesApplicationTests {

	@MockBean
	private UserDao dao;
	@Autowired
	private UserService service;

	@Test
	public void getUserTest() {
		when(dao.findAll())
				.thenReturn(Stream.of(new User(2, "vedha", 25, "chennai"), new User(1, "nivas", 32, "vadapalani"))
						.collect(Collectors.toList()));
		assertEquals(2, service.getUsers().size());
	}

	@Test
	public void getUserByAddressTest() {
		String address = "vadapalani";
		when(dao.findByAddress(address))
				.thenReturn(Stream.of(new User(2, "vedha", 25, "chennai")).collect(Collectors.toList()));
		assertEquals(1, service.getUserByAddress(address).size());
	}

	@Test
	public void saveTest() {
		User user = new User(3, "sowmy", 26, "pune");
		when(dao.save(user)).thenReturn(user);
		assertEquals(user, service.save(user));
	}

	@Test
	public void deleteUser() {
		User user = new User(12, "sowmy", 26, "pune");
		service.deleteUser(user);
		verify(dao, times(1)).delete(user);
	}

}
