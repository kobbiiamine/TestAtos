package org.testatos1.entity;



import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String userName;

    @NotNull
    @Past
    private LocalDate birthdate;

    @NotBlank
    private String countryOfResidence;

    private String phoneNumber;

    private String gender;

}

