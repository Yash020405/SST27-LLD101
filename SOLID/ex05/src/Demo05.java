public class Demo05 {
    
    static int areaAfterResizeRectangle(Rectangle r) {
        r.setWidth(5);
        r.setHeight(4);
        return r.area();
    }

    static int areaAfterResizeSquare(Square s) {
        s.setSide(4);
        return s.area();
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        System.out.println(areaAfterResizeRectangle(rectangle)); // 20

        Square square = new Square();
        System.out.println(areaAfterResizeSquare(square)); // 16
    }
}