Feature: API Testing for GET Method

  Scenario: Get a list of users
    Given the API endpoint is "https://reqres.in/api/users/2"
    When I send a GET request
    Then the response status code should be 200
