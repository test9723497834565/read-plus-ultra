create table plus_ultra.words_to_read (
  id      number
 ,freq    number
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