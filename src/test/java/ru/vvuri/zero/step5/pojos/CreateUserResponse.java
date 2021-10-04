package ru.vvuri.zero.step5.pojos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import ru.vvuri.zero.step3.utils.DateDeserializer;

import java.time.LocalDateTime;

@Data
public class CreateUserResponse extends UserRequest{
    private int id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'hh:mm:ss.SSSZ")
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime createdAt;
}
