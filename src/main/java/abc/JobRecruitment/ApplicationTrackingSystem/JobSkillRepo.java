package abc.JobRecruitment.ApplicationTrackingSystem;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSkillRepo extends JpaRepository<JobSkill,Long>{
	
	public List<JobSkill>findByj(Job jj);
	public void deleteByJ_Jid(Long jid);

}
