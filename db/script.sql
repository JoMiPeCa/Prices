SET DB_CLOSE_DELAY -1;

CREATE USER IF NOT EXISTS "user" SALT '7009b83574fc38e1' HASH '6a6159733bc9dbd771500c5f0e4c491332079a0d0b0b80c07628a1e0fc570909' ADMIN;


CREATE TABLE PUBLIC.PRICES (   ID INTEGER AUTO_INCREMENT NOT NULL,
                               BRAND_ID INTEGER NOT NULL,
                               START_DATE TIMESTAMP NOT NULL,
                               END_DATE TIMESTAMP NOT NULL,
                               PRICE_LIST INTEGER NOT NULL,
                               PRODUCT_ID INTEGER NOT NULL,
                               PRIORITY INTEGER NOT NULL,
                               PRICE DOUBLE PRECISION NOT NULL,
                               CURR VARCHAR(3) NOT NULL
);

ALTER TABLE PUBLIC.PRICES ADD CONSTRAINT PRICES_PK PRIMARY KEY (ID);


COMMENT ON COLUMN PUBLIC.PRICES.ID IS 'auto increment ID PK.';
COMMENT ON COLUMN PUBLIC.PRICES.BRAND_ID IS 'foreign key de la cadena del grupo (1 = ZARA).';
COMMENT ON COLUMN PUBLIC.PRICES.START_DATE IS 'rango de fechas en el que aplica el precio tarifa';
COMMENT ON COLUMN PUBLIC.PRICES.END_DATE IS 'rango de fechas en el que aplica el precio tarifa';
COMMENT ON COLUMN PUBLIC.PRICES.PRICE_LIST IS 'Identificador de la tarifa de precios aplicable.';
COMMENT ON COLUMN PUBLIC.PRICES.PRODUCT_ID IS 'Identificador código de producto.';
COMMENT ON COLUMN PUBLIC.PRICES.PRIORITY IS 'Desambiguador de aplicación de precios. Si dos tarifas';
COMMENT ON COLUMN PUBLIC.PRICES.PRICE IS 'precio final de venta.';
COMMENT ON COLUMN PUBLIC.PRICES.CURR IS 'iso de la moneda.';

INSERT INTO PUBLIC.PRICES (ID,BRAND_ID,START_DATE,END_DATE,PRICE_LIST,PRODUCT_ID,PRIORITY,PRICE,CURR) VALUES
                                                                                                       (1,1,'2020-06-14 00:00:00','2020-12-31 23:59:59',1,35455,0,35.5,'EUR'),
                                                                                                       (2,1,'2020-06-14 15:00:00','2020-06-14 18:30:00',2,35455,1,25.45,'EUR'),
                                                                                                       (3,1,'2020-06-15 00:00:00','2020-06-15 11:00:00',3,35455,1,30.5,'EUR'),
                                                                                                       (4,1,'2020-06-15 16:00:00','2020-12-31 23:59:59',4,35455,1,38.95,'EUR');
