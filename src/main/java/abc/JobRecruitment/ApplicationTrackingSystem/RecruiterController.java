package abc.JobRecruitment.ApplicationTrackingSystem;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class RecruiterController {
	
	@Autowired
	private Serviced ss;
	
	
	@GetMapping("/Recrruiterdashboard")
	public String rrdashboard() {
		return "recruiterdashboard.html";
	}
	
	

	

	
	@PostMapping("/addjobskills")
	public String addjskills(@RequestParam("jsl")String jsl,@RequestParam("jid") Job jid) {
		JobSkill j3=new JobSkill(jsl,jid);
		ss.addjobskill(j3);
		return "jobskilladded.html";
		
	}
	
	
	@GetMapping("/createjobs")
	public String ccjob(HttpSession hs) {

		Long rid=(Long)hs.getAttribute("r1");
		Recruiter r=ss.findbyRid(rid);
		Company cc=r.getCid();
		hs.setAttribute("c", cc);
		return "addjob.html";
	}

	@PostMapping("/addjob")
	public String abcc(@RequestParam("jt")String jt,@RequestParam("l")String loc,@RequestParam("s")double sal,
			@RequestParam("er")String er,@RequestParam("jtt")JOBType jtt,@RequestParam("pd")LocalDate pd,HttpSession hs) {
		Company c=(Company)hs.getAttribute("c");
		Job j1=new Job(jt,loc,sal,er,jtt,pd,c);
		j1.setActive(true);
		ss.addjob(j1);
		return "jobadded.html";
		
		
	}
	
	@GetMapping("/viewmycompanies")
	public String abbbbcc(HttpSession hs) {
	
		Long rid=(Long)hs.getAttribute("r1");
		Recruiter r=ss.findbyRid(rid);
		
		Company cc=r.getCid();
	
		
		hs.setAttribute("c", cc);
		return "recruitercompanies.html";
	}
	

	@GetMapping("/createjobskill")
	public String ccc(HttpSession hs) {
		Long rid=(Long)hs.getAttribute("r1");
		Recruiter r=ss.findbyRid(rid);
		

		Company cc=r.getCid();
		List<Job>js=ss.findByCompany(cc);
		hs.setAttribute("jj", js);
		return "addjobskill.html";
	}

	    
	   @PostMapping("/addfeddback")
	   public String addsdata(@RequestParam("apid")Long apid,@RequestParam("s")String s,@RequestParam("fd")String fd) {
		
		   
		   ApplicationData appd=ss.findbyid(apid);
		  InterviewDetails id=ss.findByAp(appd);
		  if(id.getFeedback().equalsIgnoreCase("-") || id.getFeedback().equalsIgnoreCase("No")) {
		  id.setStatus(s);
		  id.setFeedback(fd);
		  ss.addid(id);
		  return "idfeedbackadded.html";
		  }
		  return "alreadyfeedbackadded.html";
	   }
	   
	   
	
	
	
	@GetMapping("/viewalljobforrecruiter")
	public String viewalljobsforr(HttpSession hs) {
		Long rid=(Long)hs.getAttribute("r1");
		Recruiter rr=ss.findbyRid(rid);
		Company c=rr.getCid();
		
		List<Job>jj=ss.findByCompany(c);
		
		if(jj.isEmpty()) {
			return "recnojob.html";
		}
		
		hs.setAttribute("j1", jj);
		return "viewalljobforrecruiters.html";
	}
	
	@PostMapping("/deletejobs")
	public String deletejob(@RequestParam("jid")Long jid) {

		Job jj=ss.findbyjid(jid);
		if(jj.isActive()==true) {
		ss.deletejob(jid);
		return "jobdeleted.html";
		}
		
		return "jobalreadydeleted.html";
	}
	
	
	@GetMapping("/viewallllapplicationdata")
	public String viewaallappdetails(HttpSession hs){
		Long rid=(Long)hs.getAttribute("r1");
		Recruiter rr=ss.findbyRid(rid);
		Company c=rr.getCid();
		List<Job>jj=ss.findByCompany(c);
		List<ApplicationData>apd=ss.findByJidIn(jj);
	
		if(apd.isEmpty()==true) {
			return "recnoapplidata.html";
		}
		
		hs.setAttribute("appd", apd);
		return "recviewallapplicationdatadetails.html";
	}
	
	@GetMapping("/viewallapplicationdata")
	public String viewallappl(HttpSession hs) {
		Long rid=(Long)hs.getAttribute("r1");
		Recruiter rr=ss.findbyRid(rid);
		Company c=rr.getCid();
		List<Job>jj=ss.findByCompany(c);
		List<ApplicationData>apd=ss.findByJidIn(jj);
		
			
		
		
		if(apd.isEmpty()==true) {
			return "recnoapplidata.html";
		}
		
		hs.setAttribute("ap", apd);
		hs.setAttribute("stl", Status.values());
		return "Recruiterforviewallapplicationdata.html";
		
	}
	
	@PostMapping("/updatestatus")
	public String updatestatuss(@RequestParam("appid")Long appid,@RequestParam("s")Status s) {
		boolean res=ss.chnageapplicationdatastatus(appid, s);
			
		ApplicationData addd=ss.findbyid(appid);
		
		Job j=addd.getJid();
		
		if(j.isActive()==false) {
			return "jobinactive.html";
		}
		
		
		
		if(res==true) {
		return "applicationdatastatuschanged.html";
		}
		else {
			return "statusnotchanged";
		}
		
	}
	
	

	
	@PostMapping("/createinterviewschedule")
	public String www(@RequestParam("apid")Long appid,@RequestParam("id")LocalDate id,@RequestParam("it")LocalTime it,@RequestParam("r")String r,
    @RequestParam("m")String mode,@RequestParam("ml")String ml,@RequestParam("s")String s,@RequestParam("fd")String fd,@RequestParam("apid")ApplicationData apid) {
	
		ApplicationData appddd=ss.findbyid(appid);
	
		Job j=appddd.getJid();
		
		if(j.isActive()==false) {
			return "jobinactive.html";
		}
		
		if(appddd.getStatus()==Status.InterviewSchedule) {
		InterviewDetails idd=new InterviewDetails(id,it,r,mode,ml,s,fd,apid);
		ss.addid(idd);
		return "interviewdetailsadde.html";
		}
		return "checkapplicationstatus.html";
	}
	
	
	@PostMapping("/updateinterviewschedule")
	public String wwww(@RequestParam("apid")Long appid,@RequestParam("id")LocalDate id,@RequestParam("it")LocalTime it,@RequestParam("r")String r,
		    @RequestParam("m")String mode,@RequestParam("ml")String ml,@RequestParam("s")String s,@RequestParam("fd")String fd,@RequestParam("apid")ApplicationData apid) {
	
		ApplicationData ap=ss.findbyid(appid);
		
		
		if(ap.getStatus()==Status.InterviewSchedule) {
			InterviewDetails idd=ss.findByAp(ap);
			idd.setAp(ap);
			idd.setInterviewdate(id);
			idd.setInterviewTime(it);
			idd.setRound(r);
			idd.setMode(mode);
			idd.setMeetinglink(ml);
			idd.setStatus(s);
			idd.setFeedback(fd);
			ss.addid(idd);
			return "interviredetailsupdated.html";
		}
		
		return "checkapplicationstatus.html";
		
			
		}
	

		
	
	@GetMapping("/viewappliedcandidatedetails")
	public String viewallcd(HttpSession hs) {
		Long rid=(Long)hs.getAttribute("r1");
		Recruiter rr=ss.findbyRid(rid);
		Company c=rr.getCid();
		List<Job>jj=ss.findByCompany(c);
		List<ApplicationData>apd=ss.findByJidIn(jj);
		
		if(apd.isEmpty()==true) {
			return "noappliedcandidatedeta.html";
		}
		
         hs.setAttribute("ar", apd);
		return "viewappliedcandidatedetails.html";
		
		
	}
	

			
			
 @GetMapping("/viewresume")
 public String viewappliedcandresu(@RequestParam("candid")Long cid, HttpSession hs)
 {
	 Candidate c=ss.findbyCandid(cid);
	 Resume r=ss.findByCid(c);
	
	 hs.setAttribute("rr", r);
	 return "viewcandresume.html";
 }
 @GetMapping("/openresume")
 public ResponseEntity<byte[]> openresume(@RequestParam("candid") Long cid) throws IOException {

     Candidate c = ss.findbyCandid(cid);
     Resume r = ss.findByCid(c);

     File file = new File("D:\\cjc\\" + r.getResumename());

     byte[] data = Files.readAllBytes(file.toPath());

     String name = r.getResumename().toLowerCase();

     MediaType type;

     if (name.endsWith(".pdf")) {
         type = MediaType.APPLICATION_PDF;
     }
     else if (name.endsWith(".doc")) {
         type = MediaType.parseMediaType("application/msword");
     }
     else if (name.endsWith(".docx")) {
         type = MediaType.parseMediaType(
                 "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
     }
     else {
         type = MediaType.APPLICATION_OCTET_STREAM;
     }

     return ResponseEntity.ok()
             .contentType(type)
             .body(data);
 }
 
 @GetMapping("/viewskills")
 public String vvskills(@RequestParam("candid")Long candid, HttpSession hs) {
	 Candidate c=ss.findbyCandid(candid);
	 List<Skill>sl=ss.findByccid(c);
	 hs.setAttribute("sll", sl);
	 return "viewcandidateskills.html";
 }
 
}
