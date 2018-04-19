-- Imprime el plan de estudios actual

SELECT CLAVE, FECHA_APROBACION, FECHA_INICIO
	FROM PLAN_ESTUDIOS
	WHERE FECHA_FIN = NULL;

/*
	
	SELECT *FROM plan_estudios
		where fecha_fin is null;

*/


--Obtiene los dias que faltan para terminar el anio

SELECT (365 - DATEPART(dayofyear, sysdate) as 'Dias'
/*
	
	SELECT to_date('31/DEC/18') - sysdate
	FROM dual;
	
*/





--Muestra el RFC y fecha de nacimiento de los profesores
SELECT FECHA_NACIMIENTO, RFC
	FROM PROFESOR
	WHERE FECHA_NACIMIENTO BETWEEN '1950/01/01' AND '1955/12/31' 
	AND FECHA_NACIMIENTO BETWEEN '1960/01/01' AND '1965/12/31'; 



/*
	
	SELECT nombre, RFC, fecha_nacimiento
		FROM profesor
		WHERE to_char(fecha_nacimiento) >= 1950
		AND to_char(fecha_nacimiento, 'yyyy')<= 1955;


*/