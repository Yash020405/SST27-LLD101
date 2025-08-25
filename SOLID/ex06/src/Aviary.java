public class Aviary {
    public void release(Movable movable) {
        movable.move();
        System.out.println("Released!");
    }
}