package br.dev.multicode.mcbeerscucumberrestassured.scenarios;

import static org.junit.Assert.assertEquals;

import br.dev.multicode.mcbeerscucumberrestassured.core.BaseStepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class C004DELETEBeerByIDStepDefinitions extends BaseStepDefinitions {

  private final String beerId = gePropertyByName("beerId");

  RequestSpecification request;
  @Given("^valid beerId for be deleted$")
  public void validBeerIdForBeDeleted() {
    request = RestAssured.given()
        .pathParam("beerId", beerId);
  }

  Response response;
  @When("^method DELETE with parameter beerId$")
  public void methodDELETEWithParameterBeerId() {
    response = request.delete("/{beerId}");
  }

  @Then("^DELETE a beer and return status code 204$")
  public void deleteABeerAndReturnStatusCode204() {
    final int statusCode = response.getStatusCode();
    final String bodyString = response.getBody().asString();

    assertEquals(204, statusCode);
    Assert.assertEquals("", bodyString);
  }
}
