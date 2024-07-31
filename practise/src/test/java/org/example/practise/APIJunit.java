package org.example.practise;

import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

public class APIJunit {

    @Test
    public void test() {
       RestAssured.baseURI="https://reqres.in/";

       RestAssured.given().contentType("application/json")
               .when().get("api/users/2").then()
               .statusCode(200).log().all();


    }
}
