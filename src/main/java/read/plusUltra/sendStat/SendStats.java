package read.plusUltra.sendStat;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import read.plusUltra.getLesson.GetLesson;
import read.plusUltra.getLesson.GetLessonResponse;
import read.plusUltra.getLesson.Word;

@RestController
public class SendStats {

	private static final Logger log = LoggerFactory.getLogger(SendStats.class);

	private final SimpleJdbcCall call;

	@Autowired
	public SendStats(JdbcTemplate jdbcTemplate) {
		this.call = new SimpleJdbcCall(jdbcTemplate)
						.withSchemaName("plus_ultra")
						.withCatalogName("read")
						.withProcedureName("send_stats");
	}

	@PostMapping("/send-stats")
	public void sendStats(SendStatsRequest request) {
		log.debug("send-stats");
		
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("I_ID", request.getId())
				.addValue("I_TEXT", request.getText())
				.addValue("I_TYPE", request.getType())
				.addValue("I_START", request.getStarted())
				.addValue("I_END", request.getEnded())
				.addValue("I_READ", request.isReadSuccessfully() ? '+' : '-');
				
		call.execute(in);
	}
}
