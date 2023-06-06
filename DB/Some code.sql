select * from mascota;

insert into especie(tipo_especie) values("Canino / Perro");

insert into raza(tipo_raza) values("Mestizo"),("Golden Retirever"),("Pastor Aleman"),("Beagle"),("Golden Retriever"),
("Rottweiler"),("Chihuahua"),("Bulldog"),("Labrador"),("Bobtail");

insert into tipo_cita (tipo_cita) values("General"),("Estudio");

select * from veterinario;

SELECT m.id_mascota, m.nombre, m.sexo, m.fecha_nacimiento,m.id_propietario, m.pelaje,m.raza,m.especie, r.tipo_raza, e.tipo_especie ,m.senas_particulares 
             FROM Mascota m
             JOIN raza r ON m.raza = r.id_raza 
             JOIN especie e ON m.especie = e.id_especie 
             WHERE id_propietario = 1;
             
select 
m.*, r.tipo_raza,e.tipo_especie, p.nombre,p.appat,p.apmat from Mascota m Join raza r on m.raza = r.id_raza
join especie e on m.especie = e.id_especie
join propietario p on m.id_propietario=p.id_propietario;

select 
c.*,t.tipo_cita,m.nombre
from cita c join tipo_cita t on c.id_tipo_cita= t.id_tipo_cita
join mascota m on c.id_mascota = m.id_mascota ;