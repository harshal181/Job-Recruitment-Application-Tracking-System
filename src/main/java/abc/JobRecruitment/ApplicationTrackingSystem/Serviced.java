package abc.JobRecruitment.ApplicationTrackingSystem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Serviced implements ServiceSum{

	@Autowired
	private DAOIMP dp;
	
	
	public Admin findbyAid(Long aid) {
		return dp.findbyAid(aid);
	}
	public Recruiter findbyRid(Long rid) {
		return dp.findbyRid(rid);
	}
	public Candidate findbyCandid(Long candid) {
		return dp.findbyCandid(candid);
	}
	@Override
	public void addAdmin(Admin a) {
		dp.AddAdmin(a);
	}
	
	public List<Company>findallcompany(){
		return dp.findallcompany();
	}
	
	public void AddRecruiter(Recruiter r) {
		dp.AddRecruiter(r);
	}

	public void AddCandidate(Candidate c) {
		dp.AddCandidate(c);
	}
	@Override
	public List<Admin> viewalladmin() {
		return dp.viewalladmin();
	}
	@Override
	public List<Recruiter> viewallrecruiter() {
		return dp.viewallrecruiter();
	}
	@Override
	public List<Candidate> viewallcandidate() {
		return dp.viewallcandidate();
	}

public boolean deleteAdmin(Long aid) {
	return dp.deleteAdmin(aid);
}
	
	public boolean deleteRecruiter(Long rid) {
		return dp.deleteRecruiter(rid);
	}
	
	public boolean deleteCandidate(Long cid) {
		return dp.deleteCandidate(cid);
	}
	
	public void addjob(Job j) {
	  dp.addjob(j);	
	}
	
	public Job findbyjid(Long jid) {
		return dp.findbyjid(jid);
	}
	
	public void deletejob(Long jid) {
		dp.deletejob(jid);
	}
	
	@Override
	public List<Job> finalljob() {
		return dp.finalljob();
	}
	
	public void addjobskill(JobSkill j) {
		dp.addjobskill(j);
	}
	

	public List<JobSkill>findByj(Job jj){
		return dp.findByj(jj);
	}

	
	public Resume findByCid(Candidate cc) {
		return dp.findByCid(cc);
	}
	

	public void addresume(Resume r) {
		dp.addresume(r);
	}
	
	public void addApplicationData(ApplicationData a) {
		dp.addApplicationData(a);
	}
	
	public List<ApplicationData>viewallapplicationdata(){
		return dp.viewallapplicationdata();
	}
	
	public List<ApplicationData>findBycid(Candidate cc){
		return dp.findBycid(cc);
	}
	
	public void addskill(Skill s) {
		dp.addskill(s);
	}
	
	public List<Skill>viewAllSkill(){
		return dp.viewAllSkill();
	}
	

	@Override
	public List<Skill> findByccid(Candidate c) {
		return dp.findByccid(c);
	}
	
	public ApplicationData findbyid(Long appid) {
		return dp.findbyid(appid);
	}
	
	public boolean chnageapplicationdatastatus(Long appid,Status s) {
		return dp.chnageapplicationdatastatus(appid, s);
	}
	
	public void addid(InterviewDetails id) {
		dp.addid(id);
	}
	
	public List<Resume>viewallresume(){
		return dp.viewallresume();
	}
	
	public List<Candidate>viewallcand(){
		return dp.viewallcand();
	}
	
	public InterviewDetails findByAp(ApplicationData ap) {
		return dp.findByAp(ap);
	}
	

	public void addcompany(Company c) {
		 dp.addcompany(c);
	}
	
	public List<Company>viewallcompany(){
		return dp.viewallcompany();
	}
	
	public Company findbyccid(Long cid) {
		return dp.findbyccid(cid);
	}
	
	public void deletecompan(Long compcid) {
		 dp.deletecompan(compcid);
	}
	
	public List<Company> findByAdmin(Admin a){
		return dp.findByAdmin(a);
	}
	
	public List<Recruiter>findByCidIn(List<Company>c){
		return dp.findByCidIn(c);
	}

	public List<Job>findByCompany(Company cc){
		return dp.findByCompany(cc);
	}
	
	public List<ApplicationData>findByJidIn(List<Job>j){
		return dp.findByJidIn(j);
	}
	
	public List<Job>findByCompanyAndActive(Company c,boolean Active){
		return dp.findByCompanyAndActive(c, Active);
	}

}
