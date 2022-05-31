package com.track.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("admin")
public class Admin extends User {
	
	@NotNull
	private String designation;
	
	public Admin() {
		super();
	}

	public Admin(@NotNull String designation) {
		super();
		this.designation = designation;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Admin [designation=" + designation + "]";
	}	
	
	
	
}