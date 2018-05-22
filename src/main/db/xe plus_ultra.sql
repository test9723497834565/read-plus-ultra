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


select * from session_stat
