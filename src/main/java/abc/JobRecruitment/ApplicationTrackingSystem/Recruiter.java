package abc.JobRecruitment.ApplicationTrackingSystem;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Recruiter {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long rrid;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@Column
	private String address;
	
	@Column
	private boolean active=true;
	
	@ManyToOne
	@JoinColumn(name="cid")
	private Company cid;
	
    public Recruiter() {
    	
    }
	
	public Recruiter(String n,String e,String p,String a,Company cd) {
		this.name=n;
		this.email=e;
		this.password=p;
		this.address=a;
		this.cid=cd;
	}

	public Long getRrid() {
		return rrid;
	}

	public void setRrid(Long rrid) {
		this.rrid = rrid;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Company getCid() {
		return cid;
	}

	public void setCid(Company cid) {
		this.cid = cid;
	}
	

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Recruiter [rrid=" + rrid + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", address=" + address + ", cid=" + cid + "]";
	}
	
	
}
