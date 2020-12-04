package com.currencycloud.client.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentValidation {

  private String validationResult;

  
  public String getValidationResult() {
    return validationResult;
  }
  
  public void setValidationResult(String validationResult) {
    this.validationResult = validationResult;
  }

  @Override
  public String toString() {
    final ObjectMapper objectMapper = new ObjectMapper();

    Map<String, Object> map = new HashMap<>();
    map.put("validation_result", validationResult);    

    try {
      return objectMapper.writeValueAsString(map);
    } catch (JsonProcessingException e) {
      return String.format("{\"error\": \"%s\"}", e.getMessage());
    }
  }
  
}
