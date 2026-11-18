use tienda_algaba;

describe categoria;
describe cliente;
describe compra;
describe producto;


insert into categoria(nombre) values
("almacenamiento"),
("refrigeracion"),
("Cableado");

select * from categoria;

insert into producto(nombre, precio, stock, id_categoria) values
("Disco duro SSD 1TB Algaba", 179.99, 20, 3),
("Disco duro HDD 2TB Barracuda", 119.99, 12, 3),
("pasta Termica", 7.99, 4, 4),
("Refrigeracion liquida corsair", 64.99, 17, 4),
("Cable HDMI", 6.99, 10, 4),
("Cable DisplayPort", 9.99, 6, 4),
("Disco duro portatil 560GB", 89.99, 21, 3),
("Ventiladores Corsair pck de 4 unidades", 19.99, 20, 3);

select * from producto;

insert into cliente(nombre) values
("Maria"),
("Enrique"),
("Jose");

select * from cliente;

insert into compra(id_cliente, id_producto) values
(5, 5),
(4, 5),
(3, 9),
(5, 10),
(4, 8);

