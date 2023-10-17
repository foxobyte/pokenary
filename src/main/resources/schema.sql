create database if not exists pokenary_db;
use pokenary_db;

--create table if not exists pokemon (
--	pokemon_id integer not null,
--	name varchar(30),
--	national_number smallint,
--    hp tinyint unsigned,
--    attack  tinyint unsigned,
--    defense  tinyint unsigned,
--    special_attack  tinyint unsigned,
--    special_defense  tinyint unsigned,
--    speed  tinyint unsigned,
--	primary key (id)
--) engine=InnoDB;

--create table if not exists ev_yields (
--    ev_yield_id integer not null,
--    hp tinyint unsigned,
--    attack tinyint unsigned,
--    defense tinyint unsigned,
--    special_attack tinyint unsigned,
--    special_defense tinyint unsigned,
--    speed tinyint unsigned
--)
--
--alter table ev_yields add constraint unique_ev_yield unique(hp, attack, defense, special_attack, special_defense, speed);


--create table if not exists player_pokemon (
--	id bigint not null,
--	pokemon_id integer,
--	level tinyint,
--	CHECK (level >= 1 and level <= 100),
--	primary key (id)
--) engine=InnoDB
