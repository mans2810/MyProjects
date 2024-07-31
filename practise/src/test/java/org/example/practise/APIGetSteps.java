package org.example.practise;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.assertThat;

public class APIGetSteps {
    public Response response;

    @Given("^the API endpoint is (.*)$")
    public void theAPIEndpointIs(String arg0) {
        RestAssured.baseURI="https://reqres.in/api/users/2";
    }

    @When("I send a GET request")
    public void iSendAGETRequest() {
        RestAssured.given().when().get();
        
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int arg0) {
        this.response=RestAssured.given().when().get();
        response.then().statusCode(arg0).log().all();

    }
}
