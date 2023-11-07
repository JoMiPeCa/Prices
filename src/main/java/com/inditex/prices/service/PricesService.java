package com.inditex.prices.service;

import com.inditex.prices.dto.PricesRequestDTO;
import com.inditex.prices.dto.PricesResponseDTO;

public interface PricesService {

    /**
     * Permite obtener los precios según la fecha seleccionada
     *
     * @param pricesRequestDTO Datos del producto.
     * @return precios asociados al producto.
     *
     */
    PricesResponseDTO obtenerPrecios(PricesRequestDTO pricesRequestDTO);
}
