package com.mon.assignment.model.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ThermometerReq {

    private TemperatureSpec freezeTemperatureSpec;
    private TemperatureSpec boilTemperatureSpec;
}
