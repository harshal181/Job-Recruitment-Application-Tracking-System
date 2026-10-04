package abc.JobRecruitment.ApplicationTrackingSystem;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company,Long> {
	
	public List<Company> findByAdmin(Admin a);
	
	

}
