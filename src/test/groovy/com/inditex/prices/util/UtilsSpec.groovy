package com.inditex.prices.util

import com.inditex.prices.mock.Mock
import spock.lang.See
import spock.lang.Specification
import spock.lang.Unroll

import java.sql.Timestamp

class UtilsSpec extends Specification {

    private Utils utils

    void setup() {
        utils = new Utils()
    }

    @Unroll
    @See("Utils metodo stringToTimestamp")
    def "Poder obtener un Timestamp de un String " () {

        given: "Soy un ejecutivo de ZARA"

        when: "Deseo transformar un String en una Fecha con Hora"

        def response = utils.stringToTimeStamp(str)

        then: "Se procede a verificar la respuesta"

        null != response
        if (caso == 0)
            response.toLocalDate().getDayOfWeek().toString() == "Sunday"
        if (caso == 1)
            response == new Timestamp(System.currentTimeMillis())

        where: "Los datos a utilizar son"

        caso | str
        0 | "2020-06-14 10:00:00"
        1 | "Esto no es una Fecha"
    }

    @Unroll
    @See("Utils metodo wrapperPricesModelToPricesResponseDTO")
    def "Poder obtener un PricesResponseDTO desde un PricesModel " () {

        given: "Soy un ejecutivo de ZARA"

        when: "Deseo transformar un PricesModel en un PricesResponseDTO"

        def response = utils.wrapperPricesModelToPricesResponseDTO(Mock.obtenerListaBD(caso).get(caso))

        then: "Se procede a verificar la respuesta"

        null != response
        response.precioFinal == precioFinal
        response.identificadorProducto == idProducto

        where: "Los datos a utilizar son"

        caso | precioFinal | idProducto
        0 | 35.5 | 35455
        1 | 25.45 | 35455
    }
}
