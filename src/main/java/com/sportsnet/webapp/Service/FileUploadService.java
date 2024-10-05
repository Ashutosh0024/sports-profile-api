package com.sportsnet.webapp.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileUploadService {

    private final String uploadDir ="src/main/resources/static/uploads/";

    public String uploadFile(MultipartFile file) throws IOException {
        // Create directory if not exists
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdir();
        }

        // Save the file to the upload directory
        String fileName = file.getOriginalFilename();
        Path filePath = Paths.get(uploadDir, fileName);
        Files.write(filePath, file.getBytes());

        // Return the file path (or URL if hosted somewhere else)
        return "/uploads/" + fileName;
    }
}

