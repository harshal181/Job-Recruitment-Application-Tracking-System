package abc.JobRecruitment.ApplicationTrackingSystem;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class InterviewDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long interviewid;
	
	@Column
	private LocalDate interviewdate;
	
	@Column
	private LocalTime interviewTime;
	
	@Column
	private String round;
	
	@Column
	private String mode;
	
	@Column
	private String meetinglink;
	
	@Column
	private String status;
	
	@Column
	private String feedback;
	
	@OneToOne
	@JoinColumn(name="appid")
	private ApplicationData ap;
	
	public InterviewDetails() {
		
	}
	
	public InterviewDetails(LocalDate id,LocalTime it,String r,String m,String ml,String st,String f,ApplicationData app) {
		this.interviewdate=id;
		this.interviewTime=it;
		this.round=r;
		this.mode=m;
		this.meetinglink=ml;
		this.status=st;
		this.feedback=f;
		this.ap=app;
	}

	public Long getInterviewid() {
		return interviewid;
	}

	public void setInterviewid(Long interviewid) {
		this.interviewid = interviewid;
	}

	public LocalDate getInterviewdate() {
		return interviewdate;
	}

	public void setInterviewdate(LocalDate interviewdate) {
		this.interviewdate = interviewdate;
	}

	public LocalTime getInterviewTime() {
		return interviewTime;
	}

	public void setInterviewTime(LocalTime interviewTime) {
		this.interviewTime = interviewTime;
	}

	public String getRound() {
		return round;
	}

	public void setRound(String round) {
		this.round = round;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getMeetinglink() {
		return meetinglink;
	}

	public void setMeetinglink(String meetinglink) {
		this.meetinglink = meetinglink;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public ApplicationData getAp() {
		return ap;
	}

	public void setAp(ApplicationData ap) {
		this.ap = ap;
	}


	
}
