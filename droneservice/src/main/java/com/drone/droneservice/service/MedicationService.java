package com.drone.droneservice.service;

import com.drone.droneservice.RequestDto.MedicationRequestDto;
import com.drone.droneservice.ResponseDto.MedicationResponseDto;
import com.drone.droneservice.dao.DroneRepository;
import com.drone.droneservice.dao.MedicationRepository;
import com.drone.droneservice.models.Drone;
import com.drone.droneservice.models.Medication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface MedicationService {
  MedicationResponseDto createMedication(MedicationRequestDto medicationRequestDto);
}
