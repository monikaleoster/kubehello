package com.mon.assignment.model.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class TemperatureSpec {

    @NotBlank(message = "Temperature is mandatory")
    int temp;
    double minThreshHold;
    double maxThreshHold;

}
