package com.mon.assignment.service;

import com.mon.assignment.model.Thermometer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
@RunWith(PowerMockRunner.class)
@PrepareForTest({NotificationServiceImpl.class})
public class NotificationServiceImplTest {

    @InjectMocks
    NotificationServiceImpl notificationService= new NotificationServiceImpl();

    @Test
    public void givenThermometerAndSourceTempWhenProcessedThenNoRepeatedNotifications() {
        Double[] temps ={0d,0.5d,0.2d,0d,1.5d,0d};
       Map<Double,Integer> result =notificationService.notify(temps,mockThermoMeter(),false);
        Assert.assertEquals(2,result.get(0d).intValue());
    }

    @Test
    public void givenThermometerAndSourceAndRepeatedNotificationIsEnabledTempWhenProcessedThenNoRepeatedNotifications() {
        Double[] temps ={0d,0.5d,0.2d,0d,1.5d,0d};
        Map<Double,Integer> result =notificationService.notify(temps,mockThermoMeter(),true);
        Assert.assertEquals(3,result.get(0d).intValue());
    }
    @Test
    public void givenThermometerAndSourceTempAlwaysInThresholdWhenProcessedThenNoRepeatedNotifications() {
        Double[] temps ={0d,0.5d,0.2d,0d,0.5d,0d};
        Map<Double,Integer> result =notificationService.notify(temps,mockThermoMeter(),false);
        Assert.assertEquals(1,result.get(0d).intValue());
    }

    @Test
    public void givenThermometerAndSourceTempWithFreezeAndBoilWhenProcessedThenNoRepeatedNotifications() {
        Double[] temps ={0d,0.5d,0.2d,0d,100d,0d};
        Map<Double,Integer> result =notificationService.notify(temps,mockThermoMeter(),false);
        Assert.assertEquals(2,result.get(0d).intValue());
        Assert.assertEquals(1,result.get(100d).intValue());

    }
    @Test
    public void givenThermometerAndSourceTempWithNegativeFreezeWhenProcessedThenNoRepeatedNotifications() {
        Double[] temps ={0d,-0.5d,0.5d,0d,1.5d,0d};
        Map<Double,Integer> result =notificationService.notify(temps,mockThermoMeter(),false);
        Assert.assertEquals(2,result.get(0d).intValue());

    }


    private Thermometer mockThermoMeter() {
        Thermometer thermometer = new Thermometer();
        thermometer.setBoilingTemp(100);
        thermometer.setFreezingTemp(0);
        thermometer.setMaxFreezingTemp(0.5);
        thermometer.setMaxBoilingTemp(100.5);
        thermometer.setMinBoilingTemp(99.5);
        thermometer.setMinFreezingTemp(-0.5);
        return thermometer;
    }
    private Thermometer mockOneDirectionThermoMeter() {
        Thermometer thermometer = new Thermometer();
        thermometer.setBoilingTemp(100);
        thermometer.setFreezingTemp(0);
        thermometer.setMaxFreezingTemp(0.5);
        thermometer.setMaxBoilingTemp(100.5);
        thermometer.setMinBoilingTemp(100);
        thermometer.setMinFreezingTemp(0);
        return thermometer;
    }
}
