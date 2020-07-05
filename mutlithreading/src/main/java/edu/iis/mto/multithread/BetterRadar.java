package edu.iis.mto.multithread;

public class BetterRadar {
    private PatriotBattery battery;
    private TaskGenerator taskGenerator;
    private CommandLauncher commandLauncher;
    private int shots;

    public BetterRadar(PatriotBattery battery, TaskGenerator taskGenerator, CommandLauncher commandLauncher, int shots) {
        this.battery = battery;
        this.taskGenerator = taskGenerator;
        this.commandLauncher = commandLauncher;
        this.shots = shots;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot(enemyMissle);
    }

    private void launchPatriot(Scud enemyMissle) {
        Runnable task = taskGenerator.generateTask(battery, enemyMissle, shots);
        commandLauncher.launchCommand(task);
    }
}
