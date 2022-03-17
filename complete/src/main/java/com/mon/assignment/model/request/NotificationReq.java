package com.mon.assignment.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@ApiModel
public class NotificationReq {

    @NotEmpty
    @ApiModelProperty(
            value = "Collected Source temperatures ",
            name = "srcTemps",
            dataType = "Double",
            example = "[0,0.5,0.2,0,1.5,0]")
    Double[] srcTemps;
    ThermometerReq thermometerReq;
    @ApiModelProperty(
            value = "Enable repeated notification",
            name = "repeatedNotification",
            dataType = "Boolean",
            example = "true")
    Boolean repeatedNotification;
}
