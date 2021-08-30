#drop database if exists polleriaCarioco;
#drop table if exists tbl_Detalle_Pedido;
#drop table if exists tbl_Producto;
#drop table if exists tbl_Pedido;
#drop table if exists tbl_Categoria;
#drop table if exists tbl_Empleado;
#drop table if exists tbl_Cliente;
#drop table if exists tbl_Usuario;
#drop table if exists tbl_Menu_Perfil;
#drop table if exists tbl_Menu;
#drop table if exists tbl_Perfil;
#drop table if exists tbl_Estado;
#drop table if exists tbl_EstadoCabecera;

create database polleriaCarioco;
use polleriaCarioco;

#TABLES
CREATE TABLE tbl_EstadoCabecera (
idEstadoCabecera int(11) not null auto_increment,
desEstadoCabecera varchar(30) not null,
PRIMARY KEY(idEstadoCabecera)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE tbl_Estado(
idEstado int(11) not null,
idEstadoCabecera int(11) not null,
desEstado varchar(30) not null,
PRIMARY KEY(idEstado, idEstadoCabecera),
CONSTRAINT fk_tipoestado_id FOREIGN KEY(idEstadoCabecera) REFERENCES tbl_EstadoCabecera(idEstadoCabecera)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE tbl_Perfil (
idPerfil int(11) not null auto_increment,
desPerfil varchar(50) not null,
perfilEstado int(11) not null, 
PRIMARY KEY(idPerfil)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE tbl_Menu (
idMenu int(11) not null auto_increment,
desMenu varchar(50) not null,
rutaMenu varchar(1000) not null,
classMenu varchar(100),
targetMenu VARCHAR(100),
PRIMARY KEY(idMenu)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE tbl_Menu_Perfil (
idPerfil int(11) not null,
idMenu int(11) not null,
PRIMARY KEY(idPerfil,idMenu),
CONSTRAINT FK_idPerfilMenu FOREIGN KEY (idPerfil) REFERENCES tbl_Perfil(idPerfil),
CONSTRAINT FK_idMenuMenu FOREIGN KEY (idMenu) REFERENCES tbl_Menu(idMenu)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE tbl_Usuario(
idUser int(11) not null auto_increment,
idPerfil int(11) not null,
mailUser varchar(50) not null,
passwordUser varchar(50) not null,
usuEstado int(11) not null,
PRIMARY KEY(idUser),
CONSTRAINT FK_idPerfil FOREIGN KEY(idPerfil) references tbl_Perfil(idPerfil)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE tbl_Cliente(
idCliente int(11) not null auto_increment,
nombreCliente varchar(50) not null,
apellidoCliente varchar(50) not null,
celularCliente varchar(9) not null,
dniCliente char(8) not null,
fechaNacimiento date not null,
direccionCliente varchar(100) not null,
idUser int(11) not null,
PRIMARY KEY(idCliente),
CONSTRAINT FK_idUserCliente FOREIGN KEY(idUser) references tbl_Usuario(idUser)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table tbl_Empleado(
idEmpleado int(11) not null auto_increment,
nombreEmpleado varchar(50) not null,
apellidoEmpleado varchar(50) not null,
celularEmpleado varchar(9) not null,
dniEmpleado char(8) not null,
idUser int(11) not null,
CONSTRAINT pk_idEmpleado PRIMARY KEY(idEmpleado),
CONSTRAINT fk_idUsuEmp FOREIGN KEY(idUser) REFERENCES tbl_Usuario(idUser)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table tbl_Categoria(
idCat int(11) not null auto_increment,
desCat varchar(50) not null,
rutaMenu varchar(1000) NOT NULL,
classMenu varchar(100),
targetMenu VARCHAR(100),
catEstado int(11) not null,
CONSTRAINT pkCategoria PRIMARY KEY(idCat)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table tbl_Producto(
idPro int(11) not null auto_increment,
idCat int(11) not null ,
nomPro varchar(50) not null,
descPro varchar(100) not null,
precioPro decimal (18,2) not null,
imgPro varchar (500) not null,
proEstado int(11) not null,
CONSTRAINT pkProducto PRIMARY KEY(idPro),
CONSTRAINT fk_categoria_id FOREIGN KEY(idCat) references tbl_Categoria(idCat)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table tbl_Pedido(
#Creo que en lugar de idUser tendría que ir idCliente y idEmpleado
idPedido int(11) not null auto_increment,
idUser int(11) not null,
#idCliente
#idEmpleado
#consultar a mi enamorada la más hermooooooooooooooooooooooooosa de la tierra, claro despues de mi mamá
fecPedido date not null,
numSeriePedido varchar(244)  not null,
montVenta decimal (18,2) not null,
pedido_estado int(11) not null,
CONSTRAINT pk_id_pedido PRIMARY KEY(idPedido),
CONSTRAINT FK_id_usuario_pedido FOREIGN KEY(idUser) references tbl_Usuario(idUser)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table tbl_Detalle_Pedido(
idDetPedido int(11) not null auto_increment,
idPedido int(11) not null,
idPro int(11) not null,
cantProducto int(11) not null,
precioVenta decimal (18,2) not null,
importeVenta decimal (18,2) NOT NULL,
CONSTRAINT pk_det_id PRIMARY KEY(idDetPedido),
CONSTRAINT FK_id_pedido FOREIGN KEY (idPedido) REFERENCES tbl_Pedido(idPedido),
CONSTRAINT FK_idProducto FOREIGN KEY (idPro) REFERENCES tbl_Producto(idPro)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#INSERTS
insert into tbl_EstadoCabecera values (1,"Usuario");
insert into tbl_EstadoCabecera values (2,"Categorias");
insert into tbl_EstadoCabecera values (3,"Productos");



insert into tbl_Estado values (1,1,"Habilitado");
insert into tbl_Estado values (2,1,"Deshabilitado");
insert into tbl_Estado values (1,2,"Visible");
insert into tbl_Estado values (2,2,"Oculta");
insert into tbl_Estado values (1,3,"Visible");
insert into tbl_Estado values (2,3,"Oculto");


insert into tbl_Menu values(1,"Home","vistaPrincipalAdministrativa.jsp","nav-link","");
insert into tbl_Menu values(2,"Clientes","ControladorCliente?menu=cliente&&accion=listar","nav-link","");
insert into tbl_Menu values(3,"Categorias","ControladorCategoria?menu=categoria&&accion=listar","nav-link","");
insert into tbl_Menu values(4,"Productos","ControladorProducto?menu=producto&&accion=listar","nav-link","");

insert into tbl_Perfil values (1,'Administrador',1);
insert into tbl_Perfil values (2,'Cliente',1);

INSERT INTO tbl_Menu_Perfil VALUES (1,1);
INSERT INTO tbl_Menu_Perfil VALUES (1,2);
INSERT INTO tbl_Menu_Perfil VALUES (1,3);
INSERT INTO tbl_Menu_Perfil VALUES (1,4);

insert into tbl_Usuario values(1,1,"y1709","cqSnNZ/C3c0=",1);
insert into tbl_Empleado values(1,"nombreY","apellidoY","993416456","78914752",1);

insert into tbl_Categoria values(1,"Promociones","ControladorVistas?menu=vistas&&accion=listarsortcat","nav-link","myFrame",1);
insert into tbl_Categoria values(3,"Brasas","ControladorVistas?menu=vistas&&accion=listarsortcat","nav-link","myFrame",1);
insert into tbl_Categoria value(4,"Hamburguesas","ControladorVistas?menu=vistas&&accion=listarsortcat","nav-link","myFrame",1);

insert into tbl_Producto values(1,3,"UN OCTAVO","1/8 pollo a la brasa + papas fritas + ensalada",8.90,"Brasas_01.png",1);
insert into tbl_Producto values(2,3,"UN CUARTO","1/4 pollo a la brasa + papas fritas + ensalada",14.90,"Brasas_02.png",1);
insert into tbl_Producto values(3,4,"HAMBURGUESA CLASICA","Hamburguesa de pollo o carne + papas fritas o al hilo + ensalada",4.90,"Hamburguesa_013.png",1);

DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE spF_validarUsuario(
IN _cod_usuario  varchar(50) ,
IN _usu_password varchar(50),
OUT p_error int,
OUT p_msg_error varchar(1000)
)
BEGIN
	DECLARE V_COUNT INT DEFAULT 0;
    
	SET p_error = 0;
	SET p_msg_error = '';
  BLOCK1: BEGIN	
	SELECT  count(*)
    INTO V_COUNT
    FROM tbl_Usuario u
	where 
    u.mailUser = _cod_usuario;
    
    IF IFNULL(V_COUNT,0) = 0 THEN
			SET p_error = 101;
			SET p_msg_error = 'Usuario no registrado.';	
			LEAVE BLOCK1;
		END IF;
        
	SELECT  count(*)
    INTO V_COUNT
    FROM tbl_Usuario u
	where 
    u.mailUser = _cod_usuario and u.passwordUser = _usu_password;    
	IF IFNULL(V_COUNT,0) = 0 THEN
			SET p_error = 102;
			SET p_msg_error = 'Usuario o Contrasena incorrecto.';	
			LEAVE BLOCK1;
		END IF;
	SELECT * 
    FROM tbl_Usuario u
    where u.mailUser = _cod_usuario and u.passwordUser = _usu_password;
	END BLOCK1;	
END;

DELIMITER $$
CREATE DEFINER=root@localhost procedure spF_ChecarDatosRegister(
IN _mail_usu varchar(50),
IN _dni_usu char(8),
OUT p_error int,
OUT p_msg_error varchar(1000)
)
begin
DECLARE V_COUNT INT DEFAULT 0;
DECLARE V_COUNT2 INT DEFAULT 0;
DECLARE V_COUNT3 INT DEFAULT 0;
    SET p_error = 0;
	SET p_msg_error = '';
BLOCK1: BEGIN	

	SELECT  count(*) INTO V_COUNT FROM tbl_Usuario u
	where u.mailUser = _mail_usu;
	IF IFNULL(V_COUNT,0) = 1 THEN
		SET p_error = 101;
		SET p_msg_error = 'Correo ya existe en el sistema';	
        select p_error,p_msg_error;
		LEAVE BLOCK1;
END IF;

SELECT  count(*) INTO V_COUNT2 FROM tbl_Cliente cli
	where cli.dniCliente = _dni_usu;
	IF IFNULL(V_COUNT2,0) = 1 THEN
		SET p_error = 101;
		SET p_msg_error = 'DNI ya existe en el sistema';	
        select p_error,p_msg_error;
		LEAVE BLOCK1;
END IF;

SELECT  count(*) INTO V_COUNT3 FROM tbl_Empleado emp
	where emp.dniEmpleado = _dni_usu;
	IF IFNULL(V_COUNT3,0) = 1 THEN
		SET p_error = 101;
		SET p_msg_error = 'DNI ya existe en el sistema';	
        select p_error,p_msg_error;
		LEAVE BLOCK1;
END IF;
END BLOCK1;
END;


DELIMITER $$
CREATE DEFINER=root@localhost procedure spF_agregarUSUARIO(
_mail_usu varchar(50), 
_usu_password varchar(50)
)
begin
insert into tbl_Usuario(mailUser,passwordUser,idPerfil,usuEstado)
VALUES (_mail_usu,_usu_password,2,1);
END;


DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE spF_obtenerMaxUser()
BEGIN
select max(idUser) from tbl_Usuario;
END;

DELIMITER $$
CREATE DEFINER=root@localhost procedure spF_agregarCliente(
_nom_cliente varchar(50), 
_ape_cliente varchar(58),
_tel_cliente varchar(9),
_dni_cliente char(8),
_fecha_nac varchar(50),
_dir_cliente varchar(100),
_id_usu int(11)
)
begin
insert into tbl_Cliente(nombreCliente,apellidoCliente,celularCliente,dniCliente,fechaNacimiento,direccionCliente,idUser)
VALUES (_nom_cliente,_ape_cliente,_tel_cliente,_dni_cliente,STR_TO_DATE(_fecha_nac, '%Y-%m-%d'),_dir_cliente,_id_usu);
END;


DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE spF_validarMenu(
IN _id_perfil int(11)
)
BEGIN

    SELECT T1.idPerfil, T1.desPerfil, T2.idMenu, T3.desMenu, T3.rutaMenu, T3.classMenu, T3.targetMenu
	FROM tbl_Perfil T1
	INNER JOIN tbl_Menu_Perfil T2 ON T2.idPerfil = T1.idPerfil
    INNER JOIN tbl_Menu T3 ON T3.idMenu = T2.idMenu
	WHERE T1.idPerfil = _id_perfil;	
END;


DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE spF_ListarCats()
BEGIN
SELECT T1.idCat, T1.desCat, T1.rutaMenu, T1.classMenu, T1.targetMenu,T2.desEstado
FROM tbl_Categoria T1
inner join tbl_Estado T2 on T2.idEstadoCabecera=2 and T2.idEstado=T1.catEstado
where T1.catEstado=1
order by T1.idCat;
END;

DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE spF_BuscarCAT(
_des_cat  varchar(50),
_cat_estado int)
begin
SELECT T1.idCat, T1.desCat, T1.rutaMenu, T1.classMenu, T1.targetMenu,T2.desEstado
FROM tbl_Categoria T1
inner join tbl_Estado T2 on T2.idEstadoCabecera=2 and T2.idEstado=T1.catEstado
WHERE  (_des_cat=''  or UPPER(T1.desCat) like CONCAT('%',UPPER(TRIM(IFNULL(_des_cat,''))),'%')) 
and  (_cat_estado=-1  or T2.idEstado=_cat_estado);
END;

DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE spF_OcultarCategoria(in _COD_CAT int)
begin
UPDATE tbl_Categoria SET catEstado=2
WHERE idCat=_COD_CAT and catEstado=1;
END;

DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE spF_MostrarCategoria(in _id_cat int)
begin
UPDATE tbl_Categoria SET catEstado=1
WHERE idCat=_id_cat and catEstado=2;
END;

DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE spF_DeleteCAT(in _ID_CAT int)
BEGIN
DELETE FROM tbl_Categoria
WHERE idCat=_ID_CAT;
END;

#select * from tbl_Usuario;
select * from tbl_Categoria;


DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE spF_agregarCAT(_des_cat varchar(50),
OUT p_error int,
OUT p_msg_error varchar(1000))
begin
DECLARE V_COUNT INT DEFAULT 0;
    SET p_error = 0;
	SET p_msg_error = '';
BLOCK1: BEGIN	
	SELECT  count(*)
    INTO V_COUNT
    FROM tbl_Categoria cat
	where 
   cat.desCat = _des_cat;
IF IFNULL(V_COUNT,0) = 1 THEN
			SET p_error = 101;
			SET p_msg_error = 'La categoría que desea registrar, ya existe en el sistema';	
            select p_error,p_msg_error;
			LEAVE BLOCK1;
END IF;
insert into tbl_Categoria(desCat,rutaMenu,classMenu,targetMenu,catEstado)
VALUES (_des_cat,"ControladorVistas?menu=vistas&&accion=listarsortcat","nav-link","myFrame",1);
end BLOCK1;
END;


DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE spF_ListarCATID(in _ID_CAT int)
BEGIN
select * from tbl_Categoria
where idCat=_ID_CAT;
END;


DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE spF_actualizaCAT (
in _ID_CAT int(11),
in _des_cat varchar(50),
OUT p_error int,
OUT p_msg_error varchar(1000)
)
begin
DECLARE V_COUNT INT DEFAULT 0;
    SET p_error = 0;
	SET p_msg_error = '';
BLOCK1: BEGIN	
	SELECT  count(*) INTO V_COUNT FROM tbl_Categoria u
	where u.desCat = _des_cat and u.idCat<>_ID_CAT;
IF IFNULL(V_COUNT,0) = 1 THEN
			SET p_error = 101;
			SET p_msg_error = 'El nombre de la categoría ingresado, ya existe!';	
            select p_error,p_msg_error;
			LEAVE BLOCK1;
END IF;
UPDATE tbl_Categoria SET desCat=_des_cat WHERE idCat=_ID_CAT;
end BLOCK1;
END;


DELIMITER $$
CREATE DEFINER=root@localhost procedure spF_ListaProductosGeneral()
begin
select T1.idPro,T2.desCat,T1.nomPro,T1.descPro,T1.precioPro,T1.imgPro,T3.desEstado
from tbl_Producto T1
inner join tbl_categoria T2 on T2.idCat=T1.idCat
inner join tbl_Estado T3 on T3.idEstadoCabecera=3 and  T3.idEstado=T1.proEstado
where T1.proEstado=1
order by T1.idPro;
END;

DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE spF_BuscarProducto(
_id_cat int,
 _DES_PRO varchar(50),
 _estado int )
begin
select T1.idPro,T2.desCat,T1.nomPro,T1.descPro,T1.precioPro,T1.imgPro,T3.desEstado
from tbl_Producto T1
inner join tbl_categoria T2 on T2.idCat=T1.idCat
inner join tbl_Estado T3 on T3.idEstadoCabecera=3 and  T3.idEstado=T1.proEstado
WHERE (_id_cat=-1 or T2.idCat=_id_cat)
and (_DES_PRO=''  or UPPER(T1.nomPro) LIKE CONCAT('%',UPPER(TRIM(IFNULL(_DES_PRO,''))),'%') or  UPPER(T1.descPro) LIKE CONCAT('%',UPPER(TRIM(IFNULL(_DES_PRO,''))),'%'))
and  (_estado=-1  or T3.idEstado=_estado)
ORDER BY T1.idPro;
END;


DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE spF_OcultarProducto(in _COD_PRO int)
begin
UPDATE tbl_Producto SET proEstado=2
WHERE idPro=_COD_PRO and proEstado=1;
END;

DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE spF_MostrarProducto(in _COD_PRO int)
begin
UPDATE tbl_Producto SET proEstado=1
WHERE idPro=_COD_PRO and proEstado=2;
END;

DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE spF_DeletePRO(in _COD_PRO int)
BEGIN
DELETE FROM tbl_Producto
WHERE idPro=_COD_PRO;
END;



DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE spF_agregarPRO(
_COD_CAT int,
_NOM_PRO varchar(50),
_desc_pro varchar(50),
_PRECIO decimal(18,2),
img_pro_ varchar(200),
OUT p_error int,
OUT p_msg_error varchar(1000)
)
begin
DECLARE V_COUNT INT DEFAULT 0;
    SET p_error = 0;
	SET p_msg_error = '';
BLOCK1: BEGIN	
	SELECT  count(*)
    INTO V_COUNT
    FROM tbl_Producto u
	where u.idCat=_COD_CAT and u.nomPro = _NOM_PRO;
IF IFNULL(V_COUNT,0) = 1 THEN
			SET p_error = 101;
			SET p_msg_error = 'Producto que deseas agregar, ya existe';	
			LEAVE BLOCK1;
END IF;
insert into tbl_Producto(idCat,nomPro,descPro,precioPro,imgPro,proEstado)
VALUES (_COD_CAT,_NOM_PRO,_desc_pro,_PRECIO,img_pro_,1);
END BLOCK1;
END;


DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE spF_ListarPROID(in _COD_PRO int)
begin
select * from tbl_Producto
where idPro=_COD_PRO;
END;

call spF_ListarPROID(4);













