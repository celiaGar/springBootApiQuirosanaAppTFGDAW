package com.pruebaBBDDNew.pruebaBBDDNew.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "shopping")
@Getter
@Setter


@NoArgsConstructor
@AllArgsConstructor

public class Shopping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "promociones")
    private String promociones;

    @Column(name = "total")
    private float total;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "pagado")
    private String pagado;

    public Shopping(String promociones, float total, String userId, String pagado) {
        this.promociones = promociones;
        this.total = total;
        this.userId = userId;
        this.pagado = pagado;
    }
}
