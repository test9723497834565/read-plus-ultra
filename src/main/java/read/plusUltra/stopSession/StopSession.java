package read.plusUltra.stopSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StopSession {

		private static final Logger log = LoggerFactory.getLogger(StopSession.class);

		private final SimpleJdbcCall call;

		@Autowired
		public StopSession(JdbcTemplate jdbcTemplate) {
			this.call = new SimpleJdbcCall(jdbcTemplate)
							.withSchemaName("plus_ultra")
							.withCatalogName("read")
							.withProcedureName("stop_session");
		}

		@PostMapping("/stop-session")
		public String sendStats(@RequestBody StopSessionRequest request) {
			log.debug("stop-session");
			
			SqlParameterSource in = new MapSqlParameterSource()
					.addValue("I_SESSION_TYPE", request.getSessionType())
					.addValue("I_STOP", request.getStop());
					
			call.execute(in);
			return "{}";
		}

}

