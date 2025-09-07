package com.example.video;

public class SharpenAdapter {

    private final LegacySharpen legacySharpen;

    public SharpenAdapter(LegacySharpen legacySharpen) {
        this.legacySharpen = legacySharpen;
    }

    public Frame[] applySharpen(Frame[] frames, int strength) {
        String handle = "HANDLE";
        handle = legacySharpen.applySharpen(handle, strength);
        return frames;
    }
}