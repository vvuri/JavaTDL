package ru.vvuri.zero.step2;

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
