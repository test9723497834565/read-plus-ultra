create or replace package plus_ultra.read as 

	-- mastered levels
	c_not_practiced     constant number := 0;
	c_practiced         constant number := 1;
	c_improving         constant number := 2;
	c_mastered          constant number := 3;
	
	-- types
	c_word          constant varchar2(1) := 'w';
	c_syllable      constant varchar2(1) := 's';
	
	procedure get_words(o_words in out sys_refcursor);
	
	procedure send_stats(
	  i_id       number   
	 ,i_text     varchar2
	 ,i_type     varchar2
	 ,i_start    date
	 ,i_end      date
	 ,i_read     varchar2);
   
  procedure start_session(
	  i_session_type     varchar2
	 ,i_start            date
  );

end read;