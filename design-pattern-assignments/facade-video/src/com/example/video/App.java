package com.example.video;

import java.nio.file.Path;

public class App {
    public static void main(String[] args) {
        VideoPipelineFacade facade = new VideoPipelineFacade(new Decoder(), new FilterEngine(), new Encoder(),
                new SharpenAdapter(new LegacySharpen()));
        Path out = facade.process(Path.of("in.mp4"), Path.of("out.mp4"), true, 0.5, 10);
        System.out.println("Wrote " + out);
    }
}
