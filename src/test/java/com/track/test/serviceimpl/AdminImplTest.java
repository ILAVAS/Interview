package com.track.test.serviceimpl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.track.entity.Admin;
import com.track.repository.AdminRepository;
import com.track.serviceimpl.AdminServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminImplTest {
	@Autowired
	public AdminServiceImpl adminServiceImpl;

	@MockBean
	private AdminRepository adminRepo;

	@Test
	public void addCandidate() {

		Admin admin = new Admin();

		admin.setUserId(20);
		admin.setName("Dharani");
		admin.setGender("female");

		admin.setUserName("Dharani1508");
		admin.setPassword("dharani15");

		admin.setDesignation("Analyst");


		Mockito.when(adminRepo.save(admin)).thenReturn(admin);
		assertThat(adminServiceImpl.addCandidate(admin)).isEqualTo(admin);
	}


	private void assertThatAnExceptionWasThrown(String format) {
		
	}

	@Test
	public void scheduleCandidateInterview() {

		Admin admin = new Admin();

		admin.setUserId(20);
		admin.setName("Dharani");
		admin.setGender("female");

		admin.setUserName("Dharani1508");
		admin.setPassword("dharani15");

		admin.setDesignation("Analyst");

		

		Mockito.when(adminRepo.save(admin)).thenReturn(admin);
		assertThat(adminServiceImpl.scheduleCandidateInterview(admin)).isEqualTo(admin);

	}

	@Test
	public void shareTheCandidateWithInterviewPanel() {
		Admin admin = new Admin();
		admin.setUserId(20);
		admin.setName("Dharani");
		admin.setGender("female");

		admin.setUserName("Dharani1508");
		admin.setPassword("dharani15");

		admin.setDesignation("Analyst");

		
		Optional<Admin> admin1 = Optional.of(admin);
		
		
		Mockito.when(adminRepo.findById(20)).thenReturn(admin1);
		assertThat(adminServiceImpl.ShareTheCandidateWithInterviewPanel(20)).isEqualTo(admin);

	}
}