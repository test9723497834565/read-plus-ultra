create table plus_ultra.words_to_read (
  id      number
 ,freq    number		 
 ,copied  char(1)        check (copied in ( 'Y', 'N' )), 
 ,s1      varchar2(10)
 ,s2      varchar2(10)
 ,s3      varchar2(10)
 ,s4      varchar2(10)
 ,s5      varchar2(10)
 ,s6      varchar2(10)
 ,s7      varchar2(10)
 ,s8      varchar2(10)
 ,s9      varchar2(10)
);

create sequence plus_ultra.words_to_read_seq
start with 1
 increment by 1
 nocache
 nocycle;

create sequence plus_ultra.id_gen_seq
start with 1
 increment by 1
 nocache
 nocycle;
 
create table plus_ultra.read_level (
 id		       number
,started       date
,ended         date
,last_started  date
);
 
create table plus_ultra.word (
  id		    number
 ,mastered      number
 ,last_studied  date
 ,read_level_id number
 );

create table plus_ultra.syllable (
  id		    number
 ,mastered      number
 ,text          varchar2(50)
 ,last_studied  date
);

create table plus_ultra.word_syllable (
  word_id		  number
 ,syllable_id	  number
 ,syllable_order  number
);

create table plus_ultra.read_stat (
  id		    number
 ,time_start	date
 ,time_end		date
);

