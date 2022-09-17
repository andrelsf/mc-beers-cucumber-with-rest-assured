package br.dev.multicode.mcbeerscucumberrestassured.http.responses;

import java.math.BigDecimal;
import java.util.Objects;

public class BeerResponse {

  private String id;
  private String name;
  private Double alcoholContent;
  private String ingredients;
  private BigDecimal price;

  public BeerResponse() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  @Override
  public String toString() {
    return "BeerResponse{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", alcoholContent=" + alcoholContent +
        ", ingredients='" + ingredients + '\'' +
        ", price=" + price +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BeerResponse that = (BeerResponse) o;
    return Objects.equals(id, that.id) && Objects.equals(name, that.name)
        && Objects.equals(alcoholContent, that.alcoholContent) && Objects.equals(
        ingredients, that.ingredients) && Objects.equals(price, that.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, alcoholContent, ingredients, price);
  }
}