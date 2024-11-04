package net.practice.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class userDTO {


    private Long id;
    private String Nombres;
    private String Apellidos;
    private String email;

}
