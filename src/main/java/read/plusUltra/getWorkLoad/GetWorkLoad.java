package read.plusUltra.getWorkLoad;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GetWorkLoad {

	private static final Logger log = LoggerFactory.getLogger(GetWorkLoad.class);

	private final SimpleJdbcCall call;

	@Autowired
	public GetWorkLoad(JdbcTemplate jdbcTemplate) {
		this.call = new SimpleJdbcCall(jdbcTemplate).withSchemaName("plus_ultra").withCatalogName("read")
				.withProcedureName("get_workload")
				.returningResultSet("o_workload", BeanPropertyRowMapper.newInstance(GetWorkLoadResultSet.class));
		;
	}
	
	private List<GetWorkLoadResultSet> getData(String sessionType, int period) {
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("I_SESSION_TYPE", sessionType)
				.addValue("I_PERIOD", period);		
		Map<String, Object> result = call.execute(in);
		return (List<GetWorkLoadResultSet>) result.get("o_workload");
	}
	
	private List<String> getLables(List<GetWorkLoadResultSet> result) {
		List<String> labels = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("d mm",Locale.FRANCE);
		
		for (GetWorkLoadResultSet res : result) {
			labels.add(sdf.format(res.getDay()));
		}
		
		return labels;
	}
	
	
	private List<Integer> getMinutes(List<GetWorkLoadResultSet> result) {
		List<Integer> data = new ArrayList<Integer>();
		for (GetWorkLoadResultSet res : result) {
			data.add(Integer.valueOf(res.getMinute()));
		}
		return data;
	}
	

	@GetMapping("/get-workload")
	GetWorkLoadResponse getWorkLoad() {
		log.debug("get-workload");
		
		List<GetWorkLoadResultSet> resultRead = getData("read", 90);
		//List<GetWorkLoadResultSet> resultCount = getData("count", 90);
		//List<GetWorkLoadResultSet> resultHiragana = getData("hiragana", 90);
		
		List<String> labels = getLables(resultRead);
		
		List<Integer> readData = getMinutes(resultRead);
		//List<Integer> readCount = getMinutes(resultRead);
		//List<Integer> readHiragana = getMinutes(resultRead);
		
		Dataset read = new Dataset("Lecture", "rgb(75, 192, 192)", "Stack 0", readData);
		//Dataset count = new Dataset("Compter", "rgb(54, 162, 235)", "Stack 0", readCount);
		//Dataset hiragana = new Dataset("Hiragana", "rgb(255, 205, 86)", "Stack 0", readHiragana);
		
		List<Dataset> datasets = new ArrayList<Dataset>();
		datasets.add(read);
		//datasets.add(count);
		//datasets.add(hiragana);
		
		return new GetWorkLoadResponse(labels, datasets);
	}

}
