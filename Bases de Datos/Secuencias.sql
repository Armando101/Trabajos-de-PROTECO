/*

CREATE SECUENCE secuencia 
INCREMENT BY       Cuanto incrementa el valor
START WHITH        Valor de inicio
MAXVALUE n         Valor maximo
MINVALUE n           Valor minimo
Si no ponemos valores minimos o maximos se asigna NOMAXVALUE y NOMINVALUE Y el ciclo iniciaria nuevamente desde 1
CYCLE | NOCYCLE		Despues de que llega al maximo valor vuelve a empezar el ciclo desde el primer numero
CACHE n | NOCACHE		Para que cuando se apage la computadora no se guarden los valores en la memoria cache
Si no asiganmos cahe se asigna por defecto NOCACHE

NEXTVAL Regresa el valor del siguiente elemento de la secuencia 
CURRVAL Regresa el ultimo valor de la secuencia


*/


CREATE SECUENCE secuencia
INCREMENT BY 2
START WHITH 1
MAXVALUE 17
MINVALUE 3
CYCLE	
NOCACHE;

INSERT INTO Doctor VALUES (secuencia.NEXTVAL, 'NOMBRE 1', 30);
INSERT INTO Doctor VALUES (secuencia.NEXTVAL, 'NOMBRE 2', 35);
INSERT INTO Doctor VALUES (secuencia.NEXTVAL, 'NOMBRE 3', 40);
INSERT INTO Doctor VALUES (secuencia.NEXTVAL, 'NOMBRE 4', 45);

--DELETE FROM Doctor WHERE 
SELECT secuencia.CURRVAL FROM DUAL;

/*
crear archivos 
spool <rutaabsoluta> <ADD[P'Sobreescribir']/0 no>


*/