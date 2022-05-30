drop database if exists sistema_ventas;

create database sistema_ventas;
use sistema_ventas;

create table cliente(
	idcliente int primary key auto_increment,
    dni varchar(8) not null,
    nombres varchar(100) not null,
    direccion varchar(200) not null,
    estado char(1) not null
)engine= InnoDB;

create table Empleado(
	idempleado int primary key auto_increment,
    dni varchar(8) not null,
    nombres varchar(100) not null,
    telefono varchar(9) default '000000000',
    estado char(1) not null,
    username varchar(9) not null
)engine= InnoDB;

create table Producto(
	idproducto int primary key auto_increment,
    nombres varchar(100) not null,
    precio decimal(6,2) not null,
    stock int not null,
    estado char(1) not null
)engine= InnoDB;

create table Ventas(
	idventas int primary key auto_increment,
    idcliente int not null,
    idempleado int not null,
    numeroserie varchar(25) not null,
    fechaventa date,
    monto decimal(6,2),
    estado char(1),
    foreign key(idcliente) references Cliente(idcliente),
    foreign key(idempleado) references Empleado(idempleado)
)engine= InnoDB;

create table DetalleVentas(
	iddetalleventas int primary key auto_increment,
    idventas int not null,
    idproducto int not null,
    cantidad int not null,
    precioventa decimal(6,2) not null,
    foreign key(idventas) references Ventas(idventas),
    foreign key(idproducto) references Producto(idproducto)
)engine= InnoDB;
