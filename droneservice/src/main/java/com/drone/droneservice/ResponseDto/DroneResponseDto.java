package com.drone.droneservice.ResponseDto;

import com.drone.droneservice.models.Medication;
import com.drone.droneservice.utils.Constants;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class DroneResponseDto {
  private String serialNumber;
  private Constants.Model model;
  private Constants.State state;
  private long weightLimit;
  private double batteryPercentage;
  private List<String> medications;
}
