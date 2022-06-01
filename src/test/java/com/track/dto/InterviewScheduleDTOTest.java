package com.track.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.track.entity.Candidate;
import com.track.entity.Employee;
import com.track.repository.InterviewScheduleRepository;


@SpringBootTest
class InterviewScheduleDTOTest {

	@InjectMocks
	InterviewScheduleDTO interviewSchedule;

	@Mock
	private InterviewScheduleRepository interviewScheduelRepo;

	@BeforeEach
	public void setUp() {
		
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

		 List<Employee> list =new ArrayList <> ();
		list.add(new Employee("hr","pune",false));


		interviewSchedule=new InterviewScheduleDTO();
		interviewSchedule.setInterviewScheduleID(1234);
		interviewSchedule.setTechRating(3);
		interviewSchedule.sethRRating(4);
		interviewSchedule.setRating("good");
		interviewSchedule.setFinalStatus("selcted");
		interviewSchedule.setCandidate(candidate);
		interviewSchedule.setPanel(list);
		
		
	}

	@Test
	public void testGetters(Object candidate, Object list) {

		
		assertEquals(1234,interviewSchedule.getInterviewScheduleID());
		assertEquals(3, interviewSchedule.getTechRating());
		assertEquals(4, interviewSchedule.gethRRating());
		assertEquals("good",interviewSchedule.getRating());
		assertEquals("selected",interviewSchedule.getFinalStatus());
		assertEquals(candidate, interviewSchedule.getCandidate());
		assertEquals(list,interviewSchedule.getPanel());
		

	}

}