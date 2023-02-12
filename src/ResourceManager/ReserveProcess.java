package ResourceManager;

import java.util.Random;

public class ReserveProcess extends Thread {

    private int r;

    public ReserveProcess(int r) {
        this.r = r;
    }

    @Override
    public void run() {
        try {
            Resource.getSemaphore().acquire();
            if (r > Resource.getAvailableUnits()) {
  
        		Random num = new Random();
        		int ReserveTime = num.nextInt(300 - 10 + 1) + 10;
        		
        		try {
        			sleep(ReserveTime);
        		} catch (Exception e) {
        			e.printStackTrace();
        		}
            	
                System.out.println("Not enough units available, process " + getName() + " waiting...");
                Resource.getSemaphore().release();
                
                run();
            } else {
        		try {
            		Random num = new Random();
            		int ReserveTime = num.nextInt(300 - 10 + 1) + 10;
        			sleep(ReserveTime);
        			} catch (Exception e) {
        				e.printStackTrace();
        			}
                Resource.setAvailableUnits(Resource.getAvailableUnits() - r);
                System.out.println("Process " + getName() + " reserved " + r + " units, remaining: " + Resource.getAvailableUnits());
                Resource.getSemaphore().release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
