package edu.iis.mto.multithread;

public class BetterRadar {
    private PatriotBattery battery;
    private LaunchingSystem launchingSystem;

    public BetterRadar(PatriotBattery battery, LaunchingSystem launchingSystem) {
        this.battery = battery;
        this.launchingSystem = launchingSystem;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot(enemyMissle);
    }

    private void launchPatriot(Scud enemyMissle) {
        Runnable launchPatriotTask = new Runnable() {

            @Override
            public void run() {
                launchingSystem.launch(enemyMissle);
            }
        };

        Thread launchingThread = new Thread(launchPatriotTask);
        launchingThread.start();
    }
}
