package abc.JobRecruitment.ApplicationTrackingSystem;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationDataRepo extends JpaRepository<ApplicationData,Long>{

	public List<ApplicationData>findBycid(Candidate cc);
	public void deleteByJid_Jid(Long jid);
	
	public List<ApplicationData>findByJidIn(List<Job>j);
	
}
