package br.dev.multicode.mcbeerscucumberrestassured.scenarios;

import static org.junit.Assert.assertEquals;

import br.dev.multicode.mcbeerscucumberrestassured.core.BaseStepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;
import org.junit.Assert;

public class C006ShouldFailPOSTWithoutBodyStepDefinitions extends BaseStepDefinitions {

  RequestSpecification request;
  @Given("^request with empty body$")
  public void given_requestWithEmptyBody() {
    request = RestAssured.given();
  }

  Response response;
  @When("^POST method with empty body$")
  public void when_POSTMethodWithEmptyBody() {
    response = request.post();
  }

  @Then("^POST a beer should fail and return 400 Bad Request$")
  public void then_POSTABeerShouldFailAndReturn400BadRequest() {
    final int statusCode = response.getStatusCode();
    final Map body = response.getBody().as(Map.class);

    final String message = body.get("message").toString();

    assertEquals(400, statusCode);
    Assert.assertEquals("Bad Request", message);
  }
}
