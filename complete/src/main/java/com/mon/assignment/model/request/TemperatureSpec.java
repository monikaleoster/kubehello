package com.mon.assignment.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter @ApiModel
public class TemperatureSpec {

    @ApiModelProperty(
            value = "temperature value used to define freezing or boiling temperature",
            name = "temp",
            dataType = "double",
            example = "0")
    @NotBlank(message = "Temperature is mandatory")
    int temp;

    @ApiModelProperty(
            value = "temperature value used to define lower threshold value",
            name = "minThreshHold",
            dataType = "double",
            example = "0.5")
    double minThreshHold;
    @ApiModelProperty(
            value = "temperature value used to define higher threshold value",
            name = "maxThreshHold",
            dataType = "double",
            example = "0.5")
    double maxThreshHold;

}
