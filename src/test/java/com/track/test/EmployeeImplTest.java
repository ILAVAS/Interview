package com.track.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.track.entity.Employee;
import com.track.repository.EmployeeRepository;
import com.track.serviceimpl.EmployeeServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeImplTest {

	@Autowired
	public EmployeeServiceImpl employeeServiceImpl;

	@MockBean
	private EmployeeRepository EmployeeRepo;
	
	
	@Test
	public void registerEmployee() {

      Employee employee=new Employee();
      
      employee.setUserId(9);
      employee.setName("ila");
      employee.setGender("female");
      employee.setUserName("ilavas");
      employee.setPassword("ila345");
      employee.setType("HR");
      employee.setLocation("chennai");
      employee.setPanelMember(false);
     		
		Mockito.when(EmployeeRepo.save(employee)).thenReturn(employee);
		assertThat(employeeServiceImpl.registerEmployee(employee)).isEqualTo(employee);
	}

		
	@Test
	public void throwExceptionWhenEmployeeIdNotFound() {
	    int id = anyInt();
	    when(EmployeeRepo.findById(id)).thenReturn(Optional.empty());
	    assertThatAnExceptionWasThrown(String.format("Quarter does not exist for id = %s!", id));
	}
	
	private void assertThatAnExceptionWasThrown(String format) {
		
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


		Mockito.when(EmployeeRepo.findAll()).thenReturn(employeeList);
		assertThat(employeeServiceImpl.getEmployees()).isEqualTo(employeeList);

	}}
	
/*	@Test
	public void searchEmployee() {

		Employee employee = new Employee();

		employee.setUserId(3);
		employee.setName("indhu");
		employee.setGender("female");

		employee.setUserName("ila");
		employee.setPassword("1234");

		employee.setType("hr");
		employee.setLocation("chennai");
		employee.setPanelMember(true);

		Mockito.when(EmployeeRepo.save(employee)).thenReturn(employee);
		assertThat(employeeServiceImpl.registerEmployee(employee)).isEqualTo(employee);

		assertThat(employeeServiceImpl.searchEmployee(16)).isEqualTo(employee);
		
	//	assertThat(employeeServiceImpl.registerEmployee(employee)).isEqualTo(employee);


	}

	@Test
	public void deleteEmployee() {

		Employee employee = new Employee();

		employee.setUserId(3);
		employee.setName("ila");
		employee.setGender("female");

		employee.setUserName("gunnu");
		employee.setPassword("1234");

		employee.setType("hr");

		employee.setLocation("hyd");
		employee.setPanelMember(true);

		Mockito.when(EmployeeRepo.save(employee)).thenReturn(employee);
		assertThat(employeeServiceImpl.deleteEmployee(employee.getUserId())).isEqualTo(employee);

	}
*/
	
	
  







