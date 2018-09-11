package s3.api.client;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import ca.ryangreen.apigateway.generic.GenericApiGatewayClient;
import ca.ryangreen.apigateway.generic.GenericApiGatewayClientBuilder;

public class ClientBuilder extends GenericApiGatewayClientBuilder {

  
  private String endpoint = "https://bh7xqk7gcj.execute-api.sa-east-1.amazonaws.com";
  private Region region = Region.getRegion(Regions.fromName("sa-east-1"));
  
  
  public ClientBuilder withEndpoint(String endpoint) {
    
    return this;
  }

  public ClientBuilder withRegion(Region region) {
    
    return this;
  }

  public GenericApiGatewayClient build() {
    
    super.withEndpoint(endpoint);
    super.withRegion(region);
    
    return super.build();
  }
}