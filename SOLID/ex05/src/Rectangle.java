public class Rectangle {
    private int width, height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public int area() {
        return width * height;
    }
}