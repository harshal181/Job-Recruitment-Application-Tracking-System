package abc.JobRecruitment.ApplicationTrackingSystem;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long aid;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@Column
	private Long phonenum;
	
	@Column
	private boolean active=true;
	
	@OneToMany(mappedBy="admin")
	private List<Company>companies;
	
	
	public Admin() {
		
	}
	

	public Admin(String n,String e,String pp,Long pn){
		this.name=n;
		this.email=e;
		this.password=pp;
		this.phonenum=pn;
	}


	public Long getAid() {
		return aid;
	}


	public void setAid(Long aid) {
		this.aid = aid;
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


	public Long getPhonenum() {
		return phonenum;
	}


	public void setPhonenum(Long phonenum) {
		this.phonenum = phonenum;
	}


	public List<Company> getCompanies() {
		return companies;
	}


	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}
	
	


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", name=" + name + ", email=" + email + ", password=" + password + ", phonenum="
				+ phonenum + "]";
	}
	
	
	
	
}
