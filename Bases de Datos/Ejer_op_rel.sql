/*SELECT FECHA_NACIMIENTO, NOMBRE, RFC
	FROM PROFESOR
	WHERE to_char(FECHA_NACIMIENTO, 'yyyy') >= 1950;

*/

--	Ejercicio de imprimir datos del profesor entre rangos de anios

SELECT NOMBRE, RFC, FECHA_NACIMIENTO
	FROM PROFESOR
	WHERE FECHA_NACIMIENTO >= (to_date('1950', 'yyyy'))

intersect 

SELECT NOMBRE, RFC, FECHA_NACIMIENTO
	FROM PROFESOR
	WHERE FECHA_NACIMIENTO <= (to_date('1955', 'yyyy'))

union

SELECT NOMBRE, RFC, FECHA_NACIMIENTO
	FROM PROFESOR
	WHERE FECHA_NACIMIENTO >= (to_date('1960', 'yyyy'))

intersect 

SELECT NOMBRE, RFC, FECHA_NACIMIENTO
	FROM PROFESOR
	WHERE FECHA_NACIMIENTO <= (to_date('1965', 'yyyy'))


-- Obtener los datos del profesor



SELECT *			--SELECT * indica que imprime todos los datos
	FROM PROFESOR
	WHERE FECHA_NACIMIENTO >= (to_date('1970', 'yyyy'))

intersect

SELECT *
	FROM PROFESOR
	WHERE NOMBRE in ('JUAN', 'LUISA' , 'LENIN')

intersect

SELECT *
	FROM PROFESOR
	WHERE APELLIDO_PATERNO like '%R';



--Ejercicio 3

SELECT CURSO_ID, CLAVE_GRUPO
	FROM CURSO
	WHERE CUPO_MAXIMO = 30;

MINUS

SELECT CURSO, CLAVE_GRUPO
	FROM CURSO
	WHERE CLAVE_GRUPO = 001;