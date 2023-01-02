package com.drone.droneservice.controllers;

import com.drone.droneservice.Mapper.DroneMapperUtils;
import com.drone.droneservice.RequestDto.DroneRequestDto;
import com.drone.droneservice.ResponseDto.MedicationResponseDto;
import com.drone.droneservice.models.Drone;
import com.drone.droneservice.models.Medication;
import com.drone.droneservice.service.DroneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/drone")
@Slf4j
public class DroneController {

  @Autowired
  private DroneService droneservice;

  @PostMapping("/create")
  public ResponseEntity<Drone> registerDrone(@RequestBody DroneRequestDto drone){
    log.info("Inside controller for creating a drone");
    Drone res = droneservice.addDrone(drone);
    return new ResponseEntity<>(res, HttpStatus.OK);
  }

  @GetMapping("/all")
  public ResponseEntity<List<Drone>> getAllDrones(){
    List<Drone> response = droneservice.getAllDrones();
    System.out.println(response);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/medications/{id}")
  public ResponseEntity<List<Medication>> getAllMedicationsForADrone(@PathVariable String id){
    Long drone_id = Long.parseLong(id);
    List<Medication> meds = droneservice.getAllMedicationsForADrone(drone_id);
    return new ResponseEntity<>(meds, HttpStatus.OK);
  }

  @GetMapping("/battery/{id}")
  public ResponseEntity<String> getDroneBatteryPercentage(@PathVariable String id){
    Long drone_id = Long.parseLong(id);
    double battery = droneservice.getDroneBatteryPercentage(drone_id);
    String response = "Battery percentage for drone : " + drone_id + " is " + battery;
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/available-drones-for-loading")
  public ResponseEntity<List<Drone>> getAvailableDronesForLoading(){
    List<Drone> response = droneservice.getAvailableDronesForLoading();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
