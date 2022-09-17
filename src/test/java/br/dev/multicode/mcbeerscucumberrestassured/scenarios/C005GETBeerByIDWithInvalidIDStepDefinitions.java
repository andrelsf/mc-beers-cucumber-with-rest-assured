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
import java.util.UUID;
import org.junit.Assert;

public class C005GETBeerByIDWithInvalidIDStepDefinitions extends BaseStepDefinitions {

  private final String invalidBeerId = UUID.randomUUID().toString();

  RequestSpecification request;
  @Given("^invalid beerId$")
  public void given_invalidBeerId() {
    request = RestAssured.given()
        .pathParam("beerId", invalidBeerId);
  }

  Response response;
  @When("^method GET with path parameter invalid beerId$")
  public void when_methodGETWithPathParameterInvalidBeerId() {
    response = request.get("/{beerId}");
  }

  @Then("^GET a beer should fail and return beer not found by ID$")
  public void then_getABeerShouldFailAndReturnBeerNotFoundByID() {
    final int statusCode = response.getStatusCode();
    final Map body = response.getBody().as(Map.class);

    final String message = body.get("message").toString();

    assertEquals(404, statusCode);
    Assert.assertEquals("Beer not found by ID=".concat(invalidBeerId), message);
  }
}
