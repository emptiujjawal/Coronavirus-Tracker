package com.emptiujjawal.coronavirus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.emptiujjawal.coronavirus.models.LocationStats;
import com.emptiujjawal.coronavirus.service.CoronavirusDataService;

@Controller
public class HomeController {
	
	@Autowired
	CoronavirusDataService coronavirusDataService;
	
	@GetMapping("/")
	public String home(Model model) {
		List<LocationStats> alstats= coronavirusDataService.getAllStats();
		int totalcases= alstats.stream().mapToInt(i-> i.getLatestTotalCases()).sum();
		model.addAttribute("locationStats", coronavirusDataService.getAllStats());
		model.addAttribute("total", totalcases);
		
		return "home";
	}

}
