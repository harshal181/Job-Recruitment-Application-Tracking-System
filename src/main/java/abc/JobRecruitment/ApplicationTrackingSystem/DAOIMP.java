package abc.JobRecruitment.ApplicationTrackingSystem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public class DAOIMP implements DAOSum{
	
	@Autowired
	private AdminRepo ar;
	
	@Autowired
	private RecruiterRepo rr;
	
	@Autowired
	private CandidateRepo cr;
	
	@Autowired
	private CompanyRepo cmpr;
	
	@Autowired
	private JobRepo jr;

	@Override
	public Admin findbyAid(Long aid) {
		return ar.findById(aid).orElse(null);
		
	}

	@Override
	public Recruiter findbyRid(Long rid) {
		return rr.findById(rid).orElse(null);
		
	}
	
	
	public Company findbyccid(Long cid) {
		return cmpr.findById(cid).orElse(null);
	}
	
	public void deletecompan(Long compcid) {
	 Company cd=cmpr.findById(compcid).orElse(null);
	 cd.setActive(false);
	 cmpr.save(cd);
	 
	  
	}
	
	public void addcompany(Company c) {
		cmpr.save(c);
	}

	
	public List<Company>viewallcompany(){
		return cmpr.findAll();
	}
	
	public List<Company> findByAdmin(Admin a){
		return cmpr.findByAdmin(a);
	}
	
	
	@Override
	public Candidate findbyCandid(Long candidi) {
		return cr.findById(candidi).orElse(null);
		
	}
	public List<Candidate>viewallcand(){
	  return cr.findAll();	
	}
	
	
	@Override
	public void AddAdmin(Admin a) {
		ar.save(a);
	}

	@Override
	public List<Company> findallcompany() {
		return cmpr.findAll();
	}
	
	

	
	public void AddRecruiter(Recruiter r) {
		rr.save(r);
	}
	public List<Recruiter>findByCidIn(List<Company>c){
		return rr.findByCidIn(c);
	}
	
	
	public void AddCandidate(Candidate c) {
	cr.save(c);
	}


	@Override
	public List<Admin> viewalladmin() {
		return ar.findAll();
	}

	@Override
	public List<Recruiter> viewallrecruiter() {
		return rr.findAll();
	}

	

	
	@Override
	public List<Candidate> viewallcandidate() {
		return cr.findAll();
	}

	@Override
	public boolean deleteAdmin(Long aid) {
		
		Admin a=ar.findById(aid).orElse(null);
		if(a.isActive()==true) {
			a.setActive(false);
			ar.save(a);
			return true;
		}
		return false;
		
	}

	@Override
	public boolean deleteRecruiter(Long rid) {
		Recruiter r=rr.findById(rid).orElse(null);
		if(r.isActive()==true) {
			r.setActive(false);
			rr.save(r);
			return true;
		}
		return false;
		
	}

	@Override
	public boolean deleteCandidate(Long cid) {
		
		Candidate c=cr.findById(cid).orElse(null);
		if(c.isActive()==true) {
		   c.setActive(false);
		   cr.save(c);
			return true;
		}
		else {
			return false;
		}
	}
	
	
	//job
	
	public void addjob(Job j) {
		jr.save(j);
	}

	public Job findbyjid(Long jid) {
		return jr.findById(jid).orElse(null);
	}
	
	public List<Job>findByCompany(Company cc){
		return jr.findByCompany(cc);
	}

	
	@Override
	public List<Job> finalljob() {
	return jr.findAll();
	}
	
	public List<Job>findByCompanyAndActive(Company c,boolean Active){
		return jr.findByCompanyAndActive(c, Active);
	}
	
	
	@Autowired
	private ResumeRepo r2;
	
	public Resume findByCid(Candidate cc) {
		return r2.findByCid(cc);
	}
	

	public void addresume(Resume r) {
		r2.save(r);
	}
	
	public List<Resume>viewallresume(){
		return r2.findAll();
	}
	
	
	//jobskill
	
	@Autowired
	private JobSkillRepo jr4;
	
	public void addjobskill(JobSkill j) {
		jr4.save(j);
	}
	
	public List<JobSkill>findByj(Job jj){
		return jr4.findByj(jj);
	}


	
	@Autowired
	private ApplicationDataRepo ar3;
	
	public void addApplicationData(ApplicationData a) {
		ar3.save(a);
	}
	
	public ApplicationData findbyid(Long appid) {
		return ar3.findById(appid).orElse(null);
	}
	public List<ApplicationData>viewallapplicationdata(){
		return ar3.findAll();
	}
	
	public List<ApplicationData>findByJidIn(List<Job>j){
		return ar3.findByJidIn(j);
	}
	
	public boolean chnageapplicationdatastatus(Long appid,Status s) {
		ApplicationData ad=ar3.findById(appid).orElse(null);
		
		if(ad.getStatus()==s) {
			return false;
		}
		
		else if(ad.getStatus()==Status.Selected || ad.getStatus()==Status.Rejected) {
			return false;
		}
		
		
			ad.setStatus(s);
			ar3.save(ad);
		return true;
	
		
		
	}
	
	public List<ApplicationData>findBycid(Candidate cc){
		return ar3.findBycid(cc);
	}
	
	@Autowired
	private InterViewDetailsRepo ir;
	
	@Transactional
	public void deletejob(Long jid) {
		if(jr.existsById(jid)) {
			
			//ir.deleteByAp_Jid_Jid(jid);
			//ar3.deleteByJid_Jid(jid);
			//jr4.deleteByJ_Jid(jid);
			//jr.deleteById(jid);
			
			Job j=jr.findById(jid).orElse(null);
		     j.setActive(false);
		     jr.save(j);
			
		}
	}
	
	public InterviewDetails findByAp(ApplicationData ap) {
		return ir.findByAp(ap);
	}
	
	@Autowired
	private SkillRepo sr;
	
	public void addskill(Skill s) {
		sr.save(s);
	}
	
	public List<Skill>viewAllSkill(){
		return sr.findAll();
	}
	
	public List<Skill>findByccid(Candidate c){
		return sr.findBycid(c);
	}
	
	@Autowired
	private InterViewDetailsRepo idd;
	
	public void addid(InterviewDetails id) {
		idd.save(id);
	}

	
}
