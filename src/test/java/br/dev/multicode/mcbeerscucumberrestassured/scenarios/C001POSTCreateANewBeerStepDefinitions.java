package br.dev.multicode.mcbeerscucumberrestassured.scenarios;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import br.dev.multicode.mcbeerscucumberrestassured.core.BaseStepDefinitions;
import br.dev.multicode.mcbeerscucumberrestassured.core.TestUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class C001POSTCreateANewBeerStepDefinitions extends BaseStepDefinitions {

  RequestSpecification request;
  @Given("^Request is valid$")
  public void request_on_resources_with_method_POST() {
    request = given()
        .body(TestUtils.createANewBeer());
  }

  Response response;
  @When("^Request with method POST$")
  public void request_is_valid() {
    response = request.post();
  }

  @Then("^a beer will be generated$")
  public void a_beer_will_be_generated() {
    int statusCode = response.getStatusCode();

    assertEquals(201, statusCode);
    assertNotNull(response.getHeader("resourceId"));

    final String beerId = response.getHeader("resourceId");
    BaseStepDefinitions.setEnvVariable(beerId);
  }
}
