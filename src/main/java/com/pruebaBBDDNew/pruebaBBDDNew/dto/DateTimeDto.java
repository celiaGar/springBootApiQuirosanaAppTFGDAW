package com.pruebaBBDDNew.pruebaBBDDNew.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pruebaBBDDNew.pruebaBBDDNew.entity.DateTime;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DateTimeDto {

   // @NotBlank
    @JsonProperty("date")
    private String date;

    @JsonProperty("time")
    private String time;

    @JsonProperty("userId")
    private String userId;

    private DateTime dateTime;


}
