select rowid, time_start, time_end_temp from session_stat where session_type = 'read' and time_end is null;

select * from session_stat;

delete from session_stat;

select rowid, coalesce(time_end_temp, time_start)
      from session_stat where session_type = 'read' and time_end is null order by time_start;
      

select * from read_stat where id = 10 order by time_start desc;

update word set mastered = 0;
update sylllable set mastered = 0;

select * from words_to_read where copied = 'Y';

select * from word;

select * from syllable;

select * from read_level;

select id from read_level where ended is null;

select coalesce(max(id),0) + 1  from read_level;



delete from syllable;
delete from word_syllable;
delete from word;
delete from session_stat;
delete from read_stat;
delete from read_level;
update words_to_read set copied = 'N' where copied = 'Y';


select * from words_to_read order by freq desc;

update words_to_read set s1 = 'est' where s1 = 'être' and s2 = null;
update words_to_read set s1 = 'as', s2= null where s1 = 'a' and s2 = 'voir' and s3 = null;
update words_to_read set s1 = 'fais' where s1 = 'faire' and s2 = null and s3 = null;
update words_to_read set s1 = 'dis' where s1 = 'dire' and s2 = null and s3 = null;
update words_to_read set s1 = 'peux', s2=null where s1 = 'pou' and s2 = 'voir' and s3 = null;
update words_to_read set s1 = 'sais', s2=null where s1 = 'sa' and s2 = 'voir' and s3 = null;
update words_to_read set s1 = 'suis' where s1 = 'sui' and s2 = 'vre' and s3 = null;
update words_to_read set s1 = 'prend' where s1 = 'prendre' and s2 = null and s3 = null;
update words_to_read set s1 = 'crois' where s1 = 'croire' and s2 = null and s3 = null;


