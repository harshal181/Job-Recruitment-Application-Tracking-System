package abc.JobRecruitment.ApplicationTrackingSystem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepo extends JpaRepository<Resume,Long> {
	public Resume findByCid(Candidate cc);

}
