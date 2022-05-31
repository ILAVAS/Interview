package com.track.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;


@Entity
@Table(name="interviewSchedule")

public class InterviewSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int interviewScheduleID;

	@Min(value = 2)
	@NotNull
	private float techRating;
	@Min(value = 2)
	@NotNull
	private float hRRating;

	@NotNull
	private String finalStatus;

	
	private String rating;

	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime interviewTime;
	
	@OneToOne
	@JoinColumn(name = "Candidate.userId")
	private Candidate candidate;
   
	@OneToMany(cascade = CascadeType.MERGE)

	@JoinColumn(name = "Employee.userId")
	List<Employee> panel = new ArrayList<Employee>();

	public InterviewSchedule() {
		super();
	}

	public InterviewSchedule(int interviewScheduleID, @Min(value = 2) float techRating, @Min(value =2) float hRRating,
			@NotNull String finalStatus,  String rating, LocalDateTime interviewTime, 
			Candidate candidate,  List<Employee> panel) {
		super();
		this.interviewScheduleID = interviewScheduleID;
		this.techRating = techRating;
		this.hRRating = hRRating;
		this.finalStatus = finalStatus;
		this.rating = rating;
		this.interviewTime = interviewTime;
		this.candidate = candidate;
		this.panel = panel;
	}

	public int getInterviewScheduleID() {
		return interviewScheduleID;
	}

	public void setInterviewScheduleID(int interviewScheduleID) {
		this.interviewScheduleID = interviewScheduleID;
	}

	public float getTechRating() {
		return techRating;
	}

	public void setTechRating(float techRating) {
		this.techRating = techRating;
	}

	public float gethRRating() {
		return hRRating;
	}

	public void sethRRating(float hRRating) {
		this.hRRating = hRRating;
	}

	public String getFinalStatus() {
		return finalStatus;
	}

	public void setFinalStatus(String finalStatus) {
		this.finalStatus = finalStatus;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public LocalDateTime getInterviewTime() {
		return interviewTime;
	}

	public void setInterviewTime(LocalDateTime interviewTime) {
		this.interviewTime = interviewTime;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public List<Employee> getPanel() {
		return panel;
	}

	public void setPanel(List<Employee> panel) {
		this.panel = panel;
	}



	@Override
	public String toString() {
		return "InterviewSchedule [interviewScheduleID=" + interviewScheduleID + ", techRating=" + techRating
				+ ", hRRating=" + hRRating + ", finalStatus=" + finalStatus + ", rating=" + rating +",interviewTime="+interviewTime + ", candidate=" + candidate + ", panel=" + panel + "]";
	}

	

}