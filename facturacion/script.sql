  CREATE TABLE tbl_encabezado( 
  claveacceso varchar(49),
  autorizacion varchar(49) , 
  coddoc   char(2),    
  ambiente  char(1),
  tipoemision char(1),
  razonsocial varchar(300),
  nombrecomercial varchar(300),
  ruc  varchar(13), 
  estab  char(3),
  ptoemi char(3),
  secuencial   char(9),
  dirmatriz  varchar(300),
  fechaemision  varchar(300),
  direstablecimiento  varchar(300),
  obligadocontabilidad char(2),
  tipoidentificacioncomprador  char(2),
  razonsocialcomprador  varchar(300),
  identificacioncomprador   varchar(13), 
  totalsinimpuestos  numeric,
  totaldescuento numeric,  
  propina NUMERIC ,
  importetotal numeric,
  moneda varchar(20),  
   nc_rise varchar(300),
   nc_coddocmodificado  char(2),
   nc_numdocmodificado varchar(20),
   nc_fechaemisiondocsustento date,
  nc_valormodificacion numeric,   
  r_tipoidentificacionsujetoretenido char(2),   
  r_razonsocialsujetoretenido varchar(300),
  r_identificacionsujetoretenido varchar(13), 
  r_periodofiscal varchar(10), 
  PRIMARY key( claveacceso )
  );
  
  CREATE TABLE tbl_totalimpuesto
  (  
   codigo  char(1),
   codigoporcentaje   char(1),
   baseimponible  NUMERIC ,
   valor numeric,
   claveacceso  varchar(49), 
    PRIMARY key( codigo,claveacceso,codigoporcentaje ),
   CONSTRAINT totalimpuesto FOREIGN KEY (claveacceso)
      REFERENCES tbl_encabezado (claveacceso) 
  );
  
  CREATE TABLE tbl_pagos
 (
     formapago char(2),
     total numeric,
     claveacceso varchar(49),
     PRIMARY key( formapago,claveacceso ),
     CONSTRAINT fk_tbl_pagos_encabezado FOREIGN KEY (claveacceso)     REFERENCES tbl_encabezado (claveacceso) 
  );
  
  
  
  CREATE TABLE tbl_detalle
  (
    pk_detalle int,
    codigoprincipal varchar(60),
   codigoauxiliar varchar(60),
   descripcion varchar(300),
   cantidad numeric,
   preciounitario numeric,
   descuento numeric,
   preciototalsinimpuesto numeric,
   claveacceso varchar(49),
   PRIMARY key( pk_detalle  ),
   CONSTRAINT fk_tbl_detalle FOREIGN KEY (claveacceso)
     REFERENCES tbl_encabezado (claveacceso) 
     
  );
  
  CREATE TABLE tbl_impuestos_detalle
   ( 
   
   codigo varchar(2),
   codigoporcentaje char(1),
   tarifa NUMERIC ,
  baseimponible numeric,
  valor numeric,
   pk_detalle INT ,
   
    PRIMARY key( pk_detalle , codigo  ),
   CONSTRAINT fk_tbl_detalle_impuestos  FOREIGN KEY (pk_detalle)
     REFERENCES tbl_detalle (pk_detalle) 
     
  );

  CREATE TABLE tbl_infoadicional
  (
     pk_infodicional INT ,
     campo  varchar(50),
     valor  varchar(300),
      claveacceso varchar(49),
      PRIMARY key( pk_infodicional ),      
       CONSTRAINT fk_tbl_infoadicional_encabezado  FOREIGN KEY (claveacceso)
     REFERENCES tbl_encabezado (claveacceso) 
     
  );
  
  CREATE TABLE tbl_detalle_retencion (
     
    codigo varchar(10),
   codigoretencion varchar(3),
   baseimponible NUMERIC ,
  porcentajeretener numeric,
  valorretenido numeric,
  coddocsustento   varchar(2),
  numdocsustento  varchar(20),
  fechaemisiondocsustento date,
    claveacceso varchar(49),
  PRIMARY key( codigo,claveacceso ),
       CONSTRAINT fk_detalle_retencion_encabezado  FOREIGN KEY (claveacceso)
     REFERENCES tbl_encabezado (claveacceso)   
  );
  CREATE TABLE tbl_emisor 
  (
   ruc varchar(13),
   firma LONG BINARY,
   clave varchar(20),
   ws_produccion_recepcion text,
   ws_pruebas_recepcion text,
   ws_produccion_autorizacion text,
   ws_pruebas_autorizacion text,   
   modooffline char(1) DEFAULT 'S',
   servicio_sri_activo char(1) DEFAULT 'S',
   PRIMARY key( ruc )
  );
  
  CREATE TABLE tbl_sri_autorizados
  (
      claveacceso varchar(49),
      xml  LONG BINARY,
      fecha_autorizacion datetime,
      numero_autorizacion  varchar(49),
      mensaje text,
      estado text,
       PRIMARY key( claveacceso ) 
  ); 
  
