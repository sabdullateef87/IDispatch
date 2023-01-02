package com.drone.droneservice.Mapper;

import com.drone.droneservice.RequestDto.DroneRequestDto;
import com.drone.droneservice.ResponseDto.DroneResponseDto;
import com.drone.droneservice.models.Drone;
import com.drone.droneservice.models.Medication;
import com.drone.droneservice.utils.DroneUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DroneMapperUtils {

  public static Drone mapDroneRequestToDrone(DroneRequestDto droneRequest){
    Drone drone = new Drone();
    drone.setSerialNumber(droneRequest.getSerialNumber());
    drone.setModel(droneRequest.getModel());
    drone.setWeightLimit(droneRequest.getWeightLimit());
    drone.setBatteryPercentage(droneRequest.getBatteryPercentage());
    drone.setState(droneRequest.getState());
    return drone;
  }

  public static DroneResponseDto mapDroneToResponseDto(Drone drone){
    DroneResponseDto droneResponseDto = new DroneResponseDto();
    droneResponseDto.setSerialNumber(drone.getSerialNumber());
    droneResponseDto.setState(drone.getState());
    droneResponseDto.setBatteryPercentage(drone.getBatteryPercentage());
    droneResponseDto.setModel(drone.getModel());
    droneResponseDto.setWeightLimit(drone.getWeightLimit());
    List<String> meds = new ArrayList<>();
    for(Medication med: drone.getMedications()){
      meds.add(DroneUtil.ObjectToJson(med));
    }
    droneResponseDto.setMedications(meds);
    return droneResponseDto;
  }

  public static List<String> getMedicationsFromDroneMapping(List<Medication> meds){
    List<String> output = new ArrayList<>();
    for(Medication med: meds){
      output.add(DroneUtil.ObjectToJson(med));
    }
    return output;
  }
}
