package com.nuhs.gcto.controller;

import java.lang.invoke.MethodHandles;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nuhs.gcto.dao.IssueDAO;
import com.nuhs.gcto.dao.ResultResponseDAO;
import com.nuhs.gcto.model.Dashboard;
import com.nuhs.gcto.model.Issue;
import com.nuhs.gcto.model.ResultResponse;
import com.nuhs.gcto.model.User;
import com.nuhs.gcto.model.UserSignup;
import com.nuhs.gcto.service.DashboardService;
import com.nuhs.gcto.service.PatientService;
import com.nuhs.gcto.service.UserService;

@Controller
public class WebController {
	final static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@RequestMapping(value="/",method = RequestMethod.GET)
	public String home(Model model){
		logger.debug("Home");
//		ResultResponse response = new ResultResponse();
//		response.setResult_id(1);
//		response.setAdid("test");
//		response.setPredictor("readm");
//		response.setResultResponse("yes");
//		Calendar calendar = Calendar.getInstance();
//		java.util.Date now = calendar.getTime();
//		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
//		response.setDtResponded(currentTimestamp);
//		ResultResponseDAO.addResultResponse(response);
		model = PatientService.simulateLoadPatient(model);
		return "patient_card";
//				User user = new User();
//				model.addAttribute("user", user);		
//				return "login";
	}

	@PostMapping("/login_post")
	public String loginSubmit(Model model, @ModelAttribute User user) {
		//TODO login logic, session management
		Dashboard dashboard = DashboardService.prepareDashBoard();
		model.addAttribute("dashboard", dashboard);		
		return "index";
	}

	@PostMapping("/signup")
	public String signup(Model model) {
		logger.debug("Signup");
		UserSignup userSignup = new UserSignup(); 
		model.addAttribute("userSignup", userSignup);	
		return "signup";
	}

	@PostMapping("/signup_token")
	public String signupSubmitToken(Model model) {
		logger.debug("New sign up token");
		UserSignup userSignupToken = new UserSignup();
		model.addAttribute("userSignupToken", userSignupToken);
		return "signup_token";
	}

	@PostMapping("/signup_post")
	public String signupSubmit(Model model, @ModelAttribute UserSignup userSignup) {
		logger.debug("New sign up post");
		UserSignup userSignupToken = UserService.handleNewSignUp(userSignup);
		UserSignup userSignupTokenADID = new UserSignup();
		userSignupTokenADID.setAdid(userSignupToken.getAdid());
		model.addAttribute("userSignupToken", userSignupTokenADID);
		return "signup_token";
	}

	@PostMapping("/invalidate")
	public String destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}


	// Dashboard
	@RequestMapping(value="/index.html",method = RequestMethod.GET)
	public String index(Model model){
		Dashboard dashboard = DashboardService.prepareDashBoard();
		model.addAttribute("dashboard", dashboard);		
		return "index";
	}

	@RequestMapping(value="/add_issue",method = RequestMethod.GET)
	public String addIssue(Model model){
		model.addAttribute("issue", new Issue());
		return "issue_new";
	}

	@PostMapping("/add_issue_post")
	public String issueCreate(Model model, @ModelAttribute Issue issue) {
		Integer issueID = IssueDAO.addIssue(issue);
		logger.debug("issueID = {}", issueID.toString());
		List issues = IssueDAO.getAllIssues();
		logger.debug("issues = {}", issues.size());
		model.addAttribute("issues", issues);
		return "issue_list";
	}

	@RequestMapping(value="/find_issue",method = RequestMethod.GET)
	public String findIssue(Model model){
		List issues = IssueDAO.getAllIssues();
		model.addAllAttributes(issues);
		return "issue_new";
	}

	@RequestMapping(value="/all_issues",method = RequestMethod.GET)
	public String allIssues(Model model){
		List issues = IssueDAO.getAllIssues();
		logger.debug("issues = {}", issues.size());
		model.addAttribute("issues", issues);
		return "issue_list";
	}

	@RequestMapping(value="/construction",method = RequestMethod.GET)
	public String construction(Model model){
		return "construction";
	}
}