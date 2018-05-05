create or replace package plus_ultra.read as 

	procedure get_words(o_words in out sys_refcursor);

end read;