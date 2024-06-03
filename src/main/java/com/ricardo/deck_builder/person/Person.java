package com.ricardo.deck_builder.person;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Person {
    @Id
    private String id;

    @NotBlank
    @Indexed(unique = true)
    private String firstName;

    private String lastName;
}
