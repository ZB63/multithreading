package edu.iis.mto.multithread;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class RadarTest {

    @RepeatedTest(100)
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        int howManyShots = 10;
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        LaunchingSystem launchingSystem = new LaunchingSystem(batteryMock, howManyShots);
        Scud enemyMissle = new Scud();
        launchingSystem.launch(enemyMissle);
        verify(batteryMock, times(howManyShots)).launchPatriot(enemyMissle);
    }

}
