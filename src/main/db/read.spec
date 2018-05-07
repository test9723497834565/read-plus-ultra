create or replace package plus_ultra.read as 

	-- mastered levels
	c_not_practiced     constant number := 0;
	c_practiced         constant number := 1;
	c_improving         constant number := 2;
	c_mastered          constant number := 3;
	
	procedure get_words(o_words in out sys_refcursor);

end read;