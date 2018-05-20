package read.plusUltra.startSession;

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
public class StartSession {

		private static final Logger log = LoggerFactory.getLogger(StartSession.class);

		private final SimpleJdbcCall call;

		@Autowired
		public StartSession(JdbcTemplate jdbcTemplate) {
			this.call = new SimpleJdbcCall(jdbcTemplate)
							.withSchemaName("plus_ultra")
							.withCatalogName("read")
							.withProcedureName("start_session");
		}

		@PostMapping("/start-session")
		public void sendStats(@RequestBody StartSessionRequest request) {
			log.debug("start-session");
			
			SqlParameterSource in = new MapSqlParameterSource()
					.addValue("I_SESSION_TYPE", request.getSessionType())
					.addValue("I_START", request.getStart());
					
			call.execute(in);
			
		}

}
