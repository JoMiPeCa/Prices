package com.inditex.prices.dto;

import lombok.*;

import java.sql.Timestamp;

@Data
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PricesResponseDTO {

    private Integer identificadorProducto;
    private Integer identificadorCadena;
    private String tarifaAaplicar;
    private Timestamp fechaAplicacionInicial;
    private Timestamp fechaAplicacionFinal;
    private Double precioFinal;
    //Podria indicar un codigo de error.... En caso de no tener data....

}
