package s3.api.access;

import model.bean.EnderecoBean;
import model.bean.MedicoBean;
import model.bean.PacienteBean;
import model.bean.UserBean;
import model.bean.info.EnderecoInfo;
import model.bean.info.MedicoInfo;
import model.bean.info.UserInfo;
import s3.api.method.caller.MethodCaller;
import s3.api.method.request.Body;
import s3.api.method.resources.users.Users;
import s3.api.method.resources.users.id.Id;
import s3.api.method.resources.users.id.dados_basicos.DadosBasicos;
import s3.api.method.resources.users.id.dados_profissionais.DadosProfissional;
import s3.api.method.resources.users.id.enderecos.Enderecos;

public class MethodCallerFactory {


  // users
  // users-post
  public static MethodCaller cadastrarUser(UserBean bean) {

    Body body = new Body();

    body.putAll(bean.getInfosUser());

    if (bean.getEnderecos().size() > 0)
      body.put("enderecos", bean.getEnderecos());

    if (bean.getTelefones().size() > 0)
      body.put("telefones", bean.getTelefones());

    if (bean instanceof MedicoBean) {

      MedicoBean asMedico = (MedicoBean) bean;

      body.putAll(asMedico.getInfosMed());
    } else if (bean instanceof PacienteBean) {

      PacienteBean asPaciente = (PacienteBean) bean;

      body.putAll(asPaciente.getInfosPac());
    }

    return new MethodCaller(Users.CADASTRAR, body);
  }

  // users-get
  public static MethodCaller selecionarUsers() {
    return new MethodCaller(Users.SELECIONAR);
  }

  // users/{id}
  // users/{id}-delete
  public static MethodCaller deletarUser(int userId) {
    return new MethodCaller(Id.DELETAR).putParameter("id", userId);
  }

  // users/{id}-get
  public static MethodCaller selecionarUser(int userId) {
    return new MethodCaller(Id.SELECIONAR).putParameter("id", userId);
  }

  // users/{id}-patch
  public static MethodCaller atualizarUser(UserBean bean, UserInfo... infos) {

    Body body = new Body();

    for (UserInfo info : infos)
      body.put((String.valueOf(info)), bean.getInfo(info));

    int userId = (Integer) bean.getInfo(UserInfo.ID);
    return new MethodCaller(Id.ATUALIZAR_PARCIAL, body).putParameter("id", userId);
  }

  // users/{id}-put
  public static MethodCaller atualizarUser(UserBean bean) {

    int userId = (Integer) bean.getInfo(UserInfo.ID);
    return new MethodCaller(Id.ATUALIZAR, new Body(bean.getInfosUser())).putParameter("id", userId);
  }

  // users/{id}/dados-basicos
  // users/{id}/dados-basicos-get
  public static MethodCaller selecionarDadosBasicos(int userId) {

    return new MethodCaller(DadosBasicos.SELECIONAR).putParameter("id", userId);
  }

  // users/{id}/dados-basicos-patch
  public static MethodCaller atualizarDadosBasicos() {
    return null;
  }

  // users/{id}/dados-profissional
  // users/{id}/dados-profissional-get
  public static MethodCaller selecionarDadosProfissional(int userId) {

    return new MethodCaller(DadosProfissional.SELECIONAR).putParameter("id", userId);
  }

  // users/{id}/dados-profissional-patch
  public static MethodCaller atualizarDadosProfissional(MedicoBean bean, MedicoInfo... infos) {

    Body body = new Body();

    for (MedicoInfo info : infos)
      body.put(String.valueOf(info), bean.getInfo(info));

    int userId = (Integer) bean.getInfo(MedicoInfo.IDUser);
    return new MethodCaller(DadosProfissional.ATUALIZAR_PARCIAL, body).putParameter("id", userId);
  }

  // users/{id}/dados-profissional-put
  public static MethodCaller atualizarDadosProfissional(MedicoBean bean) {

    int userId = (Integer) bean.getInfo(MedicoInfo.IDUser);
    return new MethodCaller(DadosProfissional.ATUALIZAR, new Body(bean.getInfosMed()))
        .putParameter("id", userId);
  }

  //users/{id}/enderecos
  //users/{id}/enderecos-get
  public static MethodCaller selecionarEndereco(int userId) {
    
    return new MethodCaller(Enderecos.SELECIONAR).putParameter("id", userId);
  }
  
  //users/{id}/enderecos-put
  public static MethodCaller atualizarEndereco(EnderecoBean bean) {
    
    int userId = (Integer) bean.getInfo(EnderecoInfo.IDUser);
    return new MethodCaller(Enderecos.ATUALIZAR, new Body(bean.getInfosEnd())).putParameter("id", userId);
  }
}