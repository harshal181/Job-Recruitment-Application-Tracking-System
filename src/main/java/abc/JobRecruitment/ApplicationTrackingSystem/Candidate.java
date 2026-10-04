package abc.JobRecruitment.ApplicationTrackingSystem;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Entity
public class Candidate {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long candid;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@Column
	private String education;
	
	@Column
	private String address;
	
	@Column
	private Long phonenum;
	
	@Column
	private LocalDate dob;
	
	@Column
	private boolean active=true;
	
	@OneToMany(mappedBy="cid")
	private List<ApplicationData>appdd;
	
	@OneToMany(mappedBy="cid")
	private List<Skill>ss;
	
	@OneToOne(mappedBy="cid")
	private Resume r;
	
	
	public Candidate() {
		
	}
	
	public Candidate(String n,String e,String p,String ed,String a,Long pn,LocalDate db) {
		this.name=n;
		this.email=e;
		this.password=p;
		this.education=ed;
		this.address=a;
		this.phonenum=pn;
		this.dob=db;
	}

	public Long getCandid() {
		return candid;
	}

	public void setCandid(Long candid) {
		this.candid = candid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(Long phonenum) {
		this.phonenum = phonenum;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	

	public List<ApplicationData> getAppdd() {
		return appdd;
	}

	public void setAppdd(List<ApplicationData> appdd) {
		this.appdd = appdd;
	}

	public List<Skill> getSs() {
		return ss;
	}
	

	public void setSs(List<Skill> ss) {
		this.ss = ss;
	}

	public Resume getR() {
		return r;
	}

	public void setR(Resume r) {
		this.r = r;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	

	
	
}
