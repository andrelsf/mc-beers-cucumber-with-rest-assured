package br.dev.multicode.mcbeerscucumberrestassured.scenarios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import br.dev.multicode.mcbeerscucumberrestassured.core.BaseStepDefinitions;
import br.dev.multicode.mcbeerscucumberrestassured.core.TestUtils;
import br.dev.multicode.mcbeerscucumberrestassured.http.responses.ErrorResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.List;
import java.util.stream.Collectors;

public class C007ShouldFailPOSTWithNullObjectAttributesStepDefinitions extends BaseStepDefinitions {

  RequestSpecification request;
  @Given("^request with body but null object attributes$")
  public void given_requestWithBodyButNullObjectAttributes() {
    request = RestAssured.given()
        .body(TestUtils.createAInvalidBeer());
  }

  Response response;
  @When("^POST method request with body but null object attributes$")
  public void when_POSTMethodRequestWithBodyButNullObjectAttributes() {
    response = request.post();
  }

  @Then("^POST a beer should fail, return 400 and message with fails$")
  public void then_POSTABeerShouldFailReturn400AndMessageWithFails() {
    final int statusCode = response.getStatusCode();
    final List<ErrorResponse> responseList = JsonPath.from(response.getBody().asString())
        .getList("$", ErrorResponse.class);

    assertEquals(400, statusCode);
    assertFalse(responseList.isEmpty());
    assertEquals(4, responseList.size());

    final List<String> errorMessages = responseList.stream()
        .map(ErrorResponse::getMessage)
        .collect(Collectors.toList());

    assertTrue(errorMessages.contains("'alcoholContent' não deve ser nulo"));
    assertTrue(errorMessages.contains("'ingredients' não deve estar em branco"));
    assertTrue(errorMessages.contains("'name' não deve estar em branco"));
    assertTrue(errorMessages.contains("'price' não deve ser nulo"));
  }
}
