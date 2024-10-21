package com.raje.bmi_calculator.controller;

import com.raje.bmi_calculator.dto.BmiResult;
import com.raje.bmi_calculator.service.BmiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bmi")
public class BmiUiController {

    @Autowired
    private BmiService bmiService;

    @GetMapping(value = "/index")
    public String index() {
        return "index";
    }

    @PostMapping("/result")
    public String submitForm(@RequestParam Float height, @RequestParam Float weight, Model model) {
        // Construct the API URL
        BmiResult bmiResponse = bmiService.calculateBmi(height,weight);
        model.addAttribute("result",bmiResponse);
        return "bmiResult"; // Redirect to a result page
    }
}
