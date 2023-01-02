package com.drone.droneservice.serviceImpl;

import com.drone.droneservice.Mapper.DroneMapperUtils;
import com.drone.droneservice.RequestDto.DroneRequestDto;
import com.drone.droneservice.dao.DroneRepository;
import com.drone.droneservice.models.Drone;
import com.drone.droneservice.models.Medication;
import com.drone.droneservice.service.DroneService;
import com.drone.droneservice.utils.Constants;
import com.drone.droneservice.utils.DroneUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DroneServiceImpl implements DroneService {
  @Autowired
  DroneRepository droneRepo;

  @Override
  public Drone addDrone(DroneRequestDto droneRequest) {
    Drone drone = DroneMapperUtils.mapDroneRequestToDrone(droneRequest);
    double battery = drone.getBatteryPercentage();
    if(battery < 25){
      drone.setState(Constants.State.IDLE);
    }
    return droneRepo.save(drone);
  }

  @Override
  public List<Drone> getAllDrones() {

    return droneRepo.findAll();
  }

  @Override
  public List<Medication> getAllMedicationsForADrone(Long drone_id) {
    return getDroneById(drone_id).getMedications();
  }

  @Override
  public List<Drone> getAvailableDroneByState(String loadingState) {
    return droneRepo.getAvailableDronesByState(loadingState);
  }

  @Override
  public double getDroneBatteryPercentage(Long drone_id) {
    return getDroneById(drone_id).getBatteryPercentage();
  }

  @Override
  public Drone getDroneById(Long drone_id) {
    return droneRepo.findById(drone_id).orElseThrow(() -> new IllegalArgumentException("Drone with id " + drone_id + " could not be found") );
  }

  @Override
  public List<Drone> getAvailableDronesForLoading() {
    String state = "LOADING";
    double batteryPercentage = 25;
    return droneRepo.getAvailableDronesForLoading(state, batteryPercentage);
  }
}
