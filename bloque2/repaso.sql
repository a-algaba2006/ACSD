create database tienda_informatica;
use tienda_informatica;

 create table cliente(
	id_cliente int auto_increment primary key,
    nombre varchar(30) not null,
    direccion varchar(30) not null,
    ciudad varchar(30) not null,
    email varchar(100)
 );
 
 create table producto(
	id_producto int auto_increment primary key,
    nombre varchar(60) not null,
    categoria varchar(30),
    marca varchar(30) not null,
    precio decimal(8,2) not null,
    stock int default 0
 );
 
 create table proovedor(
	id_proovedor int auto_increment primary key,
    nombre varchar(60) not null,
    ciudad varchar(60) not null,
    telefono varchar(15)
 );
 
create table compra(
	id_compra int auto_increment primary key,
    id_proovedor int not null,
    id_producto int not null,
    fecha date not null,
    cantidad int not null,
    coste decimal(8,2) not null,
    foreign key (id_proovedor) references proovedor(id_proovedor),
    foreign key (id_producto) references producto(id_producto)
);

create table vende(
	id_venta int auto_increment primary key,
    id_producto int not null,
    id_cliente int not null,
    fecha date not null,
    cantidad int not null,
    foreign key (id_producto) references producto(id_producto),
    foreign key (id_cliente) references cliente(id_cliente)
);

/*comprobacion que se ha creado*/
show tables;

describe cliente;

/*Modificar la estructura de la tabla ALTER TABLE*/
alter table cliente add column telefono varchar(9);
alter table cliente rename column telefono to movil;
alter table cliente modify column movil varchar(15);
alter table cliente drop column movil;

/*Insertar datos*/

insert into cliente(nombre, direccion, ciudad, email)
values ("Juan Lopez", "C/Andalucia nº 2", "Badajoz", "juan.lopez@davante.org");

select * from cliente;

insert into proovedor(nombre, ciudad, telefono) values
("HP", "Madrid", "91500001"),
("Lenovo", "Barcelona", "93400002"),
("Logitech", "Valencia", "96300003"),
("TechMayorista", "Malaga", "95200004");

select * from proovedor;

insert into producto(nombre, categoria, marca, precio, stock) values
("Portatil HP 15", "Portatiles", "HP", 549.00, 15),
("Portatil Lenovo IdeaPad", "Portatiles", "Lenovo", 479.00, 20);

select * from producto;

insert into vende(id_producto, id_cliente, fecha, cantidad) values
(1, 1, "2026-09-01", 1),
(2, 1, "2026-09-01", 1);

select * from vende;