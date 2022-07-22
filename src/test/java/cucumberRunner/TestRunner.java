package cucumberRunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",glue= "stepDefinitions",
                  plugin= {"html:target/Cucumber.html",
		                    "json:target/Cucumber.json",
		                     "rerun:target/failedScenarios.txt"},  
                monochrome= true)

public class TestRunner {

	
	
}

