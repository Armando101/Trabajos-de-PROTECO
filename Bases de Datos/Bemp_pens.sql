CREATE TABLE Puesto(
	ID_Puesto number(2,0),
	Nivel char(1) NOT NULL,
	Clave varchar(3) NOT NULL,
	Sueldo number(8,2) NOT NULL,
	CONSTRAINT ID_Puesto_Pk PRIMARY KEY(ID_Puesto)

);

CREATE TABLE Pensionada(
	ID_Pensionada number(10,0) NOT NULL,
	Nombre varchar(40) NOT NULL,
	CONSTRAINT ID_Pensionada_Pk PRIMARY KEY(ID_Pensionada)

);

CREATE TABLE Emplado(
	ID_ Emplado number(10,0) PRIMARY KEY NOT NULL,
	Nombre varchar(40) NOT NULL
);

ALTER TABLE ADD CONSTRAINT ID_Puesto_FK FOREIGN KEY (ID_Puesto) REFERENCES Puesto(ID_Puesto);


CREATE TABLE Pensionada_Empleado(

	Porcentaje number(5,2) NOT NULL
	CONSTRAINT ID_Pensionada_FK FOREIGN KEY (ID_Pensionada) REFERENCES Pensionada(ID_Pensionada);
	CONSTRAINT ID_Empleado_FK FOREIGN KEY (ID_Empleado) REFERENCES Puesto(ID_Empleado);

);

