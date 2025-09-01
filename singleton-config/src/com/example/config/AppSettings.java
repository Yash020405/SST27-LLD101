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
 * :: Refactored to use Double-Checked Locking with volatile for thread safety.
 */
public class AppSettings implements Serializable {
    private static final long serialVersionUID = 1L;
    private static volatile AppSettings instance; // Volatile ensures visibility across threads
    private final Properties props = new Properties();

    private AppSettings() {
        // Prevent reflection-based instantiation
        if (instance != null) {
            throw new IllegalStateException("Instance already created");
        }
    }

    public static AppSettings getInstance() {
        if (instance == null) { // First check (no locking)
            synchronized (AppSettings.class) {
                if (instance == null) { // Second check (with locking)
                    instance = new AppSettings();
                }
            }
        }
        return instance;
    }

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
