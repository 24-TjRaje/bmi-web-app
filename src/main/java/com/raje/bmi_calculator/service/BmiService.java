package com.raje.bmi_calculator.service;

import com.raje.bmi_calculator.dto.BmiResult;
import org.springframework.stereotype.Service;

@Service
public class BmiService {

    public String usageDetails() {
        return "Enter your height in metres and weight in kilograms OR height in feets and" +
                "weight in pounds.\r\n \n" +
                "Enter the url in this format : \n"  +
                "localhost:8083/bmi/height/${your-height}/weight/${your-weight}";
    }

    public BmiResult calculateBmi(Float height, Float weight) {
        Float bmiResult = (weight)/ (height * height);
        return prepareResponse(height, weight, bmiResult);
    }

    private BmiResult prepareResponse(Float height, Float weight, Float bmi) {
        return BmiResult.builder()
                .height(height)
                .weight(weight)
                .bmi(bmi)
                .status(decideStatus(bmi))
                .build();
    }

    private String decideStatus(Float bmi) {
       if(bmi < 18.5) {
           return "under weight";
       } else if (bmi >= 18.5 && bmi < 25.0)  {
            return "normal";
       } else if (bmi >= 25 && bmi < 30) {
           return "over weight";
       } else {
           return "obese";
       }
    }
}
