package com.track.service;

import com.track.entity.Admin;

public interface AdminService {

	public Admin addCandidate( Admin admin);

    public Admin scheduleCandidateInterview( Admin admin);

	public Admin shareTheCandidateWithInterviewPanel( Admin admin);
	
	
}