package com.drone.droneservice.Mapper;

import com.drone.droneservice.RequestDto.MedicationRequestDto;
import com.drone.droneservice.ResponseDto.MedicationResponseDto;
import com.drone.droneservice.models.Medication;

public class MedicationMapperUtil {

  public static Medication mapMedicationToMedicationRequestDto(MedicationRequestDto medicationRequestDto) {
    Medication medication = new Medication();
    medication.setName(medicationRequestDto.getName());
    medication.setCode(medicationRequestDto.getCode());
    medication.setWeight(medicationRequestDto.getWeight());
    medication.setUrl((medicationRequestDto.getUrl()));

    return medication;
  }

  public static MedicationResponseDto mapMedicationResponseDtoToMedication(Medication medication, Long drone_id){
    MedicationResponseDto medicationResponseDto = new MedicationResponseDto();
    medicationResponseDto.setName(medication.getName());
    medicationResponseDto.setCode(medication.getCode());
    medicationResponseDto.setWeight(medication.getWeight());
    medicationResponseDto.setUrl((medication.getUrl()));
    medicationResponseDto.setDrone_id(drone_id);
    return medicationResponseDto;
  }
}
