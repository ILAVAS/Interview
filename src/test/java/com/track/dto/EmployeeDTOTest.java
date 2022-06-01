package com.track.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.track.repository.EmployeeRepository;


@SpringBootTest
class EmployeeDTOTest {

	@InjectMocks
	EmployeeDTO employee;

	@Mock
	private EmployeeRepository employeeRepo;

	@BeforeEach
	public void setUp() {
		employee = new EmployeeDTO();

		employee.setUserId(3);
		employee.setName("shravani");
		employee.setGender("female");

		employee.setUserName("gunnu");
		employee.setPassword("1234");

		
		employee.setType("hr");
		employee.setLocation("siddipet");
		employee.setPanelMember(false);

	}

	@Test
	public void testGetters() {

		assertEquals(3, employee.getUserId());
		assertEquals("shravani", employee.getName());
		assertEquals("female", employee.getGender());
		assertEquals("gunnu", employee.getUserName());
		assertEquals("1234", employee.getPassword());
		assertEquals("hr", employee.getType());
		assertEquals("siddipet", employee.getLocation());
		assertEquals(false, employee.isPanelMember());

	}

}