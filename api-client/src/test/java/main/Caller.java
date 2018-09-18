package main;

import ca.ryangreen.apigateway.generic.GenericApiGatewayException;
import s3.api.access.MethodCallerFactory;

public class Caller {

  
  public static void main(String[] args) {
    
    try {
      
      System.out.println(MethodCallerFactory.selecionarUser(1).call().getBody());
    } catch (GenericApiGatewayException e) {
      
      e.printStackTrace();
    }
  }
}