package com.inditex.prices.repository;

import com.inditex.prices.model.PricesModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class PricesRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<PricesModel> buscarTodosPorFechaMarcaProducto(Timestamp fecha, int marca, int producto) {
        List<PricesModel> pricesModel = new ArrayList<>();
        pricesModel.add(PricesModel.builder().build());
        try {
            return jdbcTemplate.query("SELECT p.BRAND_ID, p.START_DATE, p.END_DATE, p.PRICE_LIST, p.PRODUCT_ID, p.PRIORITY, p.PRICE, p.CURR FROM PRICES p " +
                            "WHERE START_DATE <= ? AND END_DATE > ? AND BRAND_ID = ? AND PRODUCT_ID = ?",new Object[] { fecha, fecha, marca, producto },
                    new BeanPropertyRowMapper<>(PricesModel.class));
        } catch (Exception e) {
            log.error("Ocurrió un error en el llamado a la BD. Se devolverá una lista vacia. El mensaje es: [{}]", e.getMessage());
        }
        return pricesModel;
    }


}
