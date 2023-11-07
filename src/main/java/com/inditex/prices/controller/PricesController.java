package com.inditex.prices.controller;

import com.inditex.prices.dto.PricesRequestDTO;
import com.inditex.prices.dto.PricesResponseDTO;
import com.inditex.prices.service.PricesService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PricesController {

    private final PricesService pricesService;

    /**
     *
     * Consulta de precio final y tarifa aplicable
     *
     * @param pricesRequestDTO Datos del producto.
     * @return precios asociados al producto.
     */
    @Operation(summary = "Consulta de precios a partir de una fecha")
    @PostMapping(value = "/obtenerPrecio", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PricesResponseDTO obtenerPrecio(@Valid @RequestBody PricesRequestDTO pricesRequestDTO) {
        return pricesService.obtenerPrecios(pricesRequestDTO);
    }

}
