
create or replace view v_publication_par_tag as
	select distinct(p.*) from 
		"publication" p  
		join "tags_publication" t
			on p.id_publication = t.id_publication
		join "tags" tag
			on t.tag = tag.id_tag ;

drop view v_publication_par_tag;

select p1_0.id_publication,p1_0.date_debut,p1_0.date_fin,p1_0.description,p1_0.latitude,p1_0.longitude,p1_0.nombre_vue,p1_0.id_profil 
    from publication p1_0 
    left join tags_publication t1_0 
        on p1_0.id_publication=t1_0.id_publication 
    where t1_0.tag=12 and p1_0.id_profil<>8
    offset 1 rows fetch first 10 rows only;