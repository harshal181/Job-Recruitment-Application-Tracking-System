package abc.JobRecruitment.ApplicationTrackingSystem;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class LogoutController {
	
	@GetMapping("/logout")
	public String loggout(HttpSession hs) {
		hs.invalidate();
		return "logout.html";
	}

}
