package br.dev.multicode.mcbeerscucumberrestassured.core;

import br.dev.multicode.mcbeerscucumberrestassured.http.responses.ErrorResponse;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestUtils {

  public static Map<String, Object> createANewBeer() {
    Map<String, Object> beer = new HashMap<>();
    beer.put("name", "Beer Test " + System.nanoTime());
    beer.put("alcoholContent", 5.5);
    beer.put("ingredients", "Wheat and orange peel");
    beer.put("price", 11.90);
    return beer;
  }

  public static Map<String, Object> createAInvalidBeer() {
    Map<String, Object> beer = new HashMap<>();
    beer.put("name", null);
    beer.put("alcoholContent", null);
    beer.put("ingredients", null);
    beer.put("price", null);
    return beer;
  }

  public static Map<String, Object> updateABeer() {
    Map<String, Object> beer = new HashMap<>();
    beer.put("name", "Beer Updated " + System.nanoTime());
    beer.put("alcoholContent", 7.0);
    beer.put("ingredients", "Barley and wheat hops");
    beer.put("price", 19.90);
    return beer;
  }

  public static List<ErrorResponse> getErrorResponsesFromTestNullObjectAttributes() {
    final int code = 400;
    final ErrorResponse errorResponseAlcoholContent = new ErrorResponse(code, "'alcoholContent' não deve ser nulo");
    final ErrorResponse errorResponseIngredients = new ErrorResponse(code, "'ingredients' não deve estar em branco");
    final ErrorResponse errorResponseName = new ErrorResponse(code, "'name' não deve estar em branco");
    final ErrorResponse errorResponsePrice = new ErrorResponse(code, "'price' não deve ser nulo");
    return List.of(errorResponseAlcoholContent, errorResponseIngredients, errorResponseName, errorResponsePrice);
  }
}
