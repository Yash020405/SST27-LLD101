package com.example.report;

import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;

public class ReportBundleFacade {

    private final JsonWriter jsonWriter;
    private final Zipper zipper;
    private final AuditLog auditLog;

    public ReportBundleFacade(JsonWriter jsonWriter, Zipper zipper, AuditLog auditLog) {
        this.jsonWriter = Objects.requireNonNull(jsonWriter);
        this.zipper = Objects.requireNonNull(zipper);
        this.auditLog = Objects.requireNonNull(auditLog);
    }

    public Path export(Map<String, Object> data, Path outDir, String baseName) {
        try {
            Path jsonFile = jsonWriter.write(data, outDir, baseName);
            Path zipFile = zipper.zip(jsonFile, outDir.resolve(baseName + ".zip"));
            auditLog.log("Exported: " + zipFile);
            return zipFile;
        } catch (Exception e) {
            throw new RuntimeException("Failed to export report bundle", e);
        }
    }
}
