package ru.vvuri.zero.step1;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestTest {

    @Test
    public void getUser() {
        String rs = given()
                .baseUri("https://reqres.in/api")
                .basePath("users/2")
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract().asString();
        System.out.println(rs);
    }

    @Test
    public void getUsers() {
        given()
                .baseUri("https://reqres.in/api")
                .basePath("users")
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(200)
                .body("data[0].email", equalTo("george.bluth@reqres.in")) // GPath описание метода
                .and()
                .body("data.find{it.email=='george.bluth@reqres.in'}.first_name", equalTo("George"));
    }

    @Test
    public void getUserEmails() {
        List<String> emails = given()
                .baseUri("https://reqres.in/api")
                .basePath("users")
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract().jsonPath().getList("data.email");

        System.out.println(emails);
    }


}
