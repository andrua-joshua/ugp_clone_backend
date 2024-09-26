package com.ugp.clone_ugp.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class DataSavingService {

    // Base URL for accessing images online
    @Value("${server.url}")
    private String serverUrl;

    // Directory where images will be saved
    @Value("${upload.directory}")
    private String uploadDirectory;

    public String saveAndGetUrl(MultipartFile file) throws IOException {
        // Create directory if it doesn't exist
        File directory = new File(uploadDirectory);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Create unique file name to avoid conflicts (you can customize this)
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

        // Save the file to the file system
        Path filePath = Paths.get(uploadDirectory, fileName);
        Files.write(filePath, file.getBytes());

        // Return the URL for accessing the image
        return serverUrl + "/data/" + fileName;
    }
}
