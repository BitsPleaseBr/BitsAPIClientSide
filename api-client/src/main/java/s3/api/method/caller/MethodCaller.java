package s3.api.method.caller;

import com.amazonaws.ClientConfiguration;
import ca.ryangreen.apigateway.generic.GenericApiGatewayResponse;
import s3.api.client.ClientBuilder;
import s3.api.method.request.Body;
import s3.api.method.request.RequestBuilder;
import s3.api.method.resources.Resource;

public class MethodCaller {

  
  private ClientBuilder clientBuilder = new ClientBuilder();
  private RequestBuilder requestBuilder = new RequestBuilder();
  
  
  public MethodCaller() {
    
    clientBuilder.withClientConfiguration(new ClientConfiguration());
  }
  
  public MethodCaller(Resource resource, Body body) {
    
    this();
    
    requestBuilder.withBody(body).withResource(resource);
  }
  
  
  public GenericApiGatewayResponse call() {
    
    return clientBuilder.build().execute(requestBuilder.build());
  }
}