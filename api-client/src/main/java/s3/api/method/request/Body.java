package s3.api.method.request;

import java.util.HashMap;

public class Body {

  
  private RequestBuilder builder;
  private HashMap<String, Object> values = new HashMap<String, Object>();
  
  
  public Body(RequestBuilder builder) {
    
    this.builder = builder;
  }
  
  public Body() {}
  
  
  public Body put(String key, Object value) {
    
    this.values.put(key, value);
    return this;
  }
  
  public Body putAll(HashMap<String, Object> newValues) {
    
    this.values.putAll(newValues);
    return this;
  }
  
  public Body setValues(HashMap<String, Object> newValues) {
    
    this.values = newValues;
    return this;
  }
  
  public HashMap<String, Object> getValues() {
    
    return this.values;
  }
  
  
  public Body setRequestBuilder(RequestBuilder builder) {
    
    this.builder = builder;
    return this;
  }
  
  public RequestBuilder getRequestBuilder() {
    
    return this.builder;
  }
}