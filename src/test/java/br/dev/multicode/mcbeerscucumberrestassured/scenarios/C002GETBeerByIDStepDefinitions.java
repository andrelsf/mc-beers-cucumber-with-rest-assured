package br.dev.multicode.mcbeerscucumberrestassured.scenarios;

import static org.junit.Assert.assertEquals;

import br.dev.multicode.mcbeerscucumberrestassured.core.BaseStepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;
import org.junit.Assert;

public class C002GETBeerByIDStepDefinitions extends BaseStepDefinitions {

  private final String beerId = gePropertyByName("beerId");

  RequestSpecification request;
  @Given("^beerId is valid$")
  public void beerIdIsValid() {
    request = RestAssured.given()
        .contentType(ContentType.JSON)
        .pathParam("beerId", beerId);
  }

  Response response;
  @When("^method GET with path parameter beerId$")
  public void methodGETWithPathParameterBeerId() {
    response = request.get("/{beerId}");
  }

  @Then("^return a beer$")
  public void returnABeer() {
    int statusCode = response.getStatusCode();
    String stringBody = response.getBody().asString();
    Map bodyMap = response.getBody().as(Map.class);
    String beerIdFromBody = bodyMap.get("id").toString();

    assertEquals(200, statusCode);
    assertEquals(beerId, beerIdFromBody);
    Assert.assertNotNull(stringBody);
  }
}
