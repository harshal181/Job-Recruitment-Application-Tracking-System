package abc.JobRecruitment.ApplicationTrackingSystem;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;

@Controller
public class CandidateController {
	
	@Autowired
	private Serviced sd;
	
	

	@GetMapping("/Candidatedashboardd")
	public String cddashboard() {
		return "candidatedashboard.html";
	}
	
	@GetMapping("/ViewAllJob")
		public String viewalljj(HttpSession hs) {
		List<Job>jj=sd.finalljob();
		
		hs.setAttribute("j1", jj);
		return "viewalljobs.html";
		
		}
	
		
	@GetMapping("/addresume")
	public String addresu() {
		return "addresume.html";
	}
	
	@PostMapping("/uploadresume")
	public String uuresume(@RequestParam("resume")MultipartFile rr,HttpSession hs) throws IllegalStateException, IOException {
	
		
		Long candid=(Long)hs.getAttribute("c1");
		Candidate c2=sd.findbyCandid(candid);
		
		Resume r=sd.findByCid(c2);
		
		if(r==null) {
		r=new Resume();
		r.setCid(c2);
		r.setResumename(rr.getOriginalFilename());
		r.setUploadeddate(LocalDate.now());
		
		String path="D:\\cjc\\";
		File f1=new File(path);
		
		if(!f1.exists()) {
			f1.mkdir();
		}
		rr.transferTo(new File(path+rr.getOriginalFilename()));
		sd.addresume(r);
	    return "resumeadded.html";	
	}
		else {
			return "alreadyaddedresume.html";
		}
	
	}

	
	@GetMapping("/updateresume")
	public String  updaterusmee(HttpSession hs) {
		Long cid=(Long)hs.getAttribute("c1");
		Candidate c=sd.findbyCandid(cid);
		Resume r=sd.findByCid(c);
		hs.setAttribute("rr", r);
	  return "updatedresume.html";
	}
	
	@PostMapping("/updatedresume")
	public String updatedrusu(@RequestParam("ur")MultipartFile ur ,HttpSession hs) throws IllegalStateException, IOException {
		Long cid=(Long)hs.getAttribute("c1");
		Candidate c=sd.findbyCandid(cid);
		Resume r=sd.findByCid(c);
		r.setResumename(ur.getOriginalFilename());
		r.setUploadeddate(LocalDate.now());
		String path="D:\\cjc\\";
		
		File f1=new File(path);
		
		if(!f1.exists()) {
			f1.mkdir();
		}
		
		ur.transferTo(new File(path+ur.getOriginalFilename()));
		sd.addresume(r);
		return "resumeupted.html";
		
	}
	
	@PostMapping("/applyjob")
	public String appliyjobb(@RequestParam("jid")Long jid,@RequestParam("cr")String cl,HttpSession hs) {
		
		Long cc=(Long)hs.getAttribute("c1");
		Candidate ccc=sd.findbyCandid(cc);
		
		ApplicationData a1=new ApplicationData();
		
		Job jj=sd.findbyjid(jid);
		if(jj.isActive()==true) {
		a1.setCid(ccc);
		a1.setJid(jj);
		a1.setStatus(Status.Applied);
		a1.setApplieddate(LocalDate.now());
		a1.setCoverletter(cl);
		sd.addApplicationData(a1);
		return "applicationdatasaved.html";
		}
		
		return "checkjobactiveornot.html";
		
	}
	
	@GetMapping("/viewmyappliedjobs")
	public String viewapjobs(HttpSession hs) {
		Long cid=(Long)hs.getAttribute("c1");
		Candidate cc=sd.findbyCandid(cid);
			List<ApplicationData>apd=sd.findBycid(cc);
			hs.setAttribute("ap", apd);
			return "viewcandidateappliedjobs.html";
		
	}
	
	@GetMapping("/viewinterviewdetails")
	public String viewid(@RequestParam("apid")Long apid, HttpSession hs) {
		ApplicationData ap=sd.findbyid(apid);
		InterviewDetails is=sd.findByAp(ap);
		if(is!=null) {
		hs.setAttribute("iss", is);
		return "candviewinterviewdetails.html";
		}
		return "candnotinterviewdetails.html";
		
	}
	
	
	@GetMapping("/addskill")
	public String addskill() {
		return "addskill.html";
	}


    @PostMapping("/addskilll")
    public String adddskill(@RequestParam("sn")String sn,@RequestParam("sl")String sl,HttpSession hs) {
    	Long cid=(Long)hs.getAttribute("c1");
    	Candidate c=sd.findbyCandid(cid);
    	
    	Skill s=new Skill(sn,sl,c);
    	sd.addskill(s);
    	return "skilladded.html";
    }
    
    @GetMapping("/viewallskill")
    public String viewallskill(HttpSession hs) {
    	Long cid=(Long)hs.getAttribute("c1");
    	Candidate cc=sd.findbyCandid(cid);
    	List<Skill>sss=sd.findByccid(cc);
    	hs.setAttribute("ss", sss);
    	return "viewallskill.html";
    	
    }
    
    @GetMapping("/viewallapplicationcanddetails")
    public String abbc(HttpSession hs) {
        List<ApplicationData>apd=sd.viewallapplicationdata();
        hs.setAttribute("apps", apd);
        return "viewallapplicationcandidatedetails.html";
    	
    }
	
}
