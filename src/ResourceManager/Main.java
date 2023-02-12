package ResourceManager;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
 //       for (int i = 1; i <= 100; i++) {
        while(true) {
            int r = random.nextInt(4) + 1;
            int l = random.nextInt(4) + 1;
            new ReserveProcess(r).start();
            new LiberateProcess(l).start();
        }
    }

}