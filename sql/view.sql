
create or replace view v_publication_par_tag as
	select distinct(p.*) from 
		"publication" p  
		join "tags_publication" t
			on p.id_publication = t.id_publication
		join "tags" tag
			on t.tag = tag.id_tag ;

drop view v_publication_par_tag;