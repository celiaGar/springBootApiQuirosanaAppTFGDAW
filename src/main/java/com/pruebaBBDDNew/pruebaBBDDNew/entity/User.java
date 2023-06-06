package com.pruebaBBDDNew.pruebaBBDDNew.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
/*
* @JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "date"
)
* */
@NoArgsConstructor
@AllArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "email")
    private String email;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "password")
    private String password;

    @Column(name = "consentimiento")
    private Boolean consentimiento;



    public User(String nombre, String apellidos, String email, String direccion, String telefono, String password, Boolean consentimiento ) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
        this.password = password;
        this.consentimiento = consentimiento;
    }


}
