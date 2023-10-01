package com.scraft.infrastructure.jsonreader;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
public class FileReader {

    public String readStringJson(String resourceName) {
        try {
            URL resource = getClass().getClassLoader().getResource(resourceName);
            Path filePath = Path.of(resource.getFile());
            return Files.readString(filePath);
        } catch (IOException ioe) {
            String errorMessage = "Not able to find resource " + resourceName;
            log.error(errorMessage);
            throw new RuntimeException(errorMessage);
        }
    }

}
