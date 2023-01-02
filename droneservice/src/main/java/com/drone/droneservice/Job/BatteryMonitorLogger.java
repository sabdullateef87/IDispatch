package com.drone.droneservice.Job;

import com.drone.droneservice.ResponseDto.BatterLoggerPayload;
import com.drone.droneservice.models.Drone;
import com.drone.droneservice.service.DroneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class BatteryMonitorLogger {
  @Autowired
  private DroneService droneService;

  @Scheduled(cron = "${battery.logger.cron}")
  public void monitorBatteryPercentage(){
    log.info("Monitoring battery percentage for all drones");
    for(BatterLoggerPayload bt: getBatteryInfoForDrones()){
      log.info(bt.toString());
    }
  }

  private List<BatterLoggerPayload> getBatteryInfoForDrones(){
    List<Drone> drones = droneService.getAllDrones();
    List<BatterLoggerPayload> droneBatteryCollection = new ArrayList<>();

    for(Drone drone: drones){
      BatterLoggerPayload temp = new BatterLoggerPayload();
      temp.setDrone_id(drone.getDrone_id());
      temp.setBatteryPercentage(drone.getBatteryPercentage());
      droneBatteryCollection.add(temp);
    }

    return droneBatteryCollection;
  }
}


