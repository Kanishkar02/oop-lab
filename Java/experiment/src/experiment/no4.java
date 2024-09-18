package experiment;

public class no4 {
    String model;
    String color;

    public no4(String model, String color) {
        this.model = model;
        this.color = color;
    }

    public void start() {
        System.out.println("The car " + model + " is starting.");
    }

    public void stop() {
        System.out.println("The car " + model + " is stopping.");
    }

    public static void main(String[] args) {
        no4 car1 = new no4("Toyota Corolla", "Red");

        car1.start();
        car1.stop();
    }
}
