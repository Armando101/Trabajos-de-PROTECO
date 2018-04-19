CREATE TABLE Doctor(
	ID_Doctor NUMBER(4) PRIMARY KEY NOT NULL
);

ALTER TABLE Doctor ADD nombre varchar(30);
ALTER TABLE Doctor ADD edad NUMBER(2);


--select * FROM Doctor 		Muestra la tabla

INSERT INTO Doctor (ID_Doctor, nombre, edad) Values (1, 'Dactar,' '35');  -- = ->	INSERT INTO Doctor Values (1, 'Dactar,' '35');

INSERT INTO Doctor Values (1, 'Dactar,' 35);
INSERT INTO Doctor Values (2, 'Dactar1', 40);
INSERT INTO Doctor Values (3, 'Dactar2,' 45);

ALTER TABLE Doctor ADD CONSTRAINT ck_Edad CHECK(edad) 


CREATE TABLE Paciente(
	ID_Paciente NUMBER(10),
	nombre varchar(30),
	malestar varchar(30),
	altura NUMBER (3,2),
	peso NUMBER(2),
	ID_Doctor NUMBER(4)
	CONSTRAINT p_id_paciente_Pk PRIMARY KEY(ID_Paciente)
);

ALTER TABLE Paciente ADD CONSTRAINT ID_Doctor_fk FOREIGN KEY (ID_Doctor) REFERENCES Doctor(ID_Doctor);     	--TABLE CONSTRAINT