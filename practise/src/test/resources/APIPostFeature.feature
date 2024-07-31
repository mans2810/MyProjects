Feature: API Testing for POST Method

  Scenario Outline: POST method to create user data
    Given the API is "https://reqres.in/" and the JSON request body
    When I send a POST request on the endpoint "api/users"
    Then the response status code of POST should be <Status code>
    And I should be able to get the response body

    Examples:
      | Status code |
      | 201         |

