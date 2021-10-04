package ru.vvuri.zero.step5.services;

import io.restassured.http.Cookies;
import ru.vvuri.zero.step5.pojos.UserRequest;
import ru.vvuri.zero.step5.pojos.CreateUserResponse;
import ru.vvuri.zero.step5.pojos.UserPojo;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserService extends RestService{

    @Override
    protected String getBasePath() {
        return "/users";
    }

    public UserService(Cookies cookies) {
        super(cookies);
    }

    public CreateUserResponse createUser(UserRequest req) {
         return given()
                .spec(REQ_SPEC)
                .body(req)
                .when().post()
                .then().extract().as(CreateUserResponse.class);
    }

    public List<UserPojo> getUsers() {
        return given()
                .spec(REQ_SPEC)
                .when().get()
                .then()
                .extract().jsonPath().getList("data", UserPojo.class);
    }

}
