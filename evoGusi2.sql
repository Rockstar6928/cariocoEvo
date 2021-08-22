#drop database if exists polleriaGusi;
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

create database polleriaGusi;
use polleriaGusi;

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
idPedido int(11) not null auto_increment,
idUser int(11) not null,
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

insert into tbl_Estado values (1,1,"Habilitado");
insert into tbl_Estado values (2,1,"Deshabilitado");

insert into tbl_Perfil values (1,'Administrador',1);

insert into tbl_Usuario values(1,1,"y1709","y1709",1);
insert into tbl_Empleado values(1,"nombreY","apellidoY","993416456","78914752",1);

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
select * from tbl_Usuario;

call spF_ChecarDatosRegister("y17091","78914742",@p_error,@p_msg_error); select @p_error,@p_msg_error;







