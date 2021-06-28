create database sistemaPCX;
use sistemaPCX;

create table Producto(
  codProducto INT(5) NOT NULL,
  nombreProducto VARCHAR(30) NOT NULL,
  stock INT(3) NOT NULL,
  precioUnitario INT(7) NOT NULL,
    primary key(codProducto) 
);

create table Cliente(
  codCli INT(5) NOT NULL AUTO_INCREMENT,
  nombreCli VARCHAR(30) NOT NULL,
  correoCli VARCHAR(40) NULL,
  telefonoCli INT(10) NULL,
    primary key(codCli) 
);

create table Vendedor(
 codVend INT(5) NOT NULL AUTO_INCREMENT,
  nomVend VARCHAR(30) NOT NULL,
  telefonoVend INT(10) NULL,
  PRIMARY KEY (codVend)
);


create table venta(

	codVenta INT(5) NOT NULL AUTO_INCREMENT,
  cantidad INT(4) NOT NULL,
  subTotal INT(7) NOT NULL,
  Cliente_codCli INT(5) NOT NULL,
  Vendedor_codVend INT(5) NOT NULL,
  Producto_codProducto INT(5) NOT NULL,
  PRIMARY KEY (codVenta, Cliente_codCli, Vendedor_codVend, Producto_codProducto),
  INDEX `fk_Venta_Cliente_idx` (Cliente_codCli),
  INDEX `fk_Venta_Vendedor1_idx` (Vendedor_codVend),
  INDEX `fk_Venta_Producto1_idx` (Producto_codProducto),
    CONSTRAINT `fk_Venta_Cliente`
    FOREIGN KEY (Cliente_codCli)REFERENCES Cliente (CodCli),
    CONSTRAINT `fk_Venta_Vendedor1`
    FOREIGN KEY (Vendedor_codVend)REFERENCES Vendedor(codVend),
    CONSTRAINT `fk_Venta_Producto1`
    FOREIGN KEY (Producto_codProducto)REFERENCES Producto (codProducto)
);

INSERT INTO `cliente` (`codCli`, `nombreCli`, `correoCli`, `telefonoCli`) VALUES
(1, 'Antonio', 'antonio@gmail.com', 89887796),
(2, 'Juan', 'juan@gmail.com', 78655454),
(3, 'Joshua', 'joshua@gmail.com', 87665456),
(4, 'Sebastián', 'sebastian@gmail.com', 87697656);

INSERT INTO `producto` (`codProducto`, `nombreProducto`, `stock`, `precioUnitario`) VALUES
(12345, 'GTX 610', 100, 65000),
(12346, 'Pendrive Kingston 8gb ', 50, 3500),
(12347, 'Mouse HP 340', 150, 4000),
(12348, 'GTX 650', 200, 85000);

INSERT INTO `vendedor` (`codVend`, `nomVend`, `telefonoVend`) VALUES
(1, 'Alejandro Correa', 85493493),
(2, 'José Mora', 93944334),
(3, 'Karla Acuña', 94894594),
(4, 'Gerardo Díaz', 83423445);