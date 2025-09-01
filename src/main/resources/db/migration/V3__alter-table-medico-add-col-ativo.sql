alter table medicos add ativo boolean not null;
update medicos set ativo = 1;