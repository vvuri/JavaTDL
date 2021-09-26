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

    @Test
    public void getPlanets() {
        String local = "planets/";

        given()
                .when()
                .get(URL+local)
                .then()
                .log().body()
                .statusCode(200);

    }

    // https://swapi.dev/api/people/?search=r2

    // films string -- The URL root for Film resources
    // people string -- The URL root for People resources
    // planets string -- The URL root for Planet resources
    // species string -- The URL root for Species resources
    // starships string -- The URL root for Starships resources
    // vehicles string -- The URL root for Vehicles resources


}
