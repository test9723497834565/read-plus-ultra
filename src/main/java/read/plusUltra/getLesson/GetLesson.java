package read.plusUltra.getLesson;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GetLesson {

	private static final Logger log = LoggerFactory.getLogger(GetLesson.class);

	private final SimpleJdbcCall call;

	@Autowired
	public GetLesson(JdbcTemplate jdbcTemplate) {
		this.call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("read_actor");
	}
	
	@PostMapping("/flat-bi-directional")
	RestFlat flatBiDirectional(@RequestBody RestFlat request, @RequestHeader HttpHeaders headers) {		
		
		String header = headers.getFirst("PPAUTH");
		
		log.info("PPAUTH = " + header);
		
		return new RestFlat(request.getName()+" response", request.getAge()+100,
				new Date(request.getDate().getTime()+1000*60*60*24*36)
				);
	}


}
