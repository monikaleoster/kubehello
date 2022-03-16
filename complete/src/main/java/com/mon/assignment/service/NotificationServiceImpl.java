package com.mon.assignment.service;

import com.mon.assignment.model.Thermometer;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.*;
@Log4j2
@Component
public class NotificationServiceImpl implements INotificationService {
    Map<Double,Integer> notifiedTemps = null;
    Stack<Integer> processed = new Stack<>();
    @Override
    public Map<Double, Integer> notify(Double[] sourceTemps, Thermometer thermometer, Boolean disableRepeatedTempNotification) throws RuntimeException{
        notifiedTemps = new HashMap<>();
           StringBuffer response = new StringBuffer();

           for (int i = 0; i < sourceTemps.length; i++) {
               Double currTemp = sourceTemps[i];

               response.append("Processing-" + sourceTemps[i]);
               //Integer lastRead = processed.peek();
               Double lastRead = null;
               if (i != 0) {
                   lastRead = sourceTemps[i - 1];
               }
               if (currTemp.equals(thermometer.getBoilingTemp())) {
                   if (i != 0 && !disableRepeatedTempNotification && liesInBoilingThreshHoldRange(lastRead, thermometer) && notifiedTemps.containsKey(currTemp)) {
                       response.append("Boiling temp already been notified, No new notification");
                   } else {

                       insertInNotified(currTemp);

                       response.append("New Notification for Boiling");

                   }
               }
               if (currTemp.equals(thermometer.getFreezingTemp())) {
                   if (i != 0 && !disableRepeatedTempNotification && liesInFreezingThreshHoldRange(lastRead, thermometer) && notifiedTemps.containsKey(currTemp)) {
                       response.append("Freezing temp already been notified, No new notification");
                   } else {
                       insertInNotified(currTemp);
                       response.append("New Notification for Freezing");

                   }
               }
               response.append(System.getProperty("line.separator"));
           }
           log.debug(response);
        return notifiedTemps;
    }

    private void insertInNotified(double temp) {
        if(notifiedTemps.containsKey(temp))
            notifiedTemps.put(temp,notifiedTemps.get(temp)+1);
        else
            notifiedTemps.put(temp,1);

    }


    private boolean liesInBoilingThreshHoldRange(Double sourceTemp, Thermometer thermometer) {
        return (sourceTemp<=thermometer.getMaxBoilingTemp() && sourceTemp>=thermometer.getMinBoilingTemp());
    }

    private boolean liesInFreezingThreshHoldRange(Double sourceTemp, Thermometer thermometer) {
        return (sourceTemp<=thermometer.getMaxFreezingTemp() && sourceTemp>=thermometer.getMinFreezingTemp());
    }


    }
