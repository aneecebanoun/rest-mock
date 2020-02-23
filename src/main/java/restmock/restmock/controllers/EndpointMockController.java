package restmock.restmock.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import restmock.restmock.domain.EndpointInfo;
import restmock.restmock.services.RestMockService;

@Controller
public class EndpointMockController {

	@Autowired
	private RestMockService restMockService;

	@GetMapping(path = "/")
	public String createRestMock(Model model) {
		model.addAttribute("endpointInfo", new EndpointInfo());
		return "createRestMock";
	}

	@RequestMapping(value = { "/mock" }, method = { RequestMethod.POST })
	public String mock(EndpointInfo endpointInfo, Model model, HttpServletRequest request) {
		EndpointInfo savedEndpointInfo = restMockService.saveEndpointInfo(endpointInfo);
		String endPointUrl = "endPointUrl";
		String baseUrl = request.getRequestURL().toString().replaceAll("mock", "");
		if ("POST".equals(savedEndpointInfo.getHttpMethod())) {
			endPointUrl = baseUrl + "postMock/" + savedEndpointInfo.getId();
		} else {
			endPointUrl = baseUrl + "getMock/" + savedEndpointInfo.getId();
		}
		model.addAttribute("endPointUrl", endPointUrl);
		return "mock";
	}

}
