package semaforo;

import java.util.Random;

public class Process extends Thread {
    private ResourceManager resourceManager;
    private int units;

    public Process(ResourceManager resourceManager, int units) {
        this.resourceManager = resourceManager;
        this.units = units;
    }

    @Override
    public void run() {
        try {
        	Random num = new Random();
            int exectime = num.nextInt(300 -10 + 1) + 10;
            resourceManager.reserveResource(units);
            sleep(exectime);
            resourceManager.releaseResource(units);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}