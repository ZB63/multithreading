package edu.iis.mto.multithread;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class RadarTest {

    @Test
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        int times = 10;
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        BetterRadar betterRadar = new BetterRadar(batteryMock, times);
        Scud enemyMissle = new Scud();
        betterRadar.notice(enemyMissle);
        verify(batteryMock, times(times)).launchPatriot(enemyMissle);
    }

}
