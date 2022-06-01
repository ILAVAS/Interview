package com.track.test.serviceimpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.track.entity.Employee;
import com.track.exception.EmployeeNotFoundException;
import com.track.repository.EmployeeRepository;
import com.track.serviceimpl.EmployeeServiceImpl;

@SpringBootTest
public class EmployeeServiceImplTest {

	// @Autowired
	@InjectMocks
	public EmployeeServiceImpl employeeServiceImpl;

	@Mock
	private EmployeeRepository employeeRepo;

	@Test
	public void registerCandidate() {
		Employee employee=new Employee();
	      
	      employee.setUserId(9);
	      employee.setName("ila");
	      employee.setGender("female");
	      employee.setUserName("ilavas");
	      employee.setPassword("ila345");
	      employee.setType("HR");
	      employee.setLocation("chennai");
	      employee.setPanelMember(false);
	     		

		Mockito.when(employeeRepo.save(employee)).thenReturn(employee);
		assertThat(employeeServiceImpl.registerEmployee(employee)).isEqualTo(employee);
	}

		
	@Test
	public void getAllEmployees() {


		Employee employee1 = new Employee();

	      employee1.setUserId(9);
	      employee1.setName("ila");
	      employee1.setGender("female");
	      employee1.setUserName("ilavas");
	      employee1.setPassword("ila345");
	      employee1.setType("HR");
	      employee1.setLocation("chennai");
	      employee1.setPanelMember(false);
	      
	      Employee employee2 = new Employee();

	      employee2.setUserId(15);
	      employee2.setName("ilav");
	      employee2.setGender("female");
	      employee2.setUserName("indhu");
	      employee2.setPassword("la455");
	      employee2.setType("TECH");
	      employee2.setLocation("HYD");
	      employee2.setPanelMember(true);

		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(employee1);
		employeeList.add(employee2);

		Mockito.when(employeeRepo.findAll()).thenReturn(employeeList);
		assertThat(employeeServiceImpl.getAllEmployees()).isEqualTo(employeeList);
	}
		
		
		@Test
		public void testNoEmployeeFound() {
			
		List<Employee> employeeList1= new ArrayList<>();
		
		when(employeeRepo.findAll()).thenReturn(employeeList1);
		try {
		assertNotNull( employeeServiceImpl.getAllEmployees());
		} catch (EmployeeNotFoundException e) {
		assertEquals("employee not found",e.getMessage());
		}
		}
		
		
}