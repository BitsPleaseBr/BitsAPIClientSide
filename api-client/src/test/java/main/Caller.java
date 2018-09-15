package main;

import ca.ryangreen.apigateway.generic.GenericApiGatewayException;
import model.bean.UserBean;
import s3.api.access.MethodCallerFactory;

public class Caller {

  
  public static void main(String[] args) {
    
    try {
      
      MethodCallerFactory mcf = new MethodCallerFactory();
      
      System.out.println(mcf.cadastrarUser(new UserBean() {}).getRequestBuilder().getResource().getPath());
      System.out.println(mcf.selecionarUser(1).getRequestBuilder().getResource().getPath());
      System.out.println(mcf.deletarUser(1).getRequestBuilder().getResource().getPath());
    } catch (GenericApiGatewayException e) {
      
      e.printStackTrace();
    }
  }
}