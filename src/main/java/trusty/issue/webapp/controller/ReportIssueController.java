package trusty.issue.webapp.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import trusty.issue.persistence.domain.Issue;
import trusty.issue.service.api.ServiceFacade;
import trusty.issue.webapp.model.Data;
import trusty.issue.webapp.model.IssueData;

@Controller
@RequestMapping("/issue")
public class ReportIssueController {

	@Autowired
	ServiceFacade services;
	
	@Autowired
	Data data;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleReportIssue(@RequestParam("steam_id") String steamId) {
		services.checkUser(steamId);
		ModelAndView model = new ModelAndView("ReportIssue", "command", new IssueData());
		model.addObject("steamId", steamId);
		model.addObject("types", data.getTypes());
		return model;
	}
	
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	@ResponseBody
	public String addIssue(@ModelAttribute("SpringWeb") Issue issue) {
		Date now = new Date();
		issue.setId(services.getEntryCount());
		issue.setAssignee("STEAM_0:0:8054565");
		issue.setCreateDate(now);
		issue.setUpdateDate(now);
		issue.setPriority(0);
		issue.setStatus(0);
		services.addIssue(issue);
		return "Your report has been submitted.";
	}
}
