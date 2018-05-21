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


with calendar as (
  select trunc(sysdate)-89 + rownum as day
  from dual
  connect by rownum < 90
)
select a.day, coalesce(round(sum((coalesce(time_end, time_end_temp)-time_start) * 60.0 * 24.0 )),0) minutes
from calendar a left outer join session_stat b on a.day = trunc(b.time_start) and session_type = 'read'
group by a.day
order by a.day;

with calendar as (
        select to_date('01_01_2018','dd_mm_yyyy') + rownum - 1 as day
        from dual
        connect by rownum < to_date('01_03_2018','dd_mm_yyyy') - to_date('01_01_2018','dd_mm_yyyy')
    )
select rownum as "S.No", to_date(day,'dd_mm_yyyy') as "Cal_Dt", to_char(day,'day') as "DayName"
from calendar
