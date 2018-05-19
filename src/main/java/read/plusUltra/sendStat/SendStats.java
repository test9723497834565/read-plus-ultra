package read.plusUltra.sendStat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	public void sendStats(@RequestBody SendStatsRequest request) {
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
