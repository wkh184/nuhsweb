package com.nuhs.gcto.service;

import java.util.List;

import com.nuhs.gcto.dao.IssueDAO;
import com.nuhs.gcto.model.Dashboard;

public class DashboardService {
	static public Dashboard prepareDashBoard() {
		Dashboard dashboard = new Dashboard();
		dashboard.setIssueCount(100);
		dashboard.setIdeaCount(200);
		dashboard.setInnovationCount(300);
		dashboard.setIndustryCount(100);
		List issues = IssueDAO.getTopIssues(5);
		dashboard.setIssues(issues);
		return dashboard;		
	}
}
