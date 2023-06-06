package com.pruebaBBDDNew.pruebaBBDDNew.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "date_time")
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
public class DateTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    @Column(name = "user_id")
    private String userId;


    public DateTime(String date, String time, String userId) {
        this.date = date;
        this.time = time;
        this.userId = userId;
    }
}
