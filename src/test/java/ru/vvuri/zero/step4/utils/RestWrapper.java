package ru.vvuri.zero.step4.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.specification.RequestSpecification;
import ru.vvuri.zero.step4.pojos.UserLogin;
import ru.vvuri.zero.step4.pojos.UserPojo;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RestWrapper {
    private static final String BASE_URL = "https://reqres.in/api";
    private static RequestSpecification REQ_SPEC;
    private Cookies cookies;
    private String token;

    private RestWrapper(Cookies cookies) {
        this.cookies = cookies;

        REQ_SPEC = new RequestSpecBuilder()
                .addCookies(cookies)
                .setBaseUri(BASE_URL)
                .setBasePath("/users")
                .setContentType(ContentType.JSON)
                .build();
    }

    private RestWrapper(Cookies cookies, String token) {
        this.cookies = cookies;
        this.token = token;

        REQ_SPEC = new RequestSpecBuilder()
                .addCookies(cookies)
                .setBaseUri(BASE_URL)
                .setBasePath("/users")
                .setContentType(ContentType.JSON)
                .build();
    }


    // аналогично для токена или базовой авторизации
    public static RestWrapper loginAs(String login, String password) {
        Cookies cookies = given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .basePath("/login")
                .body(new UserLogin(login, password))
                .post()
                .getDetailedCookies();

        return new RestWrapper(cookies);
    }

    public List<UserPojo> getUsers() {
        return given()
                .spec(REQ_SPEC)
                .when().get()
                .then()
                .extract().jsonPath().getList("data", UserPojo.class);

    }

    @Override
    public String toString() {
        return "Cookies: " + this.cookies + "\nToken: " + this.token;
    }
}
