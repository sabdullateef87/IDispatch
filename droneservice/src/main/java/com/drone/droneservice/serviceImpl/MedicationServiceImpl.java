package com.drone.droneservice.serviceImpl;

import com.drone.droneservice.Mapper.MedicationMapperUtil;
import com.drone.droneservice.RequestDto.MedicationRequestDto;
import com.drone.droneservice.ResponseDto.MedicationResponseDto;
import com.drone.droneservice.dao.DroneRepository;
import com.drone.droneservice.dao.MedicationRepository;
import com.drone.droneservice.models.Drone;
import com.drone.droneservice.models.Medication;
import com.drone.droneservice.service.DroneService;
import com.drone.droneservice.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationServiceImpl implements MedicationService {

  @Autowired
  private DroneService droneservice;

  @Autowired
  private MedicationRepository medicationRepo;

  @Override
  public MedicationResponseDto createMedication(MedicationRequestDto medicationRequestDto) {
   Medication medication =  MedicationMapperUtil.mapMedicationToMedicationRequestDto(medicationRequestDto);
   Long drone_id = medicationRequestDto.getDrone_id();
   if(drone_id == null){
     throw new IllegalArgumentException("Medication requires a drone for dispatch");
   }
   double totalLoadIncludingMedication = getTotalMedicationWeightOnDrone(drone_id) + medicationRequestDto.getWeight();
   Drone drone = droneservice.getDroneById(drone_id);
   if(totalLoadIncludingMedication > drone.getWeightLimit()){
     throw new IllegalArgumentException("Addition of " + medicationRequestDto.getWeight() + " would cause an overload");
   }
   medication.setDrone(drone);
   Medication newMedication = medicationRepo.save(medication);
   return MedicationMapperUtil.mapMedicationResponseDtoToMedication(newMedication, drone_id);
  }

  private double getTotalMedicationWeightOnDrone(Long drone_id){
    List<Medication> meds = droneservice.getDroneById(drone_id).getMedications();
    double totalLoad = 0;
    for(Medication med: meds){
      totalLoad += med.getWeight();
    }
    System.out.println(totalLoad);
    return totalLoad;
  }
}
