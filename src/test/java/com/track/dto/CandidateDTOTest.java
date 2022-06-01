package com.track.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.track.repository.CandidateRepository;

@SpringBootTest
class CandidateDTOTest {

	@InjectMocks
	CandidateDTO candidate;

	@Mock
	private CandidateRepository candidateRepo;

	@BeforeEach
	public void setUp() {
		candidate = new CandidateDTO();

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

	}

	@Test
	public void testGetters() {

		assertEquals(22, candidate.getUserId());
		assertEquals("manoj", candidate.getName());
		assertEquals("male", candidate.getGender());
		assertEquals("manoj", candidate.getUserName());
		assertEquals("123123", candidate.getPassword());
		assertEquals("java", candidate.getPrimarySkils());
		assertEquals("c", candidate.getSecondarySkils());
		assertEquals("btech", candidate.getQualification());
		assertEquals("developer", candidate.getDesignation());
		assertEquals(3, candidate.getNoticePeriod());
		assertEquals("warangal", candidate.getLocation());
		assertEquals("selected", candidate.getStatus());

	}

}