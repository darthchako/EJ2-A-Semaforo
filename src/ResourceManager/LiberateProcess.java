package ResourceManager;

import java.util.Random;

public class LiberateProcess extends Thread {

    private int i;

    public LiberateProcess(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        try {
            Resource.getSemaphore().acquire();
            Resource.setAvailableUnits(Resource.getAvailableUnits() + i);
            System.out.println("Process " + getName() + " released " + i + " units, remaining: " + Resource.getAvailableUnits());
            Resource.getSemaphore().release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
