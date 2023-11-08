package com.inditex.prices.mock

import com.inditex.prices.dto.PricesResponseDTO
import com.inditex.prices.model.PricesModel
import com.inditex.prices.util.Utils

import java.sql.Timestamp
import java.text.SimpleDateFormat

class Mock {

    static List<PricesModel> obtenerListaBD(int caso) {
        List<PricesModel> lista = new ArrayList<>()

        if (caso == 0) {
            lista.add(nuevoModelo(1,'2020-06-14 00:00:00','2020-12-31 23:59:59',1,35455,0,35.5,'EUR'))
        }

        if (caso == 1) {
            lista.add(nuevoModelo(1,'2020-06-14 00:00:00','2020-12-31 23:59:59',1,35455,0,35.5,'EUR'))
            lista.add(nuevoModelo(1,'2020-06-14 15:00:00','2020-06-14 18:30:00',2,35455,1,25.45,'EUR'))
        }

        if (caso == 2) {
            lista.add(nuevoModelo(1,'2020-06-14 00:00:00','2020-12-31 23:59:59',1,35455,0,35.5,'EUR'))
        }

        if (caso == 3) {
            lista.add(nuevoModelo(1,'2020-06-14 00:00:00','2020-12-31 23:59:59',1,35455,0,35.5,'EUR'))
            lista.add(nuevoModelo(1,'2020-06-15 00:00:00','2020-06-15 11:00:00',3,35455,1,30.5,'EUR'))
        }

        if (caso == 4) {
            lista.add(nuevoModelo(1,'2020-06-14 00:00:00','2020-12-31 23:59:59',1,35455,0,35.5,'EUR'))
            lista.add(nuevoModelo(1,'2020-06-15 16:00:00','2020-12-31 23:59:59',4,35455,1,38.95,'EUR'))
        }

        return lista
    }

    static PricesModel nuevoModelo(int marca, String fechaInicial, String fechaFinal, int precioLista, int idProducto, int prioridad, double precio, String currency) {
        return PricesModel.builder()
                .brandId(marca)
                .startDate(stringTimestamp(fechaInicial))
                .endDate(stringTimestamp(fechaFinal))
                .priceList(precioLista)
                .productId(idProducto)
                .priority(prioridad)
                .price(precio)
                .currency(currency)
                .build()
    }

    static stringTimestamp(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date parsedDate = dateFormat.parse(date);
        return new Timestamp(parsedDate.getTime());
    }

    static wrapperPricesModelToPricesResponseDTO(PricesModel model) {
        return PricesResponseDTO.builder()
                .identificadorProducto(null == model.getProductId() ? 0 : model.getProductId())
                .identificadorCadena(null == model.getBrandId() ? 0 : model.getBrandId())
                .tarifaAaplicar("CAMPO NO MAPEADO")
                .fechaAplicacionInicial(null == model.getStartDate() ? new Timestamp(System.currentTimeMillis()) : model.getStartDate())
                .fechaAplicacionFinal(null == model.getEndDate() ? new Timestamp(System.currentTimeMillis()) : model.getEndDate())
                .precioFinal(null == model.getPrice() ? 0 : model.getPrice())
                .build()
    }

}
