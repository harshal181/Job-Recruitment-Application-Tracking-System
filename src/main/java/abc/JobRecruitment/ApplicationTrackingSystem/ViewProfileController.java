package abc.JobRecruitment.ApplicationTrackingSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class ViewProfileController {
	
	@Autowired
	private Serviced sd;
	
	
	@GetMapping("/viewprofileforadmin")
	public String datababb(HttpSession hs)	{
		Long aid=(Long)hs.getAttribute("a1");
	
		Admin a=sd.findbyAid(aid);
		hs.setAttribute("ad", a);
		return "viewprofileforadmin.html";
		
		
	}
	
	@GetMapping("/viewprofileforrecruiter")
	public String ddrecru(HttpSession hs) {
		Long rid=(Long)hs.getAttribute("r1");
		Recruiter rr=sd.findbyRid(rid);
		hs.setAttribute("r", rr);
		return "viewprofileforrecrecruiter.html";
		
	}
	
	@GetMapping("/viewprofileforcandidate")
	public String ddcandd(HttpSession hs) {
		
		Long candid=(Long)hs.getAttribute("c1");
		Candidate cc=sd.findbyCandid(candid);
          hs.setAttribute("c", cc);
          return "viewprofileforcandidate.html";
	
	}

}
