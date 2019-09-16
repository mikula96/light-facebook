package com.consulteer.facebook.fileUpload;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Milos Stambolija on 16.9.2019.
 **/
@RestController
@RequestMapping(value = "/upload")
public class UploadController {

    private static final String CONTAINER_FOLDER = "D://UploadedImages//";

    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        if (multipartFile.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        byte[] bytes = multipartFile.getBytes();

        Path path = Paths.get(CONTAINER_FOLDER + multipartFile.getOriginalFilename());
        Files.write(path, bytes);

        return ResponseEntity.ok().build();
    }
}
