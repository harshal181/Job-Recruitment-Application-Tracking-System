package abc.JobRecruitment.ApplicationTrackingSystem;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class UpdateUserController {
	
	@Autowired
	private Serviced sd;
	
	
	
	@GetMapping("/updateAdmin")
	public String updatea(HttpSession hs) {
		
		Long aid=(Long)hs.getAttribute("a1");
		Admin aa=sd.findbyAid(aid);
		
		hs.setAttribute("at", aa);
		return "updateadmin.html";
		
		
	}
	
	@PutMapping("/updateadmin")
	public String updatad(@RequestParam("n")String name, @RequestParam("e")String email,@RequestParam("pp")String pp,@RequestParam("pn")Long pn,HttpSession hs) {
		Long aid=(Long)hs.getAttribute("a1");
		Admin a1=sd.findbyAid(aid);
		a1.setName(name);
		a1.setEmail(email);
		a1.setPassword(pp);
		a1.setPhonenum(pn);
		sd.addAdmin(a1);
		return "au.html";
	}

	
	@GetMapping("/updaterecruiter")
	public String pdaterr(HttpSession hs) {
		Long rid=(Long)hs.getAttribute("r1");
		Recruiter rr=sd.findbyRid(rid);
		List<Company>ccc=sd.findallcompany();
		hs.setAttribute("r", rr);
		hs.setAttribute("cc", ccc);
		return "updaterecruiter.html";
		
	}
	
	
	
	@PutMapping("/updaterecruiter")
	public String uurr(@RequestParam("n")String n,@RequestParam("e")String email,@RequestParam("pp")String password,
			@RequestParam("ad")String address,@RequestParam("cid")Company cid,HttpSession hs) {
		
		Long rid=(Long)hs.getAttribute("r1");
		Recruiter rrr=sd.findbyRid(rid);
		rrr.setName(n);
		rrr.setEmail(email);
		rrr.setPassword(password);
		rrr.setAddress(address);
		rrr.setCid(cid);
		sd.AddRecruiter(rrr);
		return "ur";	
	}
	
	
	@GetMapping("/updatecadidate")
	public String upca(HttpSession hs) {
	
		Long cid=(Long)hs.getAttribute("c1");
		Candidate c11=sd.findbyCandid(cid);
		hs.setAttribute("c", c11);
		return "updatecandidate.html";
	}
	
	
	
	@PutMapping("/updatecand")
	public String uc(@RequestParam("n")String n,@RequestParam("e")String e,@RequestParam("pp")String pp,@RequestParam("ed")String ed,
			@RequestParam("ad")String ad,@RequestParam("pn")Long pn,@RequestParam("dob")LocalDate dob,HttpSession hs){
		Long cid=(Long)hs.getAttribute("c1");
		Candidate c2=sd.findbyCandid(cid);
		c2.setName(n);
		c2.setEmail(e);
		c2.setPassword(pp);
		c2.setEducation(ed);
		c2.setAddress(ad);
		c2.setPhonenum(pn);
		c2.setDob(dob);
		sd.AddCandidate(c2);
		return "uc.html";
		
	}

	
}
