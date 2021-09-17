package ru.vvuri.swapi;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/*
    https://swapi.dev/
*/

public class TestRest {
    private final String URL = "https://swapi.dev/api/";

    @Test
    public void getOnePerson() {
        String local = "people/1/";

        given()
                .when()
                .get(URL+local)
                .then()
                .log().body()
                .statusCode(200)
                .body("name", equalTo("Luke Skywalker"));
    }

}
