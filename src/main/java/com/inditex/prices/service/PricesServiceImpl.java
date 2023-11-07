package com.inditex.prices.service;

import com.inditex.prices.dto.PricesRequestDTO;
import com.inditex.prices.dto.PricesResponseDTO;
import com.inditex.prices.model.PricesModel;
import com.inditex.prices.repository.PricesRepository;
import com.inditex.prices.util.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PricesServiceImpl implements PricesService {


    private final PricesRepository pricesRepository;

    private final Utils utils;

    @Override
    public PricesResponseDTO obtenerPrecios(PricesRequestDTO pricesRequestDTO) {
        var priceModel = PricesModel.builder().build();
        var lista = pricesRepository.buscarTodosPorFechaMarcaProducto(utils.stringToTimeStamp(pricesRequestDTO.getFechaAplicacion()), pricesRequestDTO.getIdentificadorCadena(), pricesRequestDTO.getIdentificadorProducto());

        if (lista.size() >= 2)
            priceModel = obtenerPrecioPorPrioridad(lista);
        else
            priceModel = lista.get(0);

        return utils.wrapperPricesModelToPricesResponseDTO(priceModel);
    }

    private PricesModel obtenerPrecioPorPrioridad(List<PricesModel> lista) {
        lista.sort(Comparator.comparing(PricesModel::getPriority).reversed());
        return lista.get(0);
    }



}
