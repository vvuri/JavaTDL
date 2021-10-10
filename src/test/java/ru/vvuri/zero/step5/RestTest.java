package ru.vvuri.zero.step5;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
//import org.apache.log4j.BasicConfigurator;
//import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ru.vvuri.zero.step5.pojos.UserRequest;
import ru.vvuri.zero.step5.pojos.CreateUserResponse;
import ru.vvuri.zero.step5.pojos.UserPojo;
import ru.vvuri.zero.step5.utils.RestWrapper;

import java.util.List;

public class RestTest {
    private static RestWrapper api;

//    @BeforeSuite
//    public void initLog4j() {
//        BasicConfigurator.configure();
//        String log4jConfPath = "./src/test/java/ru/vvuri/zero/step5/log4j.properties";
//        PropertyConfigurator.configure(log4jConfPath);
//    }

    @BeforeClass
    public static void auth() {
        api = RestWrapper.loginAs("eve.holt@reqres.in", "cityslicka");
        System.out.println(api.toString());
    }

    private static final RequestSpecification REQ_SPEC = new RequestSpecBuilder()
            .setBaseUri("https://reqres.in/api")
            .setBasePath("/users")
            .setContentType(ContentType.JSON)
            .build();

    @Test
    public void getUsersAuth() {
        System.out.println(api.getUsers());
    }


    @Test
    public void getUserClass() {
        List<UserPojo> users = api.user.getUsers();
        System.out.println(users);
    }

    @Test
    public void createUser() {
        UserRequest req = UserRequest
                .builder()
                .name("John")
                .job("QA")
                .build();

        CreateUserResponse res = api.user.createUser(req);
        System.out.println(res);
    }
}

/*
Есть две концепции реализации степов в проекте
1. Создать статические методы заросов, которые будут возвращать пользователей и другие данные
   Все объединяем в разбитые на группы классы - и в тестах просто вызываем без инициализации классов.

2. Через Wrapper дополнительный класс и наследование

Использование паттерна @Builder - упрощает механизм доступа к свойствам класса через цепочку
@Builder - убирает дефолтный конструкто - поэтому необходимо еще добавить
@NoArgsConstructor @AllArgsConstructor
*/