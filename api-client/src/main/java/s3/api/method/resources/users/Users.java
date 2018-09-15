package s3.api.method.resources.users;

import com.amazonaws.http.HttpMethodName;
import s3.api.method.resources.Resource;

public class Users extends Resource {

  
  public static final Users CADASTRO = new Users("", POST), SELECIONAR = new Users("", GET);
  
  
  private Users(String path, HttpMethodName httpMethod) {

    super(path, httpMethod);
  }
  
  @Override
  protected String getPreviousPath() {
   
    return "/users";
  }
}