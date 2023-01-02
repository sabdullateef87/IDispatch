package com.drone.droneservice.controllers;

import com.drone.droneservice.RequestDto.MedicationRequestDto;
import com.drone.droneservice.RequestValidator.MedicationRequestValidator;
import com.drone.droneservice.ResponseDto.MedicationResponseDto;
import com.drone.droneservice.models.Medication;
import com.drone.droneservice.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/medication")
public class MedicationController {

  @Autowired
  private MedicationService medicationService;

  @GetMapping("/check")
  public String checkMedication(){
    return "Checking medication service";
  }

  @PostMapping("/create")
  public ResponseEntity<MedicationResponseDto> createMedication(@RequestBody MedicationRequestDto medication){
    boolean isRequestValid = MedicationRequestValidator.validateMedicationRequest(medication);
    System.out.println(isRequestValid);
    if(isRequestValid){
      MedicationResponseDto response = medicationService.createMedication(medication);
      return new ResponseEntity<>(response, HttpStatus.OK);
    }else{
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid request", null);
    }

  }
}
