package com.inditex.prices.dto;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PricesRequestDTO {

    private String fechaAplicacion;
    private Integer identificadorProducto;
    private Integer identificadorCadena;

}
