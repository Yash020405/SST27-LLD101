public class Demo02 {
    public static void main(String[] args) {
        Decoder decoder = new Decoder();
        IDrawUI drawer = new DrawUI();
        FrameCache cache = new FrameCache();

        Player player = new Player(decoder, drawer, cache);
        player.play(new byte[]{1,2,3,4});
    }
}
