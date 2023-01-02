package com.drone.droneservice.Runner;

import com.drone.droneservice.RequestDto.DroneRequestDto;
import com.drone.droneservice.dao.DroneRepository;
import com.drone.droneservice.models.Drone;
import com.drone.droneservice.models.Medication;
import com.drone.droneservice.service.DroneService;
import com.drone.droneservice.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Component
public class RunnerService implements CommandLineRunner {

  @Autowired
  private DroneRepository droneRepo;

  @Autowired
  private DroneService droneService;

  @Override
  public void run(String... args) throws Exception {

    droneRepo.save(new Drone(1L, "1", Constants.Model.LIGHTWEIGHT, 400, 10d, Constants.State.LOADING, new ArrayList<Medication>()));
    droneRepo.save(new Drone(2L, "1X", Constants.Model.CRUISERWEIGHT, 500, 50d, Constants.State.LOADING, new ArrayList<Medication>()));
    droneRepo.save(new Drone(3L, "17", Constants.Model.HEAVYWEIGHT, 1400, 30d, Constants.State.LOADING, new ArrayList<Medication>()));
    droneRepo.save(new Drone(4L, "1G", Constants.Model.MIDDLEWEIGHT, 600, 50d, Constants.State.LOADING, new ArrayList<Medication>()));
    droneRepo.save(new Drone(5L, "2", Constants.Model.LIGHTWEIGHT, 400, 10d, Constants.State.LOADING, new ArrayList<Medication>()));
    droneRepo.save(new Drone(6L, "3", Constants.Model.CRUISERWEIGHT, 400, 50d, Constants.State.LOADING, new ArrayList<Medication>()));
    droneRepo.save(new Drone(7L, "4", Constants.Model.LIGHTWEIGHT, 400, 20d, Constants.State.LOADING, new ArrayList<Medication>()));
    droneRepo.save(new Drone(8L, "5", Constants.Model.LIGHTWEIGHT, 400, 50d, Constants.State.LOADING, new ArrayList<Medication>()));
    droneRepo.save(new Drone(9L, "6", Constants.Model.LIGHTWEIGHT, 400, 15d, Constants.State.LOADING, new ArrayList<Medication>()));

  }
}
