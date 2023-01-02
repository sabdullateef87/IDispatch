package com.drone.droneservice.RequestValidator;

import com.drone.droneservice.RequestDto.MedicationRequestDto;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MedicationRequestValidator {

  public static boolean validateMedicationRequest(MedicationRequestDto medicationRequestDto){
    boolean isMedicationRequestValid = true;

    String medicationNameRegex = "^[A-Za-z0-9_-]*$";
    Pattern namePattern = Pattern.compile(medicationNameRegex);
    Matcher nameMatcher = namePattern.matcher(medicationRequestDto.getName());
    if(!nameMatcher.find()){
      isMedicationRequestValid = false;
    }

    String medicationCodeRegex = "^[A-Z0-9_]*$";
    Pattern codePattern = Pattern.compile(medicationCodeRegex);
    Matcher codeMatcher = codePattern.matcher(medicationRequestDto.getCode());
    if(!codeMatcher.find()){
      isMedicationRequestValid = false;
    }


    return isMedicationRequestValid;
  }
}
