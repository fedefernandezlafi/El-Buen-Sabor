USE ELBUENSABOR;

  -- SEXTA INSERCION
  ALTER TABLE USUARIO
  ADD foreign key (id_rol) references rol (id_rol);
  
INSERT INTO USUARIO(ID,CLAVE,USUARIO,ID_ROL)
       VALUES    (1,"ADMIN","ADMIN",1),
			     (2,"COCI","COCI",2),
                 (3,"CAJE","CAJE",3),
                 (4,"CLI","CLI",4);
