package br.dev.multicode.mcbeerscucumberrestassured;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {
    "pretty",
    "html:target/cucumber-reports/cucumber.html",
    "json:target/cucumber-reports/cucumber.json"
},
    features = "classpath:features")
public class RunCucumberTest {

}
