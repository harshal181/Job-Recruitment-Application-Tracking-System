package abc.JobRecruitment.ApplicationTrackingSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@Autowired
	private Serviced ss;
	
	
	@GetMapping("/loginall")
	public String alll() {
		return "loginall.html";
	}
	
	@GetMapping("/adminllogin")
	public String adminLogin() {
		return "adminlogin.html";
	}
	
	@GetMapping("/adminLogin")
	public String adminll(@RequestParam("aid")Long aid,@RequestParam("pp")String password,HttpSession hs) {
		
		if(aid==null ||password==null || password.trim().isEmpty()) {
			return "aidnotfound.html";
		}
		
		Admin a=ss.findbyAid(aid);
		
		if(a==null) {
			return "aidnotfound.html";
		}
		
		
		else if(a.isActive()==false) {
			return "aidnotfound.html";
		}
	
		
		else if(password.equals(a.getPassword())) {
			hs.setAttribute("a1", a.getAid());
				return "admindashboard.html";
			}
		return "aidnotfound.html";
		}
	
	@GetMapping("/recruiterllogin")
	public String recruiterlll() {
		return "recruiterlogin.html";
	}
	
	@GetMapping("/recruiterLogin")
	public String recriterll(@RequestParam("rrid")Long rid,@RequestParam("pp")String password,HttpSession hs) {
		
		if(rid==null || password==null || password.trim().isEmpty()) {
			return "ridnotfound.html";
		}
		
		Recruiter r=ss.findbyRid(rid);
		
		if(r==null) {
			return "ridnotfound.html";
		}
		
	
		else if(r.isActive()==false) {
			return "ridnotfound.html";
		}
		
		else if(password.equals(r.getPassword())) {
			hs.setAttribute("r1", r.getRrid());
				return "recruiterdashboard.html";
			}
		return "ridnotfound.html";
		}
	
	
	@GetMapping("/candidatelogin")
	public String lll() {
		return "candidatelogin.html";
	}
	
	
	@GetMapping("/candidatellogin")
	public String canddiadtelogin(@RequestParam("cid")Long candid,@RequestParam("pp")String pp,HttpSession hs) {
		
		Candidate c=ss.findbyCandid(candid);
		
		if(c==null) {
			return "candidnotfound.html";
		}
		else if(c.isActive()==false) {
			return "candidnotfound.html";
		}
		
		else if(pp.equals(c.getPassword())) {
			hs.setAttribute("c1", c.getCandid());
			return "candidatedashboard.html";
		}
		
		return "candidnotfound.html";
	}
		
		
	}

