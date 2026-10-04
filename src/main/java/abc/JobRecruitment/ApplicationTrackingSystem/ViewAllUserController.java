package abc.JobRecruitment.ApplicationTrackingSystem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class ViewAllUserController {
	
	@Autowired
	private Serviced ss;
	
	@GetMapping("/viewallusers")
	public String viewalluserss(HttpSession hhs) {
		
		List<Admin>a1=ss.viewalladmin();
		List<Recruiter>r1=ss.viewallrecruiter();
		List<Candidate>c1=ss.viewallcandidate();
		
		hhs.setAttribute("a", a1);
		hhs.setAttribute("r", r1);
		hhs.setAttribute("c", c1);
		return "viewallusers.html";
	}

}
