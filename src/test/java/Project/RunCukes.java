package Project;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources"} ,
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
        tags = {"@price"} )


public class RunCukes {



    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File("src/extent-config.xml"));

    }
}










