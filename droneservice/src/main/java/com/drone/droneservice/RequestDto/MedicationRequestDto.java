package com.drone.droneservice.RequestDto;

import com.drone.droneservice.models.Medication;
import lombok.Data;

@Data
public class MedicationRequestDto {
  private String name;
  private double weight;
  private String code;
  private String url;
  private Long drone_id;
}
