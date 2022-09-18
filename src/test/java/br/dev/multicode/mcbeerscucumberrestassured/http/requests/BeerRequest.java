package br.dev.multicode.mcbeerscucumberrestassured.http.requests;

import java.math.BigDecimal;

public class BeerRequest {

  private String name;
  private Double alcoholContent;
  private String ingredients;
  private BigDecimal price;

  public BeerRequest() {
  }

  public BeerRequest(String name, Double alcoholContent, String ingredients, BigDecimal price) {
    this.name = name;
    this.alcoholContent = alcoholContent;
    this.ingredients = ingredients;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getAlcoholContent() {
    return alcoholContent;
  }

  public void setAlcoholContent(Double alcoholContent) {
    this.alcoholContent = alcoholContent;
  }

  public String getIngredients() {
    return ingredients;
  }

  public void setIngredients(String ingredients) {
    this.ingredients = ingredients;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }
}
