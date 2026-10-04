package abc.JobRecruitment.ApplicationTrackingSystem;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Job {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long jid;
	
	@Column
	String jobtitle;
	
	@Column
	String location;

	@Column
	double salary;
	
	@Column
   String experience_required;
	
	@Enumerated(EnumType.STRING)
	private JOBType jobtype;
	
	@Column
	private  LocalDate postedDate;
	
	@Column
	private boolean active=true;
	
	
	@ManyToOne
	@JoinColumn(name="cid")
	private Company company;
	
	@OneToMany(mappedBy="jid")
	private List<ApplicationData>appd;
	
	@OneToMany(mappedBy="j")
	private List<JobSkill>js;
	
	
	public Job() {
	
	}
	
	public Job(String jt,String l,double s,String er,JOBType jobtyp,LocalDate pd,Company cid) {
		this.jobtitle=jt;
		this.location=l;
		this.salary=s;
		this.experience_required=er;
		this.jobtype=jobtyp;
		this.postedDate=pd;
		this.company=cid;
	}
	
	

	
	public Long getJid() {
		return jid;
	}

	public void setJid(Long jid) {
		this.jid = jid;
	}

	public String getJobtitle() {
		return jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getExperience_required() {
		return experience_required;
	}

	public void setExperience_required(String experience_required) {
		this.experience_required = experience_required;
	}

	public JOBType getJobtype() {
		return jobtype;
	}

	public void setJobtype(JOBType jobtype) {
		this.jobtype = jobtype;
	}

	public LocalDate getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(LocalDate postedDate) {
		this.postedDate = postedDate;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<ApplicationData> getAppd() {
		return appd;
	}

	public void setAppd(List<ApplicationData> appd) {
		this.appd = appd;
	}

	public List<JobSkill> getJs() {
		return js;
	}

	public void setJs(List<JobSkill> js) {
		this.js = js;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	
	
	
}
