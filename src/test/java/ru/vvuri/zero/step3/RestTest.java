package ru.vvuri.zero.step3;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import ru.vvuri.zero.step3.pojos.CreateUserRequest;
import ru.vvuri.zero.step3.pojos.CreateUserResponse;
import ru.vvuri.zero.step3.pojos.UserPojo;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RestTest {
    private static final RequestSpecification REQ_SPEC = new RequestSpecBuilder()
            .setBaseUri("https://reqres.in/api")
            .setBasePath("/users")
            .setContentType(ContentType.JSON)
            .build();

    @Test
    public void getUserClass() {
        List<UserPojo> users = given()
                .spec(REQ_SPEC)
                .when().get()
                .then()
                .extract().jsonPath().getList("data", UserPojo.class);

        System.out.println(users);
    }

    @Test
    public void createUser() {
        CreateUserRequest req = new CreateUserRequest();
        req.setName("John");
        req.setJob("QA");

        CreateUserResponse res = given()
                .spec(REQ_SPEC)
                .body(req)
                .when().post()
                .then().extract().as(CreateUserResponse.class);

        System.out.println(res);
    }
}
