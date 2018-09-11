package s3.api.method.resources;

import com.amazonaws.http.HttpMethodName;

public class Users extends Resource {

  
  public static final Users Login = new Users("id", POST);
  

  private Users(String path, HttpMethodName httpMethod) {

    setPathMap(path);
    this.path = path;
    this.httpMethod = httpMethod;
  }
  
  @Override
  protected String getPreviousPath() {
   
    return "/users";
  }
}