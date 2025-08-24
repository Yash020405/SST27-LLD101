public class Square implements Shape {
    private int side;

    @Override
    public void resize(int width, int height) {
        this.side = Math.min(width, height);
    }

    @Override
    public int area() {
        return side * side;
    }
}