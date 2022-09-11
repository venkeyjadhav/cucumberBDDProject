package TestRunner;
//import org.junit.runner.RunWith;
import io.cucumber.testng.CucumberOptions;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
//@RunWith(Cucumber.class)
@CucumberOptions(
		//features = ".//Features/LoginFeature.feature", 
		features = ".//Features/",
        glue = "StepDefination",
        dryRun = false,
       // tags="@Sanity",
        monochrome = true,
        
        //for testng plugin
        //plugin = {"pretty","html:target/reportconf.html"}
	
        //for extentreport plugin
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		//"junit:target/report_xml.xml","json:target/report_json.json"
        )

public class Run extends AbstractTestNGCucumberTests{

}
