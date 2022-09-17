package br.dev.multicode.mcbeerscucumberrestassured.scenarios;

import static org.junit.Assert.assertEquals;

import br.dev.multicode.mcbeerscucumberrestassured.core.BaseStepDefinitions;
import br.dev.multicode.mcbeerscucumberrestassured.core.TestUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class C003PUTBeerByIDStepDefinitions extends BaseStepDefinitions {

  private final String beerId = gePropertyByName("beerId");

  RequestSpecification request;
  @Given("^an id already registered$")
  public void anIdAlreadyRegistered() {
    request = RestAssured.given()
        .pathParam("beerId", beerId)
        .body(TestUtils.updateABeer());
  }

  Response response;
  @When("^request valid with method PUT$")
  public void requestValidWithMethodPUT() {
    response = request.put("/{beerId}");
  }

  @Then("^update a beer and return status code 204$")
  public void returnABeer() {
    final int statusCode = response.getStatusCode();
    final String bodyString = response.getBody().asString();

    assertEquals(204, statusCode);
    Assert.assertEquals("", bodyString);
  }
}
