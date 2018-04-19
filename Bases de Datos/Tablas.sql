CREATE TABLE Prebe(
Nombre VARCHAR2(30),
Num_Prebe NUMBER(4),
Num_cuenta NUMBER(15)
);

INSERT INTO Prebe VALUES('Armando', 4, 313323371);
INSERT INTO Prebe VALUES('Andrea', 8, 3145374331);
INSERT INTO Prebe VALUES('Lobato', 7, 3134536665);
INSERT INTO Prebe VALUES('Barcenitas', 3, 416823865);


CREATE TABLE Libros(
Nombre VARCHAR2(30),
ISBN NUMBER(10),
Autor VARCHAR2(40),
Precio NUMBER(5)
);

CREATE TABLE Autor(
Nombre VARCHAR2(30),
Narrativa VARCHAR2(40),
Nacimiento VARCHAR2(50),
Edad NUMBER(3)
);


INSERT INTO Libros VALUES('El Retrato de Dorian Gray',313323371, 'Oscar Wilde', 80);
INSERT INTO Libros VALUES('La Iliada',41356372, 'Homero', 50);
INSERT INTO Libros VALUES('Carry',616327843, 'Stephen King', 100);
INSERT INTO Libros VALUES('El coronel no tiene quien le escriba',45639865, 'Gabriel Garcia Marquez', 200);

