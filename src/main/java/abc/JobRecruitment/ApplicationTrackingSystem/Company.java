package abc.JobRecruitment.ApplicationTrackingSystem;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Company {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cid;
	
	@Column
	private String cname;
	
	@Column
	private String email;
	
	@Column
	private String address;
	
	@Column
	private String website;
	
	@Column
	private String description;
	
	@Column
	private boolean active=true;
	
	@ManyToOne
	@JoinColumn(name="aid")
	private Admin admin;
	
	@OneToMany(mappedBy="company")
	private List<Job>jb;
	
	@OneToMany(mappedBy="cid")
	private List<Recruiter>rr;
	
	

	
	public Company() {
		
	}
	
	public Company(String cn,String e,String a,String w,String d,Admin addd) {
		this.cname=cn;
		this.email=e;
		this.address=a;
		this.website=w;
		this.description=d;
		this.admin=addd;
	}

	

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Job> getJb() {
		return jb;
	}

	public void setJb(List<Job> jb) {
		this.jb = jb;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public List<Recruiter> getRr() {
		return rr;
	}

	public void setRr(List<Recruiter> rr) {
		this.rr = rr;
	}
	
	

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Company [cid=" + cid + ", cname=" + cname + ", email=" + email + ", address=" + address + ", website="
				+ website + ", description=" + description + "]";
	}
	


	
	
	
	
}
