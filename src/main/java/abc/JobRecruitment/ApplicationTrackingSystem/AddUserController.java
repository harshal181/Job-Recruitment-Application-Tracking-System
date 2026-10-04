package abc.JobRecruitment.ApplicationTrackingSystem;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class AddUserController {
	
	@Autowired
	private ServiceSum ss;
	
	@GetMapping("/addadmin")
	public String registeruu() {
		return "registeradmin.html";
	}
	
	
	@PostMapping("/addadmin")
	public String registeruuu(@RequestParam("n")String n,@RequestParam("ee")String email,@RequestParam("pp")String pp,@RequestParam("pn")Long pn ,HttpSession hs) {
		Admin a1=new Admin(n,email,pp,pn);
		a1.setActive(true);
		ss.addAdmin(a1);
		hs.setAttribute("a2", a1);
		return "redirect:/getaid";
	}
		
	
	@GetMapping("/getaid")
	public String getaid(HttpSession hs) {
		Admin aaa=(Admin)hs.getAttribute("a2");
		Long aid=aaa.getAid();
		String pp=aaa.getPassword();
		hs.setAttribute("a4", aid);
		hs.setAttribute("ppp", pp);
		return "getaid.html";
	}
	
	
	@GetMapping("/addrecruiter")
	public String registerrr(HttpSession hs) {
		List<Company>c=ss.findallcompany();
		hs.setAttribute("cc", c);
		return "registerrecruiter";
	}
	
	

	
	@PostMapping("/addrecruiter")
	public String registerrr(@RequestParam("n")String n,@RequestParam("ee")String email,@RequestParam("pp")String pp,@RequestParam("ad")String address,@RequestParam("cid")Company cid,HttpSession hs) {
	 Recruiter r1=new Recruiter(n,email,pp,address,cid);
	 r1.setActive(true);
		ss.AddRecruiter(r1);
		hs.setAttribute("r3", r1);
		 return "redirect:/getrrid";
	}
	
	
	@GetMapping("/getrrid")
	public String getrrid(HttpSession hs) {
		Recruiter rrrr=(Recruiter)hs.getAttribute("r3");
		Long rrid=rrrr.getRrid();
		String ppp=rrrr.getPassword();
		hs.setAttribute("rrid",rrid);
		hs.setAttribute("ppp", ppp);
		return "getrrid.html";
	}
	
	@GetMapping("/addcandidate")
	public String addc() {
		return "registercandidate.html";
	}



	@PostMapping("/registercandidate")
	public String registercandiadtee(@RequestParam("n")String nn,@RequestParam("e")String email,@RequestParam("pp")String pp,
			@RequestParam("ed")String ed,@RequestParam("ad")String ad,@RequestParam("pn")Long pn,@RequestParam("dob")LocalDate dob,HttpSession hs){
		Candidate c1=new Candidate(nn,email,pp,ed,ad,pn,dob);
		c1.setActive(true);
		ss.AddCandidate(c1);
		hs.setAttribute("c4", c1);
		return "redirect:/getdata";
	}
	
	@GetMapping("/getdata")
	public String getdata(HttpSession hs) {
		Candidate c2=(Candidate)hs.getAttribute("c4");
		Long candid=c2.getCandid();
		String ppp=c2.getPassword();
		hs.setAttribute("cccc", candid);
		hs.setAttribute("pass", ppp);
		return "getcandid.html";
	}
	
}
	
