package com.pruebaBBDDNew.pruebaBBDDNew.dto;



import com.pruebaBBDDNew.pruebaBBDDNew.entity.DateTime;
import com.pruebaBBDDNew.pruebaBBDDNew.entity.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {

    @NotBlank
    private String nombre;

    private String apellidos;

    private String direccion;

    private String email;

    private String telefono;

    private String password;

    private Boolean consentimiento;

}
