package semaforo;

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
            resourceManager.reserveResource(units);
            sleep(1000);
            resourceManager.releaseResource(units);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}