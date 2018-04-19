CREATE TABLE Puesto(
	ID_Puesto number(2,0),
	Nivel char(1) NOT NULL,
	Clave varchar(3) NOT NULL,
	Sueldo number(8,2) NOT NULL,
	CONSTRAINT ID_Puesto_Pk PRIMARY KEY(ID_Puesto)

);


CREATE TABLE Emplado(
	ID_ Emplado number(10,0) PRIMARY KEY NOT NULL,
	Nombre varchar(40) NOT NULL
	CONSTRAINT ID_Puesto_FK FOREIGN KEY (ID_Puesto) REFERENCES Puesto(ID_Puesto);

);

RENAME Emplado TO EMPLEADO_TC;
RENAME Puesto TO PUESTO_TC;
ALTER TABLE PUESTO_TC RENAME CONSTRAINT ID_Puesto_Pk TO PUESTO_TC_PK;
ALTER TABLE EMPLEADO_TC RENAME CONSTRAINT ID_Puesto_FK TO PUESTO_TC_FK;