package com.drone.droneservice.service;

import com.drone.droneservice.RequestDto.DroneRequestDto;
import com.drone.droneservice.dao.DroneRepository;
import com.drone.droneservice.models.Drone;
import com.drone.droneservice.models.Medication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DroneService {
  Drone addDrone(DroneRequestDto drone);
  List<Drone> getAllDrones();
  List<Medication> getAllMedicationsForADrone(Long drone_id);
  List<Drone> getAvailableDroneByState(String loadingState);
  double getDroneBatteryPercentage(Long drone_id);
  Drone getDroneById(Long drone_id);
  List<Drone> getAvailableDronesForLoading();
}
