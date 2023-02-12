package ResourceManager;

import java.util.concurrent.Semaphore;

public class Resource {

    private static int availableUnits = 100;
    private static Semaphore semaphore = new Semaphore(1);

    public static int getAvailableUnits() {
        return availableUnits;
    }

    public static void setAvailableUnits(int availableUnits) {
        Resource.availableUnits = availableUnits;
    }

    public static Semaphore getSemaphore() {
        return semaphore;
    }

    public static void setSemaphore(Semaphore semaphore) {
        Resource.semaphore = semaphore;
    }

}