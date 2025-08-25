public class Bicycle implements Vehicle, Pedalable {
    @Override
    public void move() {
        System.out.println("Bicycle moving !!");
    }

    @Override
    public void pedal(int effort) {
        System.out.println("Pedal effort " + effort);
    }
}