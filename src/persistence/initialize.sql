create table brains (id identity, owner text, type int);
create table things (id identity, name text, type int, description text, shortdesc text, brain int, location int);
create table contents (owner int, contents int);
create table links (location int, link int, name text);
