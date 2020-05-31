package edu.iis.mto.multithread;

public class LaunchingSystem {
    private PatriotBattery battery;
    private int launches;

    public LaunchingSystem(PatriotBattery battery, int launches) {
        this.battery = battery;
        this.launches = launches;
    }

    public void launch(Scud enemyMissle) {
        for (int i = 0; i < launches; i++) {
            battery.launchPatriot(enemyMissle);
        }
    }
}
