package s3.api.method.resources;

import com.amazonaws.http.HttpMethodName;

public enum Users implements Resource {

  
  Login("/developing/login", HttpMethodName.POST);
  
  
  private String path;
  private HttpMethodName httpMethod;
  
  
  Users(String path, HttpMethodName httpMethod) {
    
    this.path = path;
    this.httpMethod = httpMethod;
  }
  
  public String getPath() {
    
    return "" + this.path;
  }

  public HttpMethodName getHttpMethod() {
    
    return this.httpMethod;
  }
}