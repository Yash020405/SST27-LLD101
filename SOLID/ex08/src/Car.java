public class Car implements Vehicle, EnginePowered {
    @Override
    public void move() {
        System.out.println("Car driving");
    }

    @Override
    public void startEngine() {
        System.out.println("Engine started");
    }
}
