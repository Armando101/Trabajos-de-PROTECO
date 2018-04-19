CREATE TABLE Puesto(
	Puesto_ID Numeric(2,0) NOT NULL,
	Nivel CHAR(1) NOT NULL,
	Clave varchar(3) NOT NULL 
	Sueldo Numeric (8,2) NOT NULL,
	CONSTRAINT UQ UNIQUE( Clave ),
	CONSTRAINT CH CHECK(Nivel IN ('A', 'B', 'C')),
	CONSTRAINT CH CHECK(Sueldo>=0 AND  Sueldo<=100000)
);

ALTER TABLE Puesto
ADD CONSTRAINT PK PRIMARY KEY (Puesto_ID);