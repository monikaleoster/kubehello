package com.mon.assignment.service;

import com.mon.assignment.model.Thermometer;

import java.util.Map;

public interface INotificationService {

    Map<Double, Integer> notify(Double[] sourceTemps, Thermometer thermometer, Boolean disableRepeatedMaxTempNotification);
}
