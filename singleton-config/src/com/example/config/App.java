package com.example.config;

import java.nio.file.Files;
import java.nio.file.Path;

public class App {
    public static void main(String[] args) throws Exception {
        String path = args.length > 0 ? args[0] : "app.properties";
        AppSettings settings = AppSettings.getInstance();

        if (Files.exists(Path.of(path))) {
            settings.loadFromFile(Path.of(path));
        } else {
            System.out.println("app.properties not found. Using default values.");
            settings.get("app.name");
        }

        System.out.println("app.name=" + settings.get("app.name"));
        System.out.println("instance=" + System.identityHashCode(settings));
    }
}
