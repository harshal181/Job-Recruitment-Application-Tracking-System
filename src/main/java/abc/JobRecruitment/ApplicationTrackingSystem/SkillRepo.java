package abc.JobRecruitment.ApplicationTrackingSystem;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepo extends JpaRepository<Skill,Long> {

	public List<Skill>findBycid(Candidate c);
	
}
