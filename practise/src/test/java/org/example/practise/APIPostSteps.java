package org.example.practise;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;

public class APIPostSteps {
    public RequestSpecification request;
    public Response response;
    public String requestBody;
    public String endpoint;

    @Given("^the API is \"(.*)\" and the JSON request body$")
    public void APIPage(String baseURI) {
        RestAssured.baseURI = baseURI;
        JsonObject postrequest=new JsonObject();
        postrequest.add("name","Manasa");
        postrequest.add("age",30);

        //this.requestBody = "{\"name\": \"Manasa\", \"email\": \"manasa@gmail.com\"}";
        request = RestAssured.given()
                .contentType("application/json")
                .accept("application/json")
                .body(postrequest.toString());
    }

    @When("^I send a POST request on the endpoint \"(.*)\"$")
    public void sendPostRequest(String endpoint) {
        response = request.when().post(endpoint);
    }

    @Then("the response status code of POST should be {int}")
    public void verifyStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
        boolean result = response.getStatusCode() == statusCode;
        System.out.println(result);
    }

    @And("I should be able to get the response body")
    public void verifyResponseBody() {
        response.then().assertThat().
                body("name", equalTo("Manasa")).
                body("age" ,equalTo(30))
                .log().all();

        

    }
}
