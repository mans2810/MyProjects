package org.example.firstgradleproject;

import io.restassured.http.ContentType;
//import org.junit.Test;
import io.restassured.RestAssured;
import org.junit.jupiter.api.*;

public class demo {

    @Test
    public void test(){
RestAssured.baseURI="https://reqres.in/api/users?page=2";

RestAssured.given().contentType(ContentType.JSON).
        when().get().then().statusCode(200)
        .log().all();

    }
}

