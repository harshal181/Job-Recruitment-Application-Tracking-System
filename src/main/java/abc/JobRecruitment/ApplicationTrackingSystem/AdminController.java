package abc.JobRecruitment.ApplicationTrackingSystem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
	
	@Autowired
	private Serviced ss;
	
	
	@GetMapping("/Admindashoard")
	public String addashboard() {
		return "admindashboard.html";
	}
	
	@GetMapping("/addcompanyy")
	public String addco(HttpSession hs) {
	
		
        return "addcompany.html";	
	}

	
	
	
	@PostMapping("/createcompany")
	public String cdc(@RequestParam("cn")String cn,@RequestParam("e")String e,
			@RequestParam("ad")String address,@RequestParam("w")String w,@RequestParam("d")String d,
			HttpSession hs) {
		
		Long aid=(Long)hs.getAttribute("a1");
		Admin a1=ss.findbyAid(aid);
		Company c=new Company(cn,e,address,w,d,a1);
		ss.addcompany(c);
		return "companyaddedsuccessfully.html";
	}

	@GetMapping("/viewallcompany")
	public String viewallcompany(HttpSession hs) {
		
		Long aid=(Long)hs.getAttribute("a1");
		Admin a=ss.findbyAid(aid);
		List<Company>cc=ss.findByAdmin(a);
		if(cc.isEmpty()==true) {
			return "nocompany.html";
		}
		else {
		
		hs.setAttribute("ccc", cc);
		return "adminviewallcompany.html";
		}
		
	}
	
	

	@GetMapping("/updatecomp")
	public String abcc(@RequestParam("cid")Long cid,HttpSession hs) {
	
		Company c=ss.findbyccid(cid);
		List<Admin>aa=ss.viewalladmin();
		hs.setAttribute("cc", c);
		hs.setAttribute("a", aa);
		return "updatecoppp.html";
		
	}
	

	
	
@PutMapping("/updatecompp")
public String uppcomp(@RequestParam("cid")Long cid,@RequestParam("cn")String cn,@RequestParam("ee")String ee,@RequestParam("ad")String address,
		@RequestParam("w")String w,@RequestParam("d")String d, @RequestParam("aid")Long aid) {
	
	Company c=ss.findbyccid(cid);
	Admin addd=ss.findbyAid(aid);
	c.setCname(cn);
	c.setEmail(ee);
	c.setAddress(address);
	c.setWebsite(w);
	c.setDescription(d);
	c.setAdmin(addd);
	ss.addcompany(c);
	
	return "updatedcompanysucc.html";
	
}

@DeleteMapping("/deletecomp")
public String deletecoomp(@RequestParam("cid")Long cid) {
	
	Company cc=ss.findbyccid(cid);
	
	
	if(cc.isActive()==true) {
	ss.deletecompan(cid);
	return "deletecompant.html";
	}
	return "checkcompanyactive.html";
	
}





@DeleteMapping("/deleteadmin")
public String ddad(@RequestParam("aid")Long aid) {
	
	boolean abc=ss.deleteAdmin(aid);
	if(abc==true) {
		return "admindeleted.html";
	}
	return "adminisnotactive.html";
	
	
}

@DeleteMapping("/deleterecruiter")
public String dlrec(@RequestParam("rrid")Long rrid) {
	boolean xyz=ss.deleteRecruiter(rrid);
	if(xyz==true) {
	return "recruiterdeleted.html";
	}
	return "recruiternotaqctive.html";
}





@DeleteMapping("/deletecandidate")
public String wxy(@RequestParam("cid")Long cid) {
	boolean task=ss.deleteCandidate(cid);
	if(task==true) {
	return "candidatedeleted.html";
	}
	return "candididisnotactive.html";
}


@GetMapping("/viewallrecruiter")
public String viewallrr(HttpSession hs) {
	
	Long aid=(Long)hs.getAttribute("a1");
	Admin a=ss.findbyAid(aid);
	
	List<Company>companies=ss.findByAdmin(a);
	
	List<Recruiter>rrs=ss.findByCidIn(companies);
	if(rrs.isEmpty()) {
		return "norecruiter.html";
	}
	else {
	hs.setAttribute("r2",rrs);
	return "adminviewallrecruiter.html";
	}
	
}
	
}
