package com.example.imports;

import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class CsvProfileImporter implements ProfileImporter {

    private final NaiveCsvReader csvReader;
    private final ProfileService profileService;

    public CsvProfileImporter(NaiveCsvReader csvReader, ProfileService profileService) {
        this.csvReader = Objects.requireNonNull(csvReader);
        this.profileService = Objects.requireNonNull(profileService);
    }

    @Override
    public int importFrom(Path csvFile) {
        List<String[]> rows = csvReader.read(csvFile);
        int successCount = 0;

        for (String[] row : rows) {
            if (row.length < 3 || row[0].isBlank() || row[1].isBlank() || !row[1].contains("@")) {
                System.out.println("Skipping invalid row: " + String.join(",", row));
                continue;
            }

            String id = row[0].trim();
            String email = row[1].trim();
            String displayName = row[2].trim();

            try {
                profileService.createProfile(id, email, displayName);
                successCount++;
            } catch (IllegalArgumentException e) {
                System.out.println("Skipping invalid row: " + String.join(",", row));
            }
        }

        return successCount;
    }
}