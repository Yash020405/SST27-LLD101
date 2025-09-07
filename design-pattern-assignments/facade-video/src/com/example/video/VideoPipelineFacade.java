package com.example.video;

import java.nio.file.Path;
import java.util.Objects;

public class VideoPipelineFacade {

    private final Decoder decoder;
    private final FilterEngine filterEngine;
    private final Encoder encoder;
    private final SharpenAdapter sharpenAdapter;

    public VideoPipelineFacade(Decoder decoder, FilterEngine filterEngine, Encoder encoder,
            SharpenAdapter sharpenAdapter) {
        this.decoder = Objects.requireNonNull(decoder);
        this.filterEngine = Objects.requireNonNull(filterEngine);
        this.encoder = Objects.requireNonNull(encoder);
        this.sharpenAdapter = Objects.requireNonNull(sharpenAdapter);
    }

    public Path process(Path src, Path out, boolean gray, Double scale, Integer sharpenStrength) {
        Frame[] frames = decoder.decode(src);

        if (gray) {
            frames = filterEngine.grayscale(frames);
        }

        if (scale != null) {
            frames = filterEngine.scale(frames, scale);
        }

        if (sharpenStrength != null) {
            frames = sharpenAdapter.applySharpen(frames, sharpenStrength);
        }

        return encoder.encode(frames, out);
    }
}
