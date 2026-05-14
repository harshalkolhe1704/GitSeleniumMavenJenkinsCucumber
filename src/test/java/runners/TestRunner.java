package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/Features/GoogleSearch.feature"}
,glue = "stepDefinition",
monochrome = true,
dryRun = false,
plugin = {"pretty","html:target\\HtmlReport.html"})

public class TestRunner extends AbstractTestNGCucumberTests {

}
