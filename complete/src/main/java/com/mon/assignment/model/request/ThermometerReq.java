package com.mon.assignment.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel
public class ThermometerReq {
    @ApiModelProperty(
            value = "Define specificaton for freezing temperature",
            name = "freezeTemperatureSpec")
    private TemperatureSpec freezeTemperatureSpec;
    @ApiModelProperty(
            value = "Define specificaton for Boiling temperature",
            name = "freezeTemperatureSpec")
    private TemperatureSpec boilTemperatureSpec;
}
