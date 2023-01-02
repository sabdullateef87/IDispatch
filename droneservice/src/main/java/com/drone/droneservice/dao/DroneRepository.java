package com.drone.droneservice.dao;


import com.drone.droneservice.models.Drone;
import com.drone.droneservice.models.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {

  @Query(value = "select * from drones where state=:state and battery_percentage >=:batteryPercentage", nativeQuery = true)
  List<Drone> getAvailableDronesForLoading(String state, double batteryPercentage);

  @Query(value = "select * from drones where state=:state", nativeQuery = true)
  List<Drone> getAvailableDronesByState(String state);


}
