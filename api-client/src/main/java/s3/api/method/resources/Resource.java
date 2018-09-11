package s3.api.method.resources;

import com.amazonaws.http.HttpMethodName;

public interface Resource {

  
  public String getPath();
  public HttpMethodName getHttpMethod();
}