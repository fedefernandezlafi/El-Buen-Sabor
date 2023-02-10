USE ELBUENSABOR;


 -- TERCERA INSERCION
 
 INSERT INTO ARTICULO_INSUMO(ID,DENOMINACION,ES_INSUMO,PRECIO_COMPRA,PRECIO_VENTA,STOCK_ACTUAL,STOCK_MINIMO,UNIDAD_MEDIDA,ID_DETALLE,ID_RUBRO_ARTICULO,ID_DETALLE_FACTURA,
 ID_DETALLE_PEDIDO,IMAGEN,ID_RUBRO_GENERAL)
 VALUES(1,"HARINA",TRUE,"200","400","100","10","KG",NULL,1,NULL,NULL,NULL,1),
       (2,"SALSA",TRUE,"300","600","100","10","L",NULL,1,NULL,NULL,NULL,1),
       (3,"QUESO MOZZARELLA",TRUE,"1500","3000","100","10","KG",NULL,1,NULL,NULL,NULL,1),
       (4,"JAMON COCIDO",TRUE,"1000","2000","100","10","KG",NULL,3,NULL,NULL,NULL,1),
       (5,"JAMON CRUDO",TRUE,"2500","5000","50","10","KG",NULL,1,NULL,NULL,NULL,1),
       (6,"CEBOLLA",TRUE,"350","700","30","10","KG","",1,NULL,NULL,NULL,1),
       (7,"PAPAS",TRUE,"600","1200","100","10","KG",NULL,4,NULL,NULL,NULL,1),
       (8,"QUESO CHEDDAR",TRUE,"4000","8000","40","10","KG",NULL,2,NULL,NULL,NULL,1),
       (9,"LEVADURA",TRUE,"2000","4000","500","10","GR",NULL,1,NULL,NULL,NULL,1),
       (10,"HUEVOS",TRUE,"300","1200","2400","10","UNIDADES",NULL,3,NULL,NULL,NULL,1),
       (11,"CARNE",TRUE,"50","1500","3000","10","KG",NULL,3,NULL,NULL,NULL,1),
       (12,"HAMBURGUESA",TRUE,"500","1000","100","10","KG",NULL,2,NULL,NULL,NULL,1),
       (13,"PAN",TRUE,"600","1200","100","10","KG",NULL,3,NULL,NULL,NULL,1),
       (14,"PAN DE HAMBURGUESA",TRUE,"500","1000","100","10","KG",NULL,2,NULL,NULL,NULL,1),
       (15,"LECHUGA",TRUE,"300","600","40","10","KG",NULL,3,NULL,NULL,NULL,1),
       (16,"TOMATE",TRUE,"300","600","70","10","KG",NULL,3,NULL,NULL,NULL,1),
       (17,"QUESO BARRA",TRUE,"1200","2400","40","10","KG",NULL,3,NULL,NULL,NULL,1),
       (18,"COCA COLA 1.5L",FALSE,"400","800","50","10","UNIDADES",NULL,6,NULL,NULL,NULL,2),
       (19,"COCA COLA 2.5L",FALSE,"600","900","60","10","UNIDADES",NULL,6,NULL,NULL,NULL,2),
       (20,"CERVEZA QUILMES 1L",FALSE,"500","1000","80","10","UNIDADES",NULL,5,NULL,NULL,NULL,2),
       (21,"CERVEZA ANDES 1L",FALSE,"500","1000","80","10","UNIDADES",NULL,5,NULL,NULL,NULL,2),
       (22,"AGUA SABORIZADA LEVITE NARANJA 1.5L",FALSE,"400","800","30","10","UNIDADES",NULL,5,NULL,NULL,NULL,2);