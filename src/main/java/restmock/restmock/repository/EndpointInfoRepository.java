package restmock.restmock.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import restmock.restmock.domain.EndpointInfo;

@Repository
public interface EndpointInfoRepository extends CrudRepository<EndpointInfo, Integer> {
	EndpointInfo findByIdAndHttpMethod(Integer id, String httpMethod);
}
