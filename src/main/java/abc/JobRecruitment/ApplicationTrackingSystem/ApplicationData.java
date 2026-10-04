package abc.JobRecruitment.ApplicationTrackingSystem;
import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class ApplicationData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long appid;
	
	@ManyToOne
	@JoinColumn(name="jid")
	private Job jid;
	
	@ManyToOne
	@JoinColumn(name="cid")
	private Candidate cid;
	
	@Column
	private LocalDate applieddate;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	private String coverletter;
	
	@OneToOne(mappedBy="ap")
	private InterviewDetails ip;
	
	public ApplicationData() {
		
	}
	
	public ApplicationData(Job j,Candidate c,LocalDate ad,Status s,String cl) {
		this.jid=j;
		this.cid=c;
		this.applieddate=ad;
		this.status=s;
		this.coverletter=cl;
	}

	public Long getAppid() {
		return appid;
	}

	public void setAppid(Long appid) {
		this.appid = appid;
	}

	public Job getJid() {
		return jid;
	}

	public void setJid(Job jid) {
		this.jid = jid;
	}

	public Candidate getCid() {
		return cid;
	}

	public void setCid(Candidate cid) {
		this.cid = cid;
	}

	public LocalDate getApplieddate() {
		return applieddate;
	}

	public void setApplieddate(LocalDate Date) {
		this.applieddate = Date;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getCoverletter() {
		return coverletter;
	}

	public void setCoverletter(String coverletter) {
		this.coverletter = coverletter;
	}

	public InterviewDetails getIp() {
		return ip;
	}

	public void setIp(InterviewDetails ip) {
		this.ip = ip;
	}

	
	

}
