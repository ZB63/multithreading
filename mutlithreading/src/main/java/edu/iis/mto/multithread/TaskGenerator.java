package edu.iis.mto.multithread;

public class TaskGenerator {
    public Runnable generateTask(PatriotBattery patriotBattery,Scud scud, int shots) {
        return () -> {
            for (int i = 0; i < shots; i++) {
                patriotBattery.launchPatriot(scud);
            }
        };
    }
}
