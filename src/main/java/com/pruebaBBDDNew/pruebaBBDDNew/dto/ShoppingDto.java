package com.pruebaBBDDNew.pruebaBBDDNew.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.pruebaBBDDNew.pruebaBBDDNew.entity.Shopping;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ShoppingDto {


    // @NotBlank
    @JsonProperty("promociones")
    private String promociones;

    @JsonProperty("total")
    private float total;

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("pagado")
    private String pagado;

    private Shopping shopping;

}
