public class Demo06 {
    public static void main(String[] args) {
        Aviary aviary = new Aviary();

        Pigeon pigeon = new Pigeon();
        Penguin penguin = new Penguin();

        aviary.release(pigeon);
        aviary.release(penguin);
    }
}