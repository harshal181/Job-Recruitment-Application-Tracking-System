package abc.JobRecruitment.ApplicationTrackingSystem;
import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Resume {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long rid;
	
	@Column
	private String resumename;
	
	@Column
	private LocalDate uploadeddate;
	

	@OneToOne
	@JoinColumn(name="cid")
	private Candidate cid;


	public Long getRid() {
		return rid;
	}


	public void setRid(Long rid) {
		this.rid = rid;
	}


	public String getResumename() {
		return resumename;
	}


	public void setResumename(String resumename) {
		this.resumename = resumename;
	}


	public LocalDate getUploadeddate() {
		return uploadeddate;
	}


	public void setUploadeddate(LocalDate localDate) {
		this.uploadeddate = localDate;
	}


	public Candidate getCid() {
		return cid;
	}


	public void setCid(Candidate cid) {
		this.cid = cid;
	}


	@Override
	public String toString() {
		return "Resume [rid=" + rid + ", resumename=" + resumename + ", uploadeddate=" + uploadeddate + ", cid=" + cid
				+ "]";
	}
	
	

}
