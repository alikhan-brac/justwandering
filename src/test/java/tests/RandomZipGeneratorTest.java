package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class RandomZipGeneratorTest {

    private String downloadsFolderPath;
    private Random random;
    private static final long MAX_ZIP_SIZE_BYTES = 9 * 1024 * 1024; // 9MB

    @BeforeClass
    public void setUp() {
        // Get the user's Downloads folder path
        downloadsFolderPath = System.getProperty("user.home") + "/Downloads/try1/";
        System.out.println("Saving ZIP files to: " + downloadsFolderPath);

        // Create Downloads folder if it doesn't exist
        Path downloadsPath = Paths.get(downloadsFolderPath);
        if (!Files.exists(downloadsPath)) {
            try {
                Files.createDirectories(downloadsPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        random = new Random();
    }

    @Test
    public void generateRandomZipFiles() throws IOException {
        for (int i = 1; i <= 2; i++) {
            String zipFileName = "file-" + i + ".zip";
            String zipFilePath = downloadsFolderPath + zipFileName;

            try (FileOutputStream fos = new FileOutputStream(zipFilePath);
                 ZipOutputStream zos = new ZipOutputStream(fos)) {

                // Ensure the ZIP stays under 9MB
                long currentSize = 0;
                int fileCount = 0;

                while (currentSize < MAX_ZIP_SIZE_BYTES) {
                    String entryName = "file_" + (++fileCount) + ".dat";
                    ZipEntry zipEntry = new ZipEntry(entryName);
                    zos.putNextEntry(zipEntry);

                    // Write random binary data (1KB - 500KB per file)
                    int fileSize = 1024 + random.nextInt(500 * 1024);
                    byte[] randomData = new byte[fileSize];
                    random.nextBytes(randomData); // Fill with random bytes
                    zos.write(randomData);
                    zos.closeEntry();

                    currentSize += fileSize;
                }
            }

            System.out.println("Generated: " + zipFilePath + " (Size: " +
                    new File(zipFilePath).length() / (1024 * 1024) + " MB)");
        }
    }
}