--Ejercicio 1 Inner Join
/*
1.Inner Join
a) Despliegue la información de los cursos: 
clave grupo, cupo_maximo, nombre del profesor y horario (día semana, hora inicio, hora fin ) 
para la asignatura CALCULO 2 , en el semestre 2008-1 empleando notación SQL estándar.
R: Se obtienen 10 registros.
*/
--a)

SELECT C.CLAVE_GRUPO, C.CUPO_MAXIMO, P.NOMBRE, H.DIA_SEMANA, H.HORA_INICIO, H.HORA_FIN
FROM ASIGNATURA A, CURSO C 
WHERE (A.ASIGNATURA_ID = C.ASIGNATURA_ID
AND PROFESOR P) 
WHERE (C.PROFESOR_ID = P.PROFESOR_ID
AND CURSO_HORARIO CH) 
WHERE (C.CURSO_ID  =CH.CURSO_ID
AND HORARIO H)
WHERE (CH.HORARIO_ID = H.HORARIO_ID
AND SEMESTRE S) 
WHERE (C.SEMESTRE_ID = S.SEMESTRE_ID)
WHERE (A.NOMBRE='CALCULO 2' AND S.ANIO='2008' AND S.PERIODO = '1');

/*
b) Mostrar el nombre de los cursos, su identificador y 
su clave de grupo que actualmente están siendo cursados por estudiantes.
Considerando que los cursos que actualmente se están cursando, 
son aquellos a los que no se les ha asignado una calificación. Usar cualquier notación.
R: Se obtiene 1 registro
*/

SELECT A.NOMBRE, A.ASIGNATURA_ID, C.CLAVE_GRUPO
FROM ASIGNATURA A
Inner Join CURSO C on C.ASIGNATURA_ID = A.ASIGNATURA_ID
Inner  Join ESTUDIANTE_INSCRITO EI ON C.CURSO_ID = EI.CURSO_ID
WHERE EI.CALIFICACION is null; 

/*
2. Natural Join
a) Generar un reporte que muestre todos los datos del profesor KRAUCE, 
así como todos los datos de los cursos que imparte. Empleando natural join. R: Se obtienen 3 registros.
*/
SELECT * FROM PROFESOR P
Natural Join CURSO C
WHERE P.APELLIDO_PATERNO = 'KRAUCE';

/*
b) Generar una sentencia SQL que muestre el identificador del profesor, 
su nombre, sus apellidos, y la clave del grupo de todos los cursos que se imparten en el semestre_id = 1 
de la asignatura BASES DE DATOS.
Emplear:
i)
• Sintaxis anterior.

*/
SELECT P.PROFESOR_ID, P.NOMBRE, P.APELLIDO_PATERNO, P.APELLIDO_MATERNO, C.CLAVE_GRUPO
FROM PROFESOR P, CURSO C
WHERE SEMESTRE_ID = 1 AND ASIGNATURA_ID = 13;

--ii.
--• Natural Join.

SELECT PROFESOR_ID, NOMBRE, APELLIDO_PATERNO, APELLIDO_MATERNO, CLAVE_GRUPO
FROM PROFESOR
Natural Join CURSO;

/*
3.Outer Join
a) Se desea generar un reporte de todos los estudiantes que pertenecen al plan de estudios con id = 2, 
así como de los posibles exámenes extraordinarios que han presentado.
*/
SELECT NOMBRE, NUM_EXAMEN
FROM ESTUDIANTE
FULL OUTTER JOIN ESTUDIANTE_EXTRAORDINARIO ON ESTUDIANTE.ESTUDIANTE_ID=ESTUDIANTE_EXTRAORDINARIO.ESTUDIANTE_ID
FULL OUTTER JOIN PLAN_ESTUDIOS ON ESTUDIANTE.PLAN_ESTUDIOS_ID=PLAN_ESTUDIOS_ID.PLAN_ESTUDIOS_ID
WHERE ESTUDIANTE.PLAN_ESTUDIOS_ID=2;

/*
b.Mostrar un reporte de los profesores existentes en la escuela. Los datos del reporte son:
• Nombre y apellidos del profesor
• Identificador del semestre
• De existir, clave del grupo, identificador de la asignatura e identificador del
semestre de los cursos que ha impartido.
• Emplear: sintaxis estándar y sintaxis anterior.
R: Se obtienen 43 registros, de los cuales, los primeros 11 tienen valores nulos.
*/
SELECT P.NOMBRE, P.APELLIDO_PATERNO, P.APELLIDO_MATERNO, C.CLAVE_GRUPO
FROM PROFESOR P
FULL OUTER JOIN CURSO C ON C.PROFESOR_ID=P.PROFESOR_ID WHERE EXISTS (
SELECT C.CLAVE_GRUPO, A.NOMBRE
FROM CURSO
FULL OUTER JOIN ASIGNATURA A ON C.ASIGNATURA_ID=A.ASIGNATURA_ID
FULL OUTER JOIN SEMESTRE S ON S.SEMESTRE_ID = C.SEMESTRE_ID);

/*
4.Self Join
a.Generar un reporte de todas las asignaturas que tengan 8 créditos. Los datos que debe mostrar es la siguiente:
• Nombre de la asignatura
• Créditos
• Clave del plan de estudios
• Nombre de la asignatura requerida (si existe)
Emplear sintaxis SQL estándar.
R: Se obtienen 5 registros, 2 de ellos con valores nulos.
*/

SELECT A.NOMBRE, A.CREDITOS, A.PLAN_ESTUDIOS_ID, B.NOMBRE AS ASIGNATURA_REQUERIDA
FROM ASIGNATURA A, ASIGNATURA B
WHERE A.CREDITOS=8 AND A.ASIGNATURA_REQUERIDA_ID=B.ASIGNATURA_ID
UNION ( 
SELECT NOMBRE, CREDITOS, PLAN_ESTUDIOS_ID
FROM ASIGNATURA
WHERE CREDITOS=8
MINUS SELECT A.NOMBRE, A.CREDITOS, A.PLAN_ESTUDIOS_ID, NULL
FROM ASIGNATURA A
WHERE CREDITOS=8 AND EXISTS(SELECT NOMBRE FROM ASIGNATURA B 
WHERE A.CREDITOS=8 AND A.ASIGNATURA_REQUERIDA_ID=B.ASIGNATURA_ID)
);

/*
5. Cross Join
a.Genere una consulta que muestre el resultado de multiplicar las entidades plan_estudios y horario. 
Emplear sintaxis anterior y sintaxis estándar.
R: Se obtienen 57 registros.
Subconsultas
*/
SELECT *
FROM PLAN_ESTUDIOS CROSS JOIN HORARIO;

/*
1.Subconsulta en cláusula Select
Se desea generar un reporte que muestre la distribución de las edades de los alumnos de la universidad.
El reporte debe contener: nombre, apellido paterno, apellido materno, fecha_nacimiento, edad_promedio y edad.
La columna EDAD_PROMEDIO corresponde con la edad promedio de todos los estudiantes para mostrarse como referencia, 
y la columna EDAD, contiene la edad en años que tiene el alumno. 
Genere una sentencia SQL que obtenga los datos del reporte.
R: Se debe obtener 23 registros, la edad promedio es 37 y se repite en todos los
registros.
*/ 
SELECT NOMBRE, APELLIDO_PATERNO, APELLIDO_MATERNO, FECHA_NACIMIENTO, (SYSDATE-FECHA_NACIMIENTO)/365 AS EDAD, 
'EDAD_PROMEDIO' AS EDAD_PROM, (SELECT AVG((SYSDATE-FECHA_NACIMIENTO)/365) FROM ESTUDIANTE)
FROM ESTUDIANTE;

/*2. Subconsulta en  cláusula Where
Determinar el nombre de las asignaturas, la clave del grupo, nombre, apellidos y
fecha de nacimiento del profesor más joven que imparte cursos en la universidad.
R: Se debe obtener 2 registros.
*/
SELECT A.NOMBRE, C.CLAVE_GRUPO, P.NOMBRE, P.APELLIDO_PATERNO, P.APELLIDO_MATERNO, P.FECHA_NACIMIENTO
FROM PROFESOR P
INNER JOIN CURSO C ON P.PROFESOR_ID=C.PROFESOR_ID
INNER JOIN ASIGNATURA A ON C.ASIGNATURA_ID=A.ASIGNATURA_ID
WHERE FECHA_NACIMIENTO IN (SELECT FECHA_NACIMIENTO
FROM (SELECT FECHA_NACIMIENTO FROM PROFESOR NATURAL JOIN CURSO GROUP BY FECHA_NACIMIENTO ORDER BY 1 DESC)
WHERE ROWNUM <=1);

/*3. Subconsulta en cláusula FROM
Se desea generar un reporte que muestre todos los datos de las asignaturas, 
y número de cursos que se crearon para todas aquellas asignaturas impartidas durante el semestre 2008-1 (ID =1). 
En caso que solo se hayan creado 3 o menos cursos, estos no deben mostrarse en el resultado.
Considerar los siguientes 2 escenarios:

i. Generar una consulta empleando una subconsulta en la cláusula select.
ii. ¿Será posible generar la consulta sin emplear subconsultas? En caso afirmativo, generar la consulta.r.

R: Se obtienen 4 registros.
*/
SELECT NOMBRE, COUNT(NOMBRE) AS NUM_CURSOS
FROM (SELECT * FROM ASIGNATURA NATURAL JOIN CURSO)
GROUP BY NOMBRE
HAVING COUNT(*)>3;







