package com.drone.droneservice.RequestDto;

import com.drone.droneservice.models.Drone;
import com.drone.droneservice.utils.Constants;
import lombok.Data;

@Data
public class DroneRequestDto {
  private String serialNumber;
  private Constants.Model model;
  private Constants.State state;
  private long weightLimit;
  private double batteryPercentage;
}
