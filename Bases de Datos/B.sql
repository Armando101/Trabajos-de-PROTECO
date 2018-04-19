CREATE TABLE Incidencia(
	Descripcion varchar(40) NOT NULL,
	Fecha_Registro DATE NOT NULL DEFAULT SYSDATE,
	Tipo CHAR(1) NOT NULL DEFAULT 'N',
	Descuento NUMERIC(5,2) NOT NULL DEFAULT 5.5
);

INSERT INTO Incidencia (Descripcion, Tipo, Fecha_Registro, Descuento),
VALUES ('Incidencia 1', 'A');
VALUES ('Incidencia 2');
