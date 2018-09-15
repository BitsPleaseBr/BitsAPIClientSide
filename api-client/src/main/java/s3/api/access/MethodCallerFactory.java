package s3.api.access;

import java.util.HashMap;
import com.google.gson.Gson;
import model.bean.EnderecoBean;
import model.bean.MedicoBean;
import model.bean.PacienteBean;
import model.bean.TelefoneBean;
import model.bean.UserBean;
import s3.api.method.caller.MethodCaller;
import s3.api.method.request.Body;
import s3.api.method.resources.users.User;
import s3.api.method.resources.users.Users;

public class MethodCallerFactory {


  public static MethodCaller cadastrarUser(UserBean bean) {

    Gson g = new Gson();

    @SuppressWarnings("unchecked")
    HashMap<String, Object> values =
        (HashMap<String, Object>) g.fromJson(g.toJson(bean.getInfosUser()), HashMap.class);

    return new MethodCaller(Users.CADASTRO, new Body().putAll(values));
  }

  public static MethodCaller selecionarUsers() {

    return new MethodCaller(Users.SELECIONAR, new Body());
  }

  public static MethodCaller deletarUser(int id) {

    return new MethodCaller(User.DELETAR, new Body()).putParameter("id", id);
  }

  public static MethodCaller selecionarUser(int id) {

    return new MethodCaller(User.SELECIONAR, new Body()).putParameter("id", id);
  }

  @SuppressWarnings("unchecked")
  public static MethodCaller atualizarUser(UserBean bean) {

    Gson g = new Gson();
    Body body = new Body();
    
    HashMap<String, Object> values = (HashMap<String, Object>) g.fromJson(g.toJson(bean.getInfosUser()), HashMap.class);

    body.putAll(values);
    
    if (bean instanceof MedicoBean) {
      
      MedicoBean asMedico = (MedicoBean) bean;
      
      HashMap<String, Object> medicoValues = g.fromJson(g.toJson(asMedico.getInfosMed()), HashMap.class);
      body.putAll(medicoValues);
    } else if (bean instanceof PacienteBean) {
      
      PacienteBean asPaciente = (PacienteBean) bean;
      
      HashMap<String, Object> pacienteValues = g.fromJson(g.toJson(asPaciente.getInfosPac()), HashMap.class);
      body.putAll(pacienteValues);
    }
    
    return new MethodCaller(User.SELECIONAR, body);
  }
}
