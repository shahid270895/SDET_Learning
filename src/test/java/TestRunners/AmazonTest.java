package TestRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	     features={"src/test/java/AmazonApplicationFeatures"},
	     glue={"StepDefinitions"},
	     tags=""
		 )

public class AmazonTest extends AbstractTestNGCucumberTests{
	
	

}
