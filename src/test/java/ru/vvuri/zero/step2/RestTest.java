package ru.vvuri.zero.step2;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RestTest {
    @Test
    public void getUserEmails() {
//        Gson gson = new Gson();
//        UserPojo userPojo = gson.fromJson(json, UserPojo.class);

        List<UserPojo> users = given()
                .baseUri("https://reqres.in/api")
                .basePath("users")
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(200)
                .extract().jsonPath().getList("data", UserPojo.class);

        System.out.println(users);
    }

    @Test
    public void createUser() {
        CreateUserRequest req = new CreateUserRequest();
        req.setName("John");
        req.setJob("QA");

        CreateUserResponse res = given()
                .baseUri("https://reqres.in/api")
                .basePath("users")
                .contentType(ContentType.JSON)
                .body(req)
                .when().post()
                .then().extract().as(CreateUserResponse.class);

        System.out.println(res);
    }
}
