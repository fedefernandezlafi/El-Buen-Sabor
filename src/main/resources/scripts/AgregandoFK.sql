USE ELBUENSABOR;

ALTER TABLE USUARIO
ADD foreign key (id_rol) references rol (id);