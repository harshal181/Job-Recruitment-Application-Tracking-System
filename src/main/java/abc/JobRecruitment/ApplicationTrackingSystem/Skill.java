package abc.JobRecruitment.ApplicationTrackingSystem;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Skill {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long sid;
	
	@Column
	private String skillname;
	
	@Column
	private String skilllevel;
	
	@ManyToOne
	@JoinColumn(name="cid")
	private Candidate cid;
	
	public Skill() {
		
	}
	
	public Skill(String sn,String sl,Candidate c) {
		this.skillname=sn;
		this.skilllevel=sl;
		this.cid=c;
	}

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getSkillname() {
		return skillname;
	}

	public void setSkillname(String skillname) {
		this.skillname = skillname;
	}

	public String getSkilllevel() {
		return skilllevel;
	}

	public void setSkilllevel(String skilllevel) {
		this.skilllevel = skilllevel;
	}

	public Candidate getCid() {
		return cid;
	}

	public void setCid(Candidate cid) {
		this.cid = cid;
	}


	
}
