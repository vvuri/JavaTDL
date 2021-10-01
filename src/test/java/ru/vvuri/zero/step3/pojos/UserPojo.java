package ru.vvuri.zero.step3.pojos;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@Data
@JsonIgnoreProperties(ignoreUnknown = true) // не все данные серриализовывать
public class UserPojo {  // класс модели данных или Pojo класс
    private int id;
    private String email;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
}
/*
    {
    "id":1,
    "email":"george.bluth@reqres.in",
    "first_name":"George",
    "last_name":"Bluth",
    "avatar":"https://reqres.in/img/faces/1-image.jpg"}
*/