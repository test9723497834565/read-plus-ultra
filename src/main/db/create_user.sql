create tablespace plus_ultra
datafile 'plus_ultra.dat'
size 10M autoextend on;

create temporary tablespace plus_ultra_temp
tempfile 'plus_ultra_temp.dat'
size 5M autoextend on;

create user plus_ultra identified by 'plus_ultra'
default tablespace plus_ultra
temporary tablespace plus_ultra_temp;

grant connect to plus_ultra;
grant create table to plus_ultra;
grant create sequence to plus_ultra;
grant unlimited tablespace to plus_ultra;