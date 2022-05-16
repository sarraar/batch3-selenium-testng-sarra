package com.eurotech.tests.day27;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentReportTest {

    //This class is used to start and build reports
    ExtentReports report;

    //This class is used to create HTMl report file
    ExtentHtmlReporter htmlReporter;

    //This class defines the test, enables adding logs, authors, test steps
    ExtentTest extentLogger;

    @BeforeMethod
    public void setUp() {

        //initialize the class
        report= new ExtentReports();

        //Create a report path
        String projectPath= System.getProperty("user.dir");
        String path= projectPath+"/test-output/report.html";

        //Initialize the HTML reporter with the report path
        htmlReporter=new ExtentHtmlReporter(path);

        //Attach the HTML report to the report object
        report.attachReporter(htmlReporter);

        //Title in report
        htmlReporter.config().setReportName("EuroTech Login Test");

        // Set environment information
        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os name"));

    }

    @AfterMethod
    public void tearDown() {
        //This is when the report is created.
        report.flush();
    }

    @Test
    public void test1(){
        extentLogger=report.createTest("TC001 Deneme Testi");

        //Test steps
        extentLogger.info("Open Chrome Browser");

        extentLogger.info("Go to eurotech.study");

        extentLogger.info("Enter Teacher Credentials");

        extentLogger.info("Click login button");

        extentLogger.info("Verify logged in");

        extentLogger.pass("TC000 is passed");


    }
}
