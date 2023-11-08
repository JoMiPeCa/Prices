package com.inditex.prices.service

import com.inditex.prices.dto.PricesRequestDTO
import com.inditex.prices.mock.Mock
import com.inditex.prices.repository.PricesRepository
import com.inditex.prices.util.Utils
import spock.lang.See
import spock.lang.Specification
import spock.lang.Unroll

class PricesServiceSpec extends Specification {

    private PricesService pricesService
    private PricesRepository pricesRepository
    private Utils utils

    void setup() {
        pricesRepository = Stub(PricesRepository)
        utils = new Utils()
        pricesService = new PricesServiceImpl(pricesRepository, utils)


    }

    @Unroll
    @See("Ver Documento Prueba Técnica Inditex.docx")
    def "Obtener precios sergun diferentes datos de prueba - OK" () {
        given: "Soy un ejecutivo de ZARA"

        pricesRepository.buscarTodosPorFechaMarcaProducto(_,_,_) >> Mock.obtenerListaBD(caso)

        when: "Deseo consultar la data de precios de una fecha en particular"

        PricesRequestDTO request = PricesRequestDTO.builder()
                .fechaAplicacion(fecha)
                .identificadorProducto(producto)
                .identificadorCadena(marca)
                .build()

        def response = pricesService.obtenerPrecios(request);

        then: "Se procede a verificar la respuesta"

        null != response
        response.getIdentificadorCadena() == marca
        println("Test "+(caso+1)+": petición a las: "+hora+" del dia "+dia+" del producto "+producto+" para la brand "+marca)
        println(response.toString())

        where: "Los datos a utilizar son"

        caso | fecha | dia | hora | producto | marca
        0 | "2020-06-14 10:00:00" | "14" | "10:00" | 35455 | 1
        1 | "2020-06-14 16:00:00" | "14" | "16:00" | 35455 | 1
        2 | "2020-06-14 21:00:00" | "14" | "21:00" | 35455 | 1
        3 | "2020-06-15 10:00:00" | "15" | "10:00" | 35455 | 1
        4 | "2020-06-16 21:00:00" | "16" | "21:00" | 35455 | 1
    }
}
