package abc.JobRecruitment.ApplicationTrackingSystem;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class JobSkill {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Jobskillid;
	
	@Column 
	String jobskillname;

	@ManyToOne
	@JoinColumn(name="jid")
	private Job j;
	
	public JobSkill() {
		
	}
	
	public JobSkill(String jn,Job j1) {
		this.jobskillname=jn;
		this.j=j1;
	}

	public Long getJobskillid() {
		return Jobskillid;
	}

	public void setJobskillid(Long jobskillid) {
		Jobskillid = jobskillid;
	}

	public String getJobskillname() {
		return jobskillname;
	}

	public void setJobskillname(String jobskillname) {
		this.jobskillname = jobskillname;
	}

	public Job getJ() {
		return j;
	}

	public void setJ(Job j) {
		this.j = j;
	}
	
	
	

}
