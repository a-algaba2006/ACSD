drop database if exists tienda_informatica;
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
 
 create table proveedor(
	id_proveedor int auto_increment primary key,
    nombre varchar(60) not null,
    ciudad varchar(60) not null,
    telefono varchar(15)
 );
 
create table compra(
	id_compra int auto_increment primary key,
    id_proveedor int not null,
    id_producto int not null,
    fecha date not null,
    cantidad int not null,
    coste decimal(8,2) not null,
    foreign key (id_proveedor) references proveedor(id_proveedor),
    foreign key (id_producto) references producto(id_producto)
);

create table venta(
	id_venta int auto_increment primary key,
    id_cliente int,
    id_producto int,
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

insert into proveedor(nombre, ciudad, telefono) values
("HP", "Madrid", "91500001"),
("Lenovo", "Barcelona", "93400002"),
("Logitech", "Valencia", "96300003"),
("TechMayorista", "Malaga", "95200004");

select * from proveedor;

insert into producto(nombre, categoria, marca, precio, stock) values
("Portatil HP 15", "Portatiles", "HP", 549.00, 15),
("Portatil Lenovo IdeaPad", "Portatiles", "Lenovo", 479.00, 20);

select * from producto;

insert into venta(id_cliente, id_producto, fecha, cantidad) values
(1, 1, "2026-09-01", 1),
(1, 2, "2026-09-01", 1);

select * from venta;


-- continuacion

INSERT INTO cliente (nombre, direccion, ciudad, email) VALUES
 ('Pepe Tejada',      'Avda. de Sevilla 12',  'Sevilla',   'pepe.tejada@davante.org'),
 ('Victor Fernandez', 'C/Mayor 5',            'Jaen',      NULL),
 ('Jose Assensio',    'C/Huesca 8',           'Huesca',    'jose.assensio@davante.org'),
 ('Leo Perez',        'Plaza Mayor 1',        'Orense',    NULL),
 ('Patricia Aranda',  'Paseo de Gracia 20',   'Barcelona', 'patricia.aranda@davante.org'),
 ('David Lopez',      'Gran Via 45',          'Madrid',    'david.lopez@davante.org'),
 ('Enrique Ferreras', 'C/Larios 3',           'Malaga',    'enrique.ferreras@davante.org'),
 ('Luis Guzman',    'C/Colon 18',           'Valencia',  NULL);

INSERT INTO producto (nombre, categoria, marca, precio, stock) VALUES
 ('Monitor Samsung 24',    'Monitores',      'Samsung',  139.90,  30),
 ('Raton Logitech M185',   'Perifericos',    'Logitech',  14.90, 100),
 ('Teclado Logitech K120', 'Perifericos',    'Logitech',  12.50,  80),
 ('Impresora HP DeskJet',  'Impresoras',     'HP',        69.00,  25),
 ('Disco SSD 1TB',         'Almacenamiento', 'Kingston',  74.90,  45),
 ('Pendrive 64GB',         'Almacenamiento', 'Kingston',   8.90, 150);

INSERT INTO venta (id_cliente, id_producto, fecha, cantidad) VALUES
 (2, 3, '2026-09-01', 2),
 (2, 5, '2026-09-01', 1),
 (1, 7, '2026-09-15', 1),
 (1, 6, '2026-09-15', 1),
 (5, 2, '2026-09-20', 1),
 (5, 4, '2026-09-20', 1),
 (5, 5, '2026-09-20', 1),
 (7, 6, '2026-10-01', 2),
 (7, 8, '2026-10-01', 3),
 (2, 4, '2026-10-05', 2),
 (2, 7, '2026-10-05', 1);

INSERT INTO compra (id_proveedor, id_producto, fecha, cantidad, coste) VALUES
 (1, 1, '2026-08-25',  20, 430.00),
 (1, 6, '2026-08-25',  30,  48.00),
 (2, 2, '2026-08-26',  25, 380.00),
 (3, 4, '2026-08-27', 120,   9.50),
 (3, 5, '2026-08-27', 100,   7.80),
 (4, 3, '2026-08-28',  40, 105.00),
 (4, 4, '2026-08-28',  50,  10.20),
 (4, 7, '2026-08-29',  60,  58.00),
 (4, 8, '2026-08-29', 200,   5.20);

select * from cliente;
select * from producto;

select count(*) as ventas from venta;

select count(*) as compras from compra;

insert into cliente(nombre, direccion, ciudad, email) values
("Ana Ruiz", "C/Sol 7", "Malaga", "ana.ruiz@davante.org"),
("Luis Soto", "C/Luna 9", "Granada", "luis.soto@davante.org");

select id_cliente, nombre, ciudad from cliente where id_cliente > 8;

-- modificar los datos

update cliente set ciudad = "Cordoba" where id_cliente = 3;

select id_cliente, nombre, ciudad from cliente where id_cliente = 3;

update producto set stock = stock + 5, precio = 529.00 where id_producto = 1;
update producto set precio = precio * 1.10 where id_producto = 4;
select id_producto, nombre, precio, stock from producto where id_producto in (1,4);

-- dejamos el cliente con id 3, como estaba
update cliente set ciudad = "Jaen" where id_cliente = 3;

select id_cliente, nombre, ciudad from cliente where id_cliente = 3;


-- usar REPLACE

replace into producto (id_producto, nombre, categoria, marca, precio, stock) values
(9, "Alfombrilla raton ", "Perifericos", "Logitech", 4.90, 60); -- repetir operacion

select * from producto where id_producto = 9;

replace into producto (id_producto, nombre, categoria, marca, precio) values
(9, "Alfombrilla raton XL", "Perifericos", "Logitech", 9.90);

select * from producto where id_producto = 9;

-- borrar filas DELETE
