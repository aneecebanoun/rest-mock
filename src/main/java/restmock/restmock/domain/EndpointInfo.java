package restmock.restmock.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "endpoint_info")
public class EndpointInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String applicationName;
	private String httpMethod;
	private String requestJson;
	private String responseJson;
	private Boolean strictPostBody;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

	public String getRequestJson() {
		return requestJson;
	}

	public void setRequestJson(String requestJson) {
		this.requestJson = requestJson;
	}

	public String getResponseJson() {
		return responseJson;
	}

	public void setResponseJson(String responseJson) {
		this.responseJson = responseJson;
	}

	public Boolean getStrictPostBody() {
		return strictPostBody;
	}

	public void setStrictPostBody(Boolean strictPostBody) {
		this.strictPostBody = strictPostBody;
	}

}
