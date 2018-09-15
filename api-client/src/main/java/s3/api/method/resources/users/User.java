package s3.api.method.resources.users;

import com.amazonaws.http.HttpMethodName;
import s3.api.method.resources.Resource;

public class User extends Resource {

  
  public static final User SELECIONAR = new User("", GET), DELETAR = new User("", DELETE);
  
  
  private User(String path, HttpMethodName httpMethod) {
    
    super(path, httpMethod);
  }
  
  @Override
  protected String getPreviousPath() {
    
    return "/id";
  }
}