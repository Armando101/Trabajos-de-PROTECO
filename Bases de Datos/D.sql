CREATE TABLE  Concepto_pago(
	concepto_id numeric(10,0)
		constraint Concepto_pago_pk primary key,
	tipo_concepto char(1) not null
		constraint cp_tipo_concepto_chk check (tipo_concepto in ('A', 'B',  'C')),
	clave varchar(3)
		constraint cp_clave_uk unique,
	descrpcion	varchar(255),
	importe numeric(8,2) not null
);