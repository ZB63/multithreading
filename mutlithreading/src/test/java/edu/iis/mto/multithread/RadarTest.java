package edu.iis.mto.multithread;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class RadarTest {

    @RepeatedTest(100)
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        int howManyShots = 10;
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        CommandLauncher commandLauncher = mock(CommandLauncher.class);
        TaskGenerator taskGenerator = new TaskGenerator();

        doAnswer(x -> {
            Runnable runnable = (Runnable) x.getArguments()[0];
            runnable.run();
            return null;
        }).when(commandLauncher).launchCommand(any(Runnable.class));

        BetterRadar betterRadar =new BetterRadar(batteryMock, taskGenerator, commandLauncher, howManyShots);
        Scud enemyMissle = new Scud();
        betterRadar.notice(enemyMissle);

        verify(batteryMock, times(howManyShots)).launchPatriot(enemyMissle);
    }

}
