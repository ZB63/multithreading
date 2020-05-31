package edu.iis.mto.multithread;

public class BetterRadar {
    private PatriotBattery battery;
    private int launches;

    public BetterRadar(PatriotBattery battery, int launches) {
        this.battery = battery;
        this.launches = launches;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot(enemyMissle);
    }

    private void launchPatriot(Scud enemyMissle) {
        Runnable launchPatriotTask = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < launches; i++) {
                    battery.launchPatriot(enemyMissle);
                }
            }
        };

        Thread launchingThread = new Thread(launchPatriotTask);
        launchingThread.start();

        try {
            launchingThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
