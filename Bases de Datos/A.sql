CREATE TABLE Calculo_Sueldo(
	Suledo_Mensual NUMERIC(10,2) NOT NULL DEFAULT Sueldo quincenal *2,
	Sueldo_Quincenal NUMERIC(10,2) NOT NULL,
	IVA	NUMERIC(10,2),
	Fecha_Calculo DATE DEFAULT SYSDATE NOT NULL
	); 


INSERT INTO Calculo_Sueldo (Sueldo_Quincenal, IVA)
VALUES (10000, 23);