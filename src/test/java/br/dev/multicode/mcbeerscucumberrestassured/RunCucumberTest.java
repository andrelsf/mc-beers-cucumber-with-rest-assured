package br.dev.multicode.mcbeerscucumberrestassured;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
  plugin = {
    "pretty",
    "html:target/cucumber-reports/cucumber.html",
    "json:target/cucumber-reports/cucumber.json",
    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
  },
  features = "classpath:features")
public class RunCucumberTest {

}
