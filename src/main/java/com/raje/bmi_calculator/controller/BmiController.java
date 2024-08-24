package com.raje.bmi_calculator.controller;

import com.raje.bmi_calculator.dto.BmiResult;
import com.raje.bmi_calculator.service.BmiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bmi")
public class BmiController {

    @Autowired
    private BmiService bmiService;

    @GetMapping("/usage")
    public ResponseEntity<String> usageDetails() {
        return new ResponseEntity<String>(bmiService.usageDetails(), HttpStatus.OK);
    }

    @GetMapping("/height/{height}/weight/{weight}")
    public ResponseEntity<BmiResult> calculateBmi(@PathVariable Float height,
                                                  @PathVariable Float weight) {
        return new ResponseEntity<BmiResult>(bmiService.calculateBmi(height, weight),
        HttpStatus.OK);
    }
}
