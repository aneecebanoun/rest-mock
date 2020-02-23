package restmock.restmock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import restmock.restmock.domain.EndpointInfo;
import restmock.restmock.services.RestMockService;

@RestController
public class RestEndpointMocksRestController {

	@Autowired
	RestMockService restMockService;

	@RequestMapping(path = "/getMock/{id}", method = RequestMethod.GET)
	public String getMock(@PathVariable Integer id) {
		try {
			EndpointInfo endpointInfo = restMockService.findGetEndpointInfo(id);
			return endpointInfo.getResponseJson();
		} catch (Throwable t) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, t.getMessage());
		}
	}

	@RequestMapping(path = "/postMock/{id}", method = RequestMethod.POST)
	public String postMock(HttpEntity<String> httpEntity, @PathVariable Integer id) {
		try {
			EndpointInfo endpointInfo = restMockService.findPostEndpointInfo(id);
			String requestBody = restMockService.getJsonFromHttpEntity(httpEntity);
			boolean equalsRequest = requestBody != null
					&& requestBody.equals(restMockService.getFormattedJson(endpointInfo.getRequestJson()));
			if (endpointInfo.getStrictPostBody() && !equalsRequest) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Strict Post Body Required");
			}
			return restMockService.getFormattedJson(endpointInfo.getResponseJson());
		} catch (Throwable t) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, t.getMessage());
		}
	}
}
