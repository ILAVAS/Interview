package com.track.serviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.track.entity.Admin;
import com.track.repository.AdminRepository;
import com.track.service.AdminService;


@Service
 public   class AdminServiceImpl implements AdminService {
	 

	 @Autowired
		private AdminRepository adminRepo;

	@Override
	public Admin addCandidate(Admin admin) {
		
		return adminRepo.save(admin);
	}
	@Override
	public  Admin scheduleCandidateInterview(Admin admin) {
		
		return adminRepo.save(admin);
	}

	@Override
	public  Admin shareTheCandidateWithInterviewPanel(Admin admin) {
		
		return  adminRepo.save(admin);
	
		}
}