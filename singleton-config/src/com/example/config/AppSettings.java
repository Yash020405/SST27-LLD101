package com.example.config;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

/**
 * QUESTION: FAULTY "Singleton": public constructor, getInstance() returns a NEW
 * instance each time,
 * not thread-safe, reload allowed anytime, mutable global state,
 * reflection+serialization-friendly.
 *
 * :: Singleton design for thread safety.
 */
public class AppSettings implements Serializable {
    private static final long serialVersionUID = 1L;
    private final Properties props = new Properties();

    // Private constructor
    private AppSettings() {
        if (Holder.INSTANCE != null) {
            throw new IllegalStateException("Instance already created");
        }
    }

    // Static inner class for lazy-loaded singleton
    private static class Holder {
        private static final AppSettings INSTANCE = new AppSettings();
    }

    public static AppSettings getInstance() {
        return Holder.INSTANCE;
    }

    // Ensure deserialization returns the same instance
    private Object readResolve() throws ObjectStreamException {
        return getInstance();
    }

    public void loadFromFile(Path file) {
        try (InputStream in = Files.newInputStream(file)) {
            props.load(in);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public String get(String key) {
        return props.getProperty(key);
    }
}
