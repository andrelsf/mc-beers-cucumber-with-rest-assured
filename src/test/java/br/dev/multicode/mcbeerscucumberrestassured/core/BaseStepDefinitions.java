package br.dev.multicode.mcbeerscucumberrestassured.core;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.hamcrest.Matchers;

public abstract class BaseStepDefinitions {

  public static final String CONFIG_PROPERTIES = "./src/test/resources/config.properties";
  public static RequestSpecification requestSpecification;
  public static ResponseSpecification responseSpecification;

  protected Properties properties;

  public BaseStepDefinitions() {
    loadProperties();
    RestAssured.baseURI = properties.getProperty("rest-assured.baseUrl");
    RestAssured.basePath = properties.getProperty("rest-assured.basePath");
    RestAssured.port = Integer.parseInt(properties.getProperty("rest-assured.port"));

    final Long maxTimeout = Long.parseLong(properties.getProperty("rest-assured.maxTimeout"));

    requestSpecification = new RequestSpecBuilder()
        .setAccept(ContentType.JSON)
        .setContentType(ContentType.JSON)
        .build();

    responseSpecification = new ResponseSpecBuilder()
        .expectResponseTime(Matchers.lessThan(maxTimeout))
        .build();

    RestAssured.requestSpecification = requestSpecification;
    RestAssured.responseSpecification = responseSpecification;

    RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
  }

  private void loadProperties() {
    properties = new Properties();
    try (FileInputStream file = new FileInputStream(CONFIG_PROPERTIES)) {
      properties.load(file);
    } catch (IOException exception) {
      throw new RuntimeException(exception.getMessage());
    }
  }

  public static void setEnvVariable(String variable) {
    try {
      PropertiesConfiguration config = new PropertiesConfiguration(CONFIG_PROPERTIES);
      config.setProperty("beerId", variable);
      config.save();
    } catch (Exception exception) {
      throw new RuntimeException(exception.getMessage());
    }
  }

  protected String gePropertyByName(final String propertyName) {
    return properties.getProperty(propertyName);
  }
}
