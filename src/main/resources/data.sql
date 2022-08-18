drop table if exists suministra;
drop table if exists piezas;
drop table if exists proveedores;

create table piezas(
	codigo int auto_increment,
    nombre varchar(100),
    primary key(codigo)
);

create table proveedores(
	id char(4),
    nombre varchar(100),
    primary key(id)
);

create table suministra(
	id int auto_increment,
	codigo_pieza int not null,
    id_proveedor char(4) not null,
    precio int,
    primary key(id),
    constraint fk_piezas_suministra foreign key (codigo_pieza)
    references piezas(codigo) ON DELETE CASCADE ON UPDATE CASCADE,
	constraint fk_proveedores_suministra foreign key (id_proveedor)
    references proveedores(id) ON DELETE CASCADE ON UPDATE CASCADE
);

insert into piezas(nombre)values ('pieza1'),('pieza2'),('pieza3'),('pieza4'),('pieza5');
insert into proveedores(id,nombre)values ('pv01','proveedor1'),('pv02','proveedor2'),('pv03','proveedor3'),('pv04','proveedor4'),('pv05','proveedor5');
insert into suministra(codigo_pieza,id_proveedor,precio)values (1,'pv02',100),(11,'pv03',250),(21,'pv02',322),(31,'pv01',174),(41,'pv04',35);