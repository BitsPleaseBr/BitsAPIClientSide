package s3.api.method.resources.users.id.dados_basicos;

import com.amazonaws.http.HttpMethodName;
import s3.api.method.resources.Resource;
import s3.api.method.resources.users.id.Id;

public class DadosBasicos extends Resource {

  
  public static final DadosBasicos SELECIONAR = new DadosBasicos(GET), ATUALIZAR_PARCIAL = new DadosBasicos(PATCH);
  
  
  protected DadosBasicos(HttpMethodName httpMethod) {
    
    super(httpMethod);
  }

  @Override
  public String getAbsolutePath() {
    
    if (parentResource == null)
      this.parentResource = new Id();
    
    return parentResource.getAbsolutePath() + "/dados-basicos";
  }
}