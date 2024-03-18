create or replace view v_tags_publication
	as
		select 
			p.*, t.*
		from
			tags_publication tp 
		join "publication" p on tp.id_publication = p.id_publication
		join tags t on tp.tag = t.id_tag ;

select  * from v_tags_publication;

create or replace view v_tags_publication_lined
	as
		select
			id_publication, description, nombre_vue, id_profil,
			longitude, latitude, date_debut, date_fin,
			string_agg( id_tag::character varying, ',' order by id_tag  ) as id_tags,
			string_agg( tag::character varying, ' ' order by tag ) as tags 
		from v_tags_publication
		group by
			id_publication, description, nombre_vue, id_profil,longitude, latitude, date_debut, date_fin;

select * from v_tags_publication_lined;

drop view v_tags_publication_commentaires cascade;
create or replace view v_tags_publication_commentaires
	as
		select 
			vtp.*, 
			c.id_commentaire , c.valeur , c.id_profil as commentateur
		from 
			v_tags_publication_lined vtp
		left join commentaire c on vtp.id_publication = c.id_publication;

create or replace view v_tags_publication_commentaires_lined
	as
		select
			id_publication, description, nombre_vue, id_profil,
			longitude, latitude, date_debut, date_fin, 
			id_tags, tags,
			string_agg( valeur, ' ' order by valeur ) as value 
			, commentateur
		from 
		 v_tags_publication_commentaires
		group by
			id_publication, description, nombre_vue, id_profil, 
			longitude, latitude, date_debut, date_fin,
			id_tags, tags, commentateur
		;
	
		
		
select * from v_tags_publication_commentaires_lined ;


create or replace view elastic_research 
	as
		select
			*,
			coalesce( description, '' ) || '' ||
			coalesce( tags, '' ) || '' ||
			coalesce( value, '' ) as data
		from 
			v_tags_publication_commentaires_lined;

create or replace view elastic_research_1
	as
		select
			*,
			to_tsvector( 'english', data )::tsvector  as indexing
		from 
			elastic_research;


		
select * from elastic_research ;
select * from elastic_research_1;
		
		




