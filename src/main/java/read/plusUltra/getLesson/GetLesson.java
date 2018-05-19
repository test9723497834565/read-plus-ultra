package read.plusUltra.getLesson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetLesson {

	private static final Logger log = LoggerFactory.getLogger(GetLesson.class);

	private final SimpleJdbcCall call;

	@Autowired
	public GetLesson(JdbcTemplate jdbcTemplate) {
		this.call = new SimpleJdbcCall(jdbcTemplate).withSchemaName("plus_ultra").withCatalogName("read")
				.withProcedureName("get_words")
				.returningResultSet("o_words", BeanPropertyRowMapper.newInstance(Word.class));
		;
	}

	@GetMapping("/get-lesson")
	GetLessonResponse getLesson() {
		log.debug("get-lesson");
		Map<String, Object> result = call.execute(new HashMap<String, Object>(0));
		List<Word> list = (List<Word>) result.get("o_words");
		return new GetLessonResponse(list);
	}

}
