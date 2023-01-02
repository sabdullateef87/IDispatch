package com.drone.droneservice.ResponseDto;

import lombok.Data;

@Data
public class MedicationResponseDto {
  private String name;
  private double weight;
  private String code;
  private String url;
  private Long drone_id;
}
