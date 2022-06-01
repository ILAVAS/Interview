package com.track.dto;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.track.repository.AdminRepository;

@SpringBootTest
class AdminDTOTest {

	@InjectMocks
	AdminDTO admin;

	@Mock
	private AdminRepository adminRepo;

	@BeforeEach
	public void setUp() {
		admin = new AdminDTO();

		admin.setUserId(20);
		admin.setName("dharani");
		admin.setGender("female");

		admin.setUserName("Dharani1508");
		admin.setPassword("Dharani15@");

		admin.setDesignation("analayst");
		

	}

	@Test
	public void testGetters() {

		assertEquals(22, admin.getUserId());
		assertEquals("dharani", admin.getName());
		assertEquals("female", admin.getGender());
		assertEquals("Dharani1508", admin.getUserName());
		assertEquals("Dharani15@", admin.getPassword());
		assertEquals("analyst",admin.getDesignation());
		

	}

}