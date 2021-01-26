package com.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentManager {

	private static ExtentReports extent;

	    public static ExtentReports createInstance(String fileName) {
	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
	       
	        
	        htmlReporter.config().setTheme(Theme.DARK);
	        htmlReporter.config().setDocumentTitle(fileName);
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName(fileName);
	        
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        extent.setSystemInfo("Build no", "V5.2.1");
	        extent.setSystemInfo("Automation Tester", "Alex Joseph");
	        extent.setSystemInfo("Organization", "MetaWeather Pvt. Ltd.");
	        
	        return extent;
	    }

	}
