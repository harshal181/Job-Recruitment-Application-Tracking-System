package abc.JobRecruitment.ApplicationTrackingSystem;

import java.util.List;

public interface DAOSum {

	public Admin findbyAid(Long aid);
	public Recruiter findbyRid(Long rid);
	public Candidate findbyCandid(Long candid);
	
	public void AddAdmin(Admin a);
	
	public void AddRecruiter(Recruiter r);
	
	public void AddCandidate(Candidate c);
	
	public List<Admin>viewalladmin();
	public List<Recruiter>viewallrecruiter();
	public List<Candidate>viewallcandidate();
	public List<Company>findallcompany();
	
	public boolean deleteAdmin(Long aid);
	
	public boolean deleteRecruiter(Long rid);
	
	public boolean deleteCandidate(Long cid);
	
	public void addjob(Job j);
	public Job findbyjid(Long jid);
	public List<Job>finalljob();
	public void deletejob(Long jid);
	
	public List<Candidate>viewallcand();
	
	public void addjobskill(JobSkill j);
	public Resume findByCid(Candidate cc);
	
	public void addresume(Resume r);
	
	public void addApplicationData(ApplicationData a);
	
	public List<ApplicationData>viewallapplicationdata();
	
	public List<ApplicationData>findBycid(Candidate cc);
	
	public List<JobSkill>findByj(Job jj);
	
	public void addskill(Skill s);
	
	public List<Skill>viewAllSkill();
	
	public List<Skill>findByccid(Candidate c);
	
	public ApplicationData findbyid(Long appid);
	
	public boolean chnageapplicationdatastatus(Long appid,Status s);
	
	public void addid(InterviewDetails id);
	
	public List<Resume>viewallresume();
	
	public InterviewDetails findByAp(ApplicationData ap);

	public void addcompany(Company c);
	
	public List<Company>viewallcompany();
	
	public Company findbyccid(Long cid);
	
	public void deletecompan(Long compcid);
	
	public List<Company> findByAdmin(Admin a);
	
	public List<Recruiter>findByCidIn(List<Company>c);
	
	public List<Job>findByCompany(Company cc);
	
	public List<ApplicationData>findByJidIn(List<Job>j);
	

	public List<Job>findByCompanyAndActive(Company c,boolean Active);
	
	
}

