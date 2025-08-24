public class Decoder implements IDecoder{

    @Override
    public Frame decode(byte [] fileBytes) {
        return new Frame(fileBytes);
    }
    
}
