package semaforo;

public class Main {
    public static void main(String[] args) {
        ResourceManager resourceManager = new ResourceManager(10);

        for (int i = 1; i <= 20; i++) {
            int units = (int) (Math.random() * 6 + 1);
            Process process = new Process(resourceManager, units);
            process.start();
        }
    }
}