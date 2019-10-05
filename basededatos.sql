Base de datos petlover

Tablas: Perros, Gatos, Usuarios, Licencias, Versiones y Notificaciones

-----------------------------------

create database petlover;

create table versiones(
version varchar(9) not null,
fecha date not null,
primary key(version)
)default charset=latin1;

SELECT version FROM versiones WHERE version='0.05.01';

create table licencias(
id int not null AUTO_INCREMENT,
code varchar(20) not null,
id_user varchar(50),
activo int(1) not null,
fecha date,
ip varchar(13),
primary key(id)
)default charset=latin1;

create table usuarios(
id int not null AUTO_INCREMENT,
user varchar(20) not null,
pass varchar(90) not null,
email varchar(90) not null,
edo varchar(50) not null,
org varchar(90) not null,
posc varchar(4) not null,
carpeta varchar(65),
vinc int(1) not null,
primary key(id)
)default charset=latin1;

create table gatos(
id int not null AUTO_INCREMENT,
nomMasc varchar(30) not null,
codigoQR varchar(15) not null,
nomProp varchar(90) not null,
emailDue varchar(90),
numTel varchar(20) not null,
direProp varchar(90),
edoReg varchar(50),
imagen longblob,
rabia varchar(10),
leu varchar(10),
calic varchar(10),
panle varchar(10),
rino varchar(10),
primary key(id)
)default charset=latin1;

create table perros(
id int not null AUTO_INCREMENT,
nomMasc varchar(30) not null,
codigoQR varchar(15) not null,
nomProp varchar(90) not null,
emailDue varchar(90),
numTel varchar(20) not null,
direProp varchar(90),
edoReg varchar(50),
imagen longblob,
parvo varchar(10),
moqui varchar(10),
adeno varchar(10),
rabia varchar(10),
parain varchar(10),
borda varchar(10),
leptos varchar(10),
influ varchar(10),
primary key(id)
)default charset=latin1;

create table notificaciones(
id int not null AUTO_INCREMENT,
mensaje varchar(100) not null,
primary key(id)
)default charset=latin1;


