package com.mon.assignment.model.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class NotificationReq {

    @NotEmpty
    Double[] srcTemps;
    ThermometerReq thermometerReq;
    Boolean disableRepeatedNotification;
}
