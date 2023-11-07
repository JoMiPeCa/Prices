package com.inditex.prices.util;

import com.inditex.prices.dto.PricesResponseDTO;
import com.inditex.prices.model.PricesModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Component
public class Utils {

    String EMPTY = "";

    public Timestamp stringToTimeStamp(String date) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date parsedDate = dateFormat.parse(date);
            timestamp = new Timestamp(parsedDate.getTime());
        } catch (Exception e) {
            log.error("Hubo un error en la conversion de String a Timestamp... Se retorna valor actual. Mensaje: [{}]", e.getMessage());
        }
        return timestamp;
    }

    public int toInt(String string) {
        try {
            return (Integer.parseInt(string));
        } catch (NumberFormatException error) {
            return (Integer.MIN_VALUE);
        }
    }

    public PricesResponseDTO wrapperPricesModelToPricesResponseDTO(PricesModel model) {
        return PricesResponseDTO.builder()
                .identificadorProducto(null == model.getProductId() ? 0 : model.getProductId())
                .identificadorCadena(null == model.getBrandId() ? 0 : model.getBrandId())
                .tarifaAaplicar("CAMPO NO MAPEADO")
                .fechaAplicacionInicial(null == model.getStartDate() ? new Timestamp(System.currentTimeMillis()) : model.getStartDate())
                .fechaAplicacionFinal(null == model.getEndDate() ? new Timestamp(System.currentTimeMillis()) : model.getEndDate())
                .precioFinal(null == model.getPrice() ? 0 : model.getPrice())
                .build();
    }
}
