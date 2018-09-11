package main;

import ca.ryangreen.apigateway.generic.GenericApiGatewayException;
import ca.ryangreen.apigateway.generic.GenericApiGatewayResponse;
import s3.api.method.caller.MethodCaller;
import s3.api.method.request.Body;
import s3.api.method.resources.Users;

public class Caller {

  
  public static void main(String[] args) {
    
    try {
      
      GenericApiGatewayResponse response = new MethodCaller(
                                             Users.Login,
                                             new Body()
                                               .put("email", "gSilva123@hotmail.com")
                                               .put("senha", "eusouogerson")).call();
      
      System.out.println("Status: " + response.getHttpResponse().getStatusCode());
      System.out.println("body: "+ response.getBody());
    } catch (GenericApiGatewayException e) {
      
      e.printStackTrace();
    }
  }
}