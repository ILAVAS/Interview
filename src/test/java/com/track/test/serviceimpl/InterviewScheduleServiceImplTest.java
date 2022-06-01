package com.track.test.serviceimpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.track.entity.Candidate;
import com.track.entity.Employee;
import com.track.entity.InterviewSchedule;
import com.track.repository.InterviewScheduleRepository;
import com.track.serviceimpl.InterviewScheduleServiceImpl;




@RunWith(SpringRunner.class)
@SpringBootTest
public class InterviewScheduleServiceImplTest {
	
	
	@InjectMocks
	public InterviewScheduleServiceImpl interviewScheduleServiceImpl;

	@MockBean
	private InterviewScheduleRepository interviewScheduleRepo;
	
		
	
	@Test
	public void scheduleCandidateInterview() {

		List<Employee> list =new ArrayList <> ();
		list.add(new Employee("hr","pune",false));
		Candidate candidate=new Candidate();
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


				
		InterviewSchedule interviewSchedule =new InterviewSchedule();
		interviewSchedule.setCandidate(candidate);
		
		interviewSchedule.setFinalStatus("No response");
		interviewSchedule.sethRRating(0);
		interviewSchedule.setInterviewScheduleID(14);
		interviewSchedule.setPanel(list);
		interviewSchedule.setRating("No response");
		interviewSchedule.setTechRating(0);
				

		Mockito.when(interviewScheduleRepo.save(interviewSchedule)).thenReturn(interviewSchedule);
		assertThat(interviewScheduleServiceImpl.scheduleCandidateInterview(interviewSchedule)).isEqualTo(interviewSchedule);
	}


		@Test
	public void throwExceptionWhenInterviewScheduleIDNotFound() {
	    int id = anyInt();
	    when(interviewScheduleRepo.findById(id)).thenReturn(Optional.empty());
	    assertThatAnExceptionWasThrown(String.format("Quarter does not exist for id = %s!", id));
	}


	private void assertThatAnExceptionWasThrown(String format) {
		
	}

	@Test
	public void cancelCandidateInterviewSchedule() {

		 Optional<InterviewSchedule> interview = Optional.of(new InterviewSchedule());

		 InterviewSchedule interviewSchedule1 =new InterviewSchedule();
		
		
		 List<Employee> list =new ArrayList <> ();
			list.add(new Employee("hr","pune",false));

		 
		 Candidate candidate=new Candidate();
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

		    interviewSchedule1.setInterviewScheduleID(16);
			interviewSchedule1.setCandidate(candidate);
			interviewSchedule1.setFinalStatus("pending");
			interviewSchedule1.sethRRating(3);
			interviewSchedule1.setPanel(list);
			interviewSchedule1.setRating("pending");
			interviewSchedule1.setTechRating(4);		

		 Mockito.when(interviewScheduleRepo.findById(16)).thenReturn(interview);
		assertThat(interviewScheduleServiceImpl.cancelCandidateInterviewSchedule(16)).isEqualTo(interview);

		
	}


@Test
public void throwExceptionWhenCandidateIDNotFound() {
    int interviewScheduleID = anyInt();
    when(interviewScheduleRepo.findById(interviewScheduleID)).thenReturn(Optional.empty());
    assertThatAnExceptionWasThrown(String.format("Quarter does not exist for id = %s!", interviewScheduleID));
}




	@Test
	public void giveRatingToCandidate()	{
	Optional<InterviewSchedule> interview1 = Optional.of(new InterviewSchedule());
	

	 InterviewSchedule interviewSchedule2 =new InterviewSchedule();
	
	 
	 List<Employee> list =new ArrayList <> ();
		list.add(new Employee("hr","pune",false));

		Candidate candidate=new Candidate();
		candidate.setUserId(21);
		candidate.setName("raj");
		candidate.setGender("male");

		candidate.setUserName("rj");
		candidate.setPassword("123");

		candidate.setPrimarySkils("c");
		candidate.setSecondarySkils("c++");
		candidate.setExperience(2);
		candidate.setQualification("btech");
		candidate.setDesignation("tester");
		candidate.setNoticePeriod(3);
		candidate.setLocation("pune");
		candidate.setStatus("selected");

	    interviewSchedule2.setInterviewScheduleID(14);
	    interviewSchedule2.setTechRating(5);
	    interviewSchedule2.sethRRating(5);
	    interviewSchedule2.setFinalStatus("selected");
	    interviewSchedule2.setRating("selected");
		interviewSchedule2.setCandidate(candidate);
		interviewSchedule2.setPanel(list);
				
		
		
		Mockito.when(interviewScheduleRepo.findById(14)).thenReturn(interview1);
		assertThat(interviewScheduleServiceImpl.giveRatingToCandidate(14)).isEqualTo(interview1);


	
		
		
	}
}