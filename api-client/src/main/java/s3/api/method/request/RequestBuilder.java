package s3.api.method.request;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ca.ryangreen.apigateway.generic.GenericApiGatewayRequest;
import ca.ryangreen.apigateway.generic.GenericApiGatewayRequestBuilder;
import s3.api.method.resources.Resource;

public class RequestBuilder extends GenericApiGatewayRequestBuilder {

  
  private Headers headers;
  private Body body;
  private Resource resource;
  
  
  public RequestBuilder() {
    
    this.headers = new Headers(this);
    this.headers.put("Content-Type", "application/json");
    
    this.body = new Body(this);
  }
  
  
  @Override
  public GenericApiGatewayRequestBuilder withHeaders(Map<String, String> headers) {
    
    return this;
  }
  
  public Headers getHeaders() {
    
    return this.headers;
  }
  
  public RequestBuilder withBody(Body body) {
    
    this.body = body;
    return this;
  }
  
  public Body getBody() {
    
    return this.body;
  }
  
  public RequestBuilder withResource(Resource resource) {
    
    this.resource = resource;
    return this;
  }
  
  @Override
  public GenericApiGatewayRequest build() {
    
    super.withHeaders(this.headers.getValues());
    super.withBody(new ByteArrayInputStream(new Gson().toJson(this.body.getValues()).getBytes()));
    super.withHttpMethod(this.resource.getHttpMethod());
    super.withResourcePath(this.resource.getPath());
    
    return super.build();
  }
}