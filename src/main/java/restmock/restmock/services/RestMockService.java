package restmock.restmock.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import restmock.restmock.domain.EndpointInfo;
import restmock.restmock.repository.EndpointInfoRepository;

@Service
public class RestMockService {

	@Autowired
	private EndpointInfoRepository endpointInfoRepository;

	@Autowired
	private Gson gson;

	public EndpointInfo findGetEndpointInfo(Integer id) {
		return endpointInfoRepository.findByIdAndHttpMethod(id, "GET");
	}

	public EndpointInfo findPostEndpointInfo(Integer id) {
		return endpointInfoRepository.findByIdAndHttpMethod(id, "POST");
	}

	public String getJsonFromHttpEntity(HttpEntity<String> httpEntity) {
		JsonElement je = JsonParser.parseString(httpEntity.getBody());
		return gson.toJson(je);
	}

	public String getFormattedJson(String json) {
		JsonElement je = JsonParser.parseString(json);
		return gson.toJson(je);
	}

	public EndpointInfo saveEndpointInfo(EndpointInfo endpointInfo) {
		return endpointInfoRepository.save(endpointInfo);
	}
}
