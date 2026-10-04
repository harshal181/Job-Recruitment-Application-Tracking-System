package abc.JobRecruitment.ApplicationTrackingSystem;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruiterRepo extends JpaRepository<Recruiter,Long>{
	

	public List<Recruiter>findByCidIn(List<Company>c);
	

}
