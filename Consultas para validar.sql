CREATE DATABASE peliculas_db;

-- Consultas tabla tb_pelicula
Use peliculas_db;
SHOW tables;
select * from tb_pelicula;
select * from tb_resena;

-- Ver atributos
Desc tb_pelicula;

-- Por si la info no se sube correcta (para limpiar)
truncate table tb_pelicula;
