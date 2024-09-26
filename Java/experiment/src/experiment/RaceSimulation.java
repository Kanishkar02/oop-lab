package experiment;

class Runner implements Runnable {
    private String name;
    private static final int TOTAL_DISTANCE = 100;
    private static boolean raceOver = false;

    public Runner(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int distance = 0; distance < TOTAL_DISTANCE && !raceOver; distance += (int)(Math.random() * 10) + 1) {
            System.out.println(name + " covered " + distance + " meters.");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(name + " was interrupted.");
            }
            if (distance >= TOTAL_DISTANCE) {
                raceOver = true;
                System.out.println(name + " has won the race!");
            }
        }
    }
}

public class RaceSimulation {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runner("Runner 1")).start();
        new Thread(new Runner("Runner 2")).start();
        System.out.println("The race has started!");
    }
}
