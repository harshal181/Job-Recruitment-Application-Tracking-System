package abc.JobRecruitment.ApplicationTrackingSystem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InterViewDetailsRepo extends JpaRepository<InterviewDetails,Long>{

	public void deleteByAp_Jid_Jid(Long  jid);
	public InterviewDetails findByAp(ApplicationData ap);
	
	
}
