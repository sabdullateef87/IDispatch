package com.drone.droneservice.ResponseDto;

import lombok.Data;

@Data
public class BatterLoggerPayload {
  private long drone_id;
  private double batteryPercentage;

  public String toString(){
    String warningMessage = "";
    if(batteryPercentage < 25){
      warningMessage = " please charge";
    }
    return "Drone with id : " + drone_id + " has " + batteryPercentage + " %." + warningMessage;
  }
}
