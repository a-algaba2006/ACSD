drop database if exists gimnasio;
-- crear la base de datos
create database gimnasio;
use gimnasio;

-- crear las tablas
create table monitor (
	id_monitor int primary key auto_increment,
    nombre varchar(50),
    ciudad varchar(40),
    telefono varchar(9)
);

create table socio (
	id_socio int primary key auto_increment,
    nombre varchar(50),
    ciudad varchar(40),
    email varchar(80)
);

create table actividad(
	id_actividad int primary key auto_increment,
    nombre varchar(40),
    precio decimal(6,2),
    id_monitor int,
    plazas int,
    foreign key (id_monitor) references monitor(id_monitor)
);

create table inscripcion(
	id_inscripcion int primary key auto_increment,
    id_socio int not null,
    id_actividad int not null,
    fecha date not null,
    foreign key (id_socio) references socio(id_socio),
    foreign key (id_actividad) references actividad(id_actividad)
);

show tables;

describe actividad;

-- alterar tablas añadir, modificar o eliminar columnas de una tabla
alter table socio add column telefono varchar(9);
alter table socio modify column telefono varchar(15);
alter table socio drop column telefono;
describe socio;

-- insertar datos
insert into socio(nombre, ciudad, email) values ("Alberto", "Malaga", "alberto.algaba@davante.org");
select * from socio;

-- consultas sencillas

-- 1
select * from socio;

-- 2
select nombre, email from socio where ciudad like "%Malaga%";

-- 3
select nombre, precio from actividad where precio < 20 order by precio;

-- 4
select * from socio where nombre like "A%";

-- 5 
select * from socio where email is null;

-- 6
select ciudad from socio;

-- 7
select distinct ciudad from socio;

-- 8
select nombre, precio from actividad where precio between 15 and 20;

-- 9
select nombre from actividad where precio < 20 and plazas >= 10;

-- modificar datos
-- 1
update socio set ciudad = "Cordoba" where id_socio = 3;
select * from socio where nombre like "%Carla%";

-- 2
update actividad set precio = precio * 1.10 where nombre = "Yoga";
select * from actividad where nombre like "%Yoga%";

-- 3
update actividad set plazas = plazas - 1 where nombre like "%Boxeo%";
select * from actividad where nombre like "%Boxeo%";

-- consultas con join

-- 1
select s.nombre as "nombre del socio", a.nombre as "nombre de la actividad", i.fecha from actividad a join inscripcion i on (a.id_actividad = i.id_actividad)
join socio s on (i.id_socio = s.id_socio);

-- 2
select s.id_socio, s.nombre as "nombre del socio", a.nombre as "nombre de la actividad" from socio s join inscripcion i on (s.id_socio = i.id_socio) 
join actividad a on (i.id_actividad = a.id_actividad) where s.id_socio = 1;

-- 3
select a.nombre, count(a.nombre) from actividad a join inscripcion i on (a.id_actividad = i.id_actividad) 
join socio s on (i.id_socio = s.id_socio) group by a.nombre;

-- 4
select s.nombre from actividad a join inscripcion i on (a.id_actividad = i.id_actividad)
join socio s on (i.id_socio = s.id_socio);

-- 5
select s.nombre, i.id_actividad from socio s left join inscripcion i on (s.id_socio = i.id_socio) where i.id_socio is null;

-- 6
select m.nombre, a.nombre from actividad a join monitor m on (a.id_monitor = m.id_monitor);

-- 7
select m.nombre, count(a.id_actividad) as "numero de actividades" from actividad a
right join monitor m on (a.id_monitor = m.id_monitor) group by m.nombre;

-- borrar datos

-- 1
delete from inscripcion where id_inscripcion = 8;
select * from inscripcion;

-- 2
delete from socio where id_socio = 1; -- no se puede eliminar pq hay datos relacionados a el

-- 3
delete from socio where id_socio = 6; -- este si se borra pq no hay ningun dato relacionado a el
select * from socio;

-- 4
delete from monitor where id_monitor = 1; -- no deja pq hay datos asociados a el
delete from monitor where id_monitor = 3; -- si deja pq no hay ningun dato asociado a el
select * from monitor;