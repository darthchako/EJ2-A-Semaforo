package semaforo;

import java.util.concurrent.Semaphore;

public class ResourceManager {
    private int availableUnits;
    private Semaphore semaphore;

    public ResourceManager(int units) {
        availableUnits = units;
        semaphore = new Semaphore(units);
    }

    public void reserveResource(int units) throws InterruptedException {
        semaphore.acquire(units);
        availableUnits -= units;
        System.out.println("Process reserved " + units + " units. Available units: " + availableUnits);
    }

    public void releaseResource(int units) {
        semaphore.release(units);
        availableUnits += units;
        System.out.println("Process released " + units + " units. Available units: " + availableUnits);
    }
}