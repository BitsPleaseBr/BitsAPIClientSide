package main;

import ca.ryangreen.apigateway.generic.GenericApiGatewayException;
import model.bean.EnderecoBean;
import model.bean.MedicoBean;
import model.bean.UserBean;
import model.bean.info.EnderecoInfo;
import model.bean.info.MedicoInfo;
import model.bean.info.UserInfo;
import s3.api.access.MethodCallerFactory;

public class Caller {

  
  public static void main(String[] args) {
    
    try {
      
      System.out.println(MethodCallerFactory.cadastrarUser(new UserBean() {}).getRequestBuilder().getResource().getPath());
      System.out.println(MethodCallerFactory.selecionarUsers().getRequestBuilder().getResource().getPath());
      
      System.out.println(MethodCallerFactory.selecionarUser(1).getRequestBuilder().getResource().getPath());      
      System.out.println(MethodCallerFactory.deletarUser(1).getRequestBuilder().getResource().getPath());
      System.out.println(MethodCallerFactory.atualizarUser(new UserBean() {}.setInfo(UserInfo.ID, 1), UserInfo.CPF).getRequestBuilder().getResource().getPath());
      System.out.println(MethodCallerFactory.atualizarUser(new UserBean() {}.setInfo(UserInfo.ID, 1)).getRequestBuilder().getResource().getPath());
      
      System.out.println(MethodCallerFactory.selecionarDadosBasicos(1).getRequestBuilder().getResource().getPath());
      //System.out.println(MethodCallerFactory.atualizarDadosBasicos().getRequestBuilder().getResource().getPath());
      
      System.out.println(MethodCallerFactory.selecionarDadosProfissional(1).getRequestBuilder().getResource().getPath());
      System.out.println(MethodCallerFactory.atualizarDadosProfissional(new MedicoBean().setInfo(MedicoInfo.IDUser, 1), MedicoInfo.CRM).getRequestBuilder().getResource().getPath());
      System.out.println(MethodCallerFactory.atualizarDadosProfissional(new MedicoBean().setInfo(MedicoInfo.IDUser, 1)).getRequestBuilder().getResource().getPath());
      
      System.out.println(MethodCallerFactory.selecionarEndereco(1).getRequestBuilder().getResource().getPath());
      System.out.println(MethodCallerFactory.atualizarEndereco(new EnderecoBean().setInfo(EnderecoInfo.IDUser, 1)).getRequestBuilder().getResource().getPath());
      
    } catch (GenericApiGatewayException e) {
      
      e.printStackTrace();
    }
  }
}