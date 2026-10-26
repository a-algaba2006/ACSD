-- paso 1 crear la base de datos y usarla
drop database if exists tienda_informatica;
create database tienda_informatica;
use tienda_informatica;

-- paso 2, crear las tablas

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

-- paso 3, alterar tablas
/*Modificar la estructura de la tabla ALTER TABLE*/
alter table cliente add column telefono varchar(9);
alter table cliente rename column telefono to movil;
alter table cliente modify column movil varchar(15);
alter table cliente drop column movil;

-- paso 4, insertar datos
/*Insertar datos con INSERT INTO*/
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


-- paso 5, insertar el resto de los datos

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

-- paso 6, insertando mas datos

update cliente set ciudad = "Cordoba" where id_cliente = 3;

select id_cliente, nombre, ciudad from cliente where id_cliente = 3;

update producto set stock = stock + 5, precio = 529.00 where id_producto = 1;
update producto set precio = precio * 1.10 where id_producto = 4;
select id_producto, nombre, precio, stock from producto where id_producto in (1,4);

-- dejamos el cliente con id 3, como estaba
update cliente set ciudad = "Jaen" where id_cliente = 3;

select id_cliente, nombre, ciudad from cliente where id_cliente = 3;

-- pso 7 modificar datos (UPDATE)
-- usar REPLACE

replace into producto (id_producto, nombre, categoria, marca, precio, stock) values
(9, "Alfombrilla raton ", "Perifericos", "Logitech", 4.90, 60); -- repetir operacion

select * from producto where id_producto = 9;

replace into producto (id_producto, nombre, categoria, marca, precio) values
(9, "Alfombrilla raton XL", "Perifericos", "Logitech", 9.90);

select * from producto where id_producto = 9;

-- paso 8, borrar datos con DELETE

DELETE FROM cliente WHERE id_cliente IN (10, 11);

SELECT COUNT(*) AS clientes FROM cliente;

DELETE FROM cliente WHERE id_cliente = 1;

DELETE FROM producto WHERE id_producto = 9;
SELECT COUNT(*) AS productos FROM producto;

-- paso 10, consultas SQL con SELECT

select * from cliente;
select nombre, ciudad from cliente;
select nombre as Producto, precio as Precio from producto;
select marca from producto;
select distinct marca from producto;
select distinct categoria from producto;

-- paso 11 WHERE, operadores y nulos

SELECT nombre, precio FROM producto WHERE precio > 100;
SELECT nombre, precio FROM producto WHERE precio >= 74.90;
SELECT nombre, precio FROM producto WHERE precio < 15;
SELECT nombre, marca FROM producto WHERE marca = 'HP';
SELECT nombre, marca FROM producto WHERE marca <> 'HP';

SELECT id_cliente, nombre, email FROM cliente WHERE email IS NULL;
SELECT id_cliente, nombre, email FROM cliente WHERE email = NULL;
SELECT id_cliente, nombre, email FROM cliente WHERE email IS NOT NULL;

-- paso 12, WHERE, LIKE, BETWEEN  e IN

SELECT nombre FROM cliente WHERE nombre LIKE 'P%';       -- empieza por P
SELECT nombre FROM cliente WHERE nombre LIKE '%Lopez';   -- termina en Lopez
SELECT nombre FROM cliente WHERE nombre LIKE '%er%';     -- contiene "er"
SELECT nombre FROM cliente WHERE nombre LIKE '_e%';      -- segunda letra: e
SELECT nombre, email FROM cliente WHERE email LIKE '%@davante.org';

SELECT nombre, precio FROM producto WHERE nombre LIKE 'Portatil%';
SELECT nombre, marca FROM producto WHERE nombre LIKE '%Logitech%';
SELECT nombre, precio FROM producto WHERE precio BETWEEN 10 AND 100;
SELECT nombre, marca FROM producto WHERE marca IN ('HP', 'Kingston');
SELECT nombre, categoria FROM producto WHERE categoria IN ('Monitores', 'Impresoras');

-- paso 13, combinar condiciones, AND, OR, NOT y parentesis

SELECT nombre, precio FROM producto WHERE precio > 20 AND precio < 150;
SELECT nombre, marca FROM producto WHERE marca = 'HP' OR marca = 'Lenovo';
SELECT nombre, categoria FROM producto WHERE NOT categoria = 'Portatiles';

-- Sin paréntesis: AND se evalúa antes que OR
SELECT nombre, marca, precio FROM producto
WHERE marca = 'HP' OR marca = 'Logitech' AND precio < 20;

-- Con paréntesis: primero el OR
SELECT nombre, marca, precio FROM producto
WHERE (marca = 'HP' OR marca = 'Logitech') AND precio < 20;

-- paso 14, ordenar con ORDER BY  y limitar con  LIMIT
select nombre, precio from producto order by precio;
select nombre, precio from producto order by precio desc;

select categoria, nombre, precio from producto order by categoria asc, precio asc;

select nombre, precio from producto order by precio desc limit 3;
select nombre, ciudad from cliente order by nombre;

-- paso 15 casos practicos

select * from producto where precio > 100 order by nombre asc;

select nombre, marca, precio from producto where precio between 10 and 150 order by nombre desc;

-- paso 16 consultar varias tablas con join

select v.id_venta, v.fecha, c.nombre as cliente, p.nombre as producto, v.cantidad, v.cantidad * p.precio as importe 
from venta v join cliente c on (v.id_cliente = c.id_cliente) join producto p on (v.id_producto = p.id_producto) order by v.id_venta;

select v.fecha, p.nombre as producto, v.cantidad
from venta v join producto p on (v.id_producto = p.id_producto) where v.id_cliente = 1 order by v.fecha;

select c.nombre, sum(v.cantidad * p.precio) as total_gastado
from venta v 
join cliente c on (v.id_cliente = c.id_cliente)
join producto p on (v.id_producto = p.id_producto)
group by c.id_cliente, c.nombre 
order by total_gastado desc;

select p.nombre as producto, pr.nombre as proveedor
from compra c join producto p on (c.id_producto = p.id_producto)
join proveedor pr on (c.id_proveedor = pr.id_proveedor)
order by p.nombre, pr.nombre;

-- paso 17 transacciones COMMIT, ROLLBACK, SAVEPOINT

start transaction;

insert into venta(id_cliente, id_producto, fecha, cantidad) values (3, 1, "2026-10-10", 1);
insert into venta(id_cliente, id_producto, fecha, cantidad) values (3, 4, "2026-10-10", 2);

update producto set stock = stock - 1 where id_producto = 1;
update producto set stock = stock - 2 where id_producto = 4;

-- Dentro de la transacción vemos los cambios:
select id_producto, nombre, stock from producto where id_producto in (1,4);
select count(*) as ventas from venta;

rollback;

-- Tras el ROLLBACK todo ha vuelto atrás:
select id_producto, nombre, stock from producto where id_producto in (1,4);
select count(*) as ventas from venta;

-- ahora con commit

start transaction;

insert into venta(id_cliente, id_producto, fecha, cantidad) values (3, 1, "2026-10-10", 1);
insert into venta(id_cliente, id_producto, fecha, cantidad) values (3, 4, "2026-10-10", 2);
update producto set stock = stock - 1 where id_producto = 1;
update producto set stock = stock - 2 where id_producto = 4;

-- Dentro de la transacción vemos los cambios:
select id_producto, nombre, stock from producto where id_producto in (1,4);
select count(*) as ventas from venta;

commit;

-- comprobamos el cambio
select id_producto, nombre, stock from producto where id_producto in (1,4);
select count(*) as ventas from venta;

-- ahora usando SAVEPPOINT
start transaction;

update producto set precio = 519.00 where id_producto = 1; -- id del portatil HP
savepoint despues_del_portatil;
update producto set precio = 149.00 where id_producto = 4; -- raton(error de tecleo)

select id_producto, nombre, precio from producto where id_producto in (1,4);

rollback to despues_del_portatil; -- deshace solo lo posterior al savepoint

select id_producto, nombre, precio from producto where id_producto in (1,4);

commit;

-- paso 18 copiar, renombrar y borrar tablas

create table producto_caro like producto;
insert into producto_caro select * from producto where precio > 100;
select * from producto_caro;

-- le cambiamos el nombre
rename table producto_caro to productos_destacados;
show tables;

-- borrar sin TRUNCATE
delete from productos_destacados where id_producto > 0;
insert into productos_destacados (nombre, marca, precio) values ("Prueba 1", "HP", 5.00);
select id_producto, nombre from productos_destacados;

-- borrar con TRUNCATE
truncate table productos_destacados;
insert into productos_destacados (nombre, marca, precio) values ("Prueba 2", "HP", 5.00);
select id_producto, nombre from productos_destacados;

-- borrar tabla con DROP
DROP TABLE productos_destacados;
DROP TABLE productos_destacados;
DROP TABLE IF EXISTS productos_destacados;
SHOW TABLES;

-- ejercicios propuestos

-- ejercicio 1
select nombre, stock from producto where stock < 30 order by stock asc;

-- ejercicio 2
select * from cliente where ciudad like "M%";

-- ejercicio 3
select * from cliente where email is null order by nombre;

-- ejercicio 4
select nombre, marca, precio from producto where marca = "Logitech" and precio < 14;

-- ejercicio 5
update producto set precio = precio * 1.10 where id_producto in (5, 8);
select id_producto, nombre, precio from producto where id_producto in (5,8);

-- ejercicio 6
insert into proveedor(nombre, ciudad, telefono) values ("kingston", "Sevilla", "9800005");
insert into compra (id_proveedor, id_producto, fecha, cantidad, coste) values (last_insert_id(), 8, "2026-10-26", 100, 5.00);
select * from compra where fecha = "2026-10-26";

-- ejercicio 7
select p.nombre, sum(c.cantidad * c.coste) as total_gastado from proveedor p join compra c on (p.id_proveedor = c.id_proveedor) group by p.nombre order by total_gastado desc;