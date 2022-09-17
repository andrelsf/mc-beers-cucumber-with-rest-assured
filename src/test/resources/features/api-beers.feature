Feature: Beers API Testing

  Scenario: C001: POST Create a new beer
    Given Request is valid
    When Request with method POST
    Then a beer will be generated

  Scenario: C002: GET Beer by ID
    Given beerId is valid
    When method GET with path parameter beerId
    Then return a beer

  Scenario: C003: PUT Beer by ID
    Given an id already registered
    When request valid with method PUT
    Then update a beer and return status code 204

  Scenario: C004: DELETE Beer by ID
    Given valid beerId for be deleted
    When method DELETE with parameter beerId
    Then DELETE a beer and return status code 204

  Scenario: C005: Should Fail GET Beer With Invalid ID
    Given invalid beerId
    When method GET with path parameter invalid beerId
    Then GET a beer should fail and return beer not found by ID

  Scenario: C006: Should fail POST without body
    Given request with empty body
    When POST method with empty body
    Then POST a beer should fail and return 400 Bad Request

  Scenario: C007: Should fail POST with null object attributes
    Given request with body but null object attributes
    When POST method request with body but null object attributes
    Then POST a beer should fail, return 400 and message with fails