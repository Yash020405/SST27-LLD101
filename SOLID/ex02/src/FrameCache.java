public class FrameCache {
    private Frame last;

    public void store(Frame frame){
        this.last = frame;
    }

    public void isLast(){
        System.out.println("Cached last frame? " + (this.last!=null));
    }
}
