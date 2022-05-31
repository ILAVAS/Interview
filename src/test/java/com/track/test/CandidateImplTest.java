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
import com.track.entity.Candidate;
import com.track.repository.CandidateRepository;
import com.track.serviceimpl.CandidateServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CandidateImplTest {

	@Autowired
	public CandidateServiceImpl candidateServiceImpl;

	@MockBean
	private CandidateRepository candidateRepo;

	@Test
	public void addCandidate() {

		Candidate candidate = new Candidate();

		candidate.setUserId(22);
		candidate.setName("manoj");
		candidate.setGender("male");

		candidate.setUserName("manoj");
		candidate.setPassword("123123");

		candidate.setPrimarySkils("java");
		candidate.setSecondarySkils("c");
		candidate.setExperience(3);
		candidate.setQualification("btech");
		candidate.setDesignation("developer");
		candidate.setNoticePeriod(3);
		candidate.setLocation("warangal");
		candidate.setStatus("selected");

		Mockito.when(candidateRepo.save(candidate)).thenReturn(candidate);
		assertThat(candidateServiceImpl.addCandidate(candidate)).isEqualTo(candidate);
	}

	@Test
	public void viewCandidate() {

		 Optional<Candidate> candidate1 = Optional.of(new Candidate());

		Candidate candidate = new Candidate();

		/*
		 * candidate.setUserId(22); candidate.setName("manoj kumar");
		 * candidate.setGender("male");
		 * 
		 * candidate.setUserName("manoj"); candidate.setPassword("123123");
		 * 
		 * candidate.setPrimarySkils("java"); candidate.setSecondarySkils("c");
		 * candidate.setExperience(3); candidate.setQualification("btech");
		 * candidate.setDesignation("developer"); candidate.setNoticePeriod(3);
		 * candidate.setLocation("warangal"); candidate.setStatus("selected");
		 */

		 Mockito.when(candidateRepo.findById(22)).thenReturn(candidate1);
		//when(candidateRepo.findById(22)).thenReturn(Optional.empty());
	//	assertThat(candidateServiceImpl.viewCandidate(22)).isEqualTo(candidate1);


	}
     
	
	@Test
	public void throwExceptionWhenCandidateIdNotFound() {
	    int id = anyInt();
	    when(candidateRepo.findById(id)).thenReturn(Optional.empty());
	    assertThatAnExceptionWasThrown(String.format("Quarter does not exist for id = %s!", id));
	}
	
	private void assertThatAnExceptionWasThrown(String format) {
		
	}

	@Test
	public void viewCandidates() {

		Candidate candidate1 = new Candidate();

		candidate1.setUserId(22);
		candidate1.setName("manoj kumar");
		candidate1.setGender("male");

		candidate1.setUserName("manoj");
		candidate1.setPassword("123123");

		candidate1.setPrimarySkils("java");
		candidate1.setSecondarySkils("c");
		candidate1.setExperience(3);
		candidate1.setQualification("btech");
		candidate1.setDesignation("developer");
		candidate1.setNoticePeriod(3);
		candidate1.setLocation("warangal");
		candidate1.setStatus("selected");

		Candidate candidate2 = new Candidate();
		candidate2.setUserId(21);
		candidate2.setName("manoj");
		candidate2.setGender("male");
		candidate2.setUserName("manoj");
		candidate2.setPassword("123123");
		candidate2.setPrimarySkils("java");
		candidate2.setSecondarySkils("c");
		candidate2.setExperience(3);
		candidate2.setQualification("btech");
		candidate2.setDesignation("developer");
		candidate2.setNoticePeriod(3);
		candidate2.setLocation("warangal");
		candidate2.setStatus("selected");

		ArrayList<Candidate> candidateList = new ArrayList<Candidate>();
		candidateList.add(candidate1);
		candidateList.add(candidate2);

		Mockito.when(candidateRepo.findAll()).thenReturn(candidateList);
		assertThat(candidateServiceImpl.viewCandidates()).isEqualTo(candidateList);

	}
}
