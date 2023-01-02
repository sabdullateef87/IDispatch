package com.drone.droneservice.utils;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DroneUtil {

  public static String ObjectToJson(Object object){
    ObjectMapper mapper = new ObjectMapper();
    try {
      return mapper.writeValueAsString(object);
    }
    catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return null;
  }
}
