public class Demo08 {
    public static void main(String[] args) {
        Bicycle b = new Bicycle();
        b.move();
        b.pedal(5);

        Car car = new Car();
        car.move();
        car.startEngine();
    }
}