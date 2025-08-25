public class Player {

    private final IDecoder decoder;
    private final IDrawUI drawer;
    private final FrameCache cache;

    public Player(IDecoder decoder, IDrawUI drawer, FrameCache cache) {
        this.decoder = decoder;
        this.drawer = drawer;
        this.cache = cache;
    }

    public void play(byte[] fileBytes){
        // decode
        Frame f = decoder.decode(fileBytes); // pretend decoding
        cache.store(f);
        // draw UI
        drawer.draw(f);
        // cache
        cache.isLast();
    }
}