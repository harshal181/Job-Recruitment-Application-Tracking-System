package abc.JobRecruitment.ApplicationTrackingSystem;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepo extends JpaRepository<Job,Long>{
	
	public List<Job>findByCompany(Company cc);

   public List<Job>findByCompanyAndActive(Company c,boolean Active);
	
	
}
