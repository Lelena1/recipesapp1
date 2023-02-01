package me.luppolem.recipesapp1.services.impl;

import me.luppolem.recipesapp1.services.FilesService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FilesServiceImpl implements FilesService {
    @Value("${path.to.data.file}")
    private String dataFilePath;

    @Override
    public boolean saveToFile(String json,String dataFileName) {

        try {
            Path path = Path.of(dataFilePath, dataFileName);
            cleanDataFile(dataFileName);

            Files.writeString(path, json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String readFromFile(String dataFileName) {

        try {
            Path path = Path.of(dataFilePath, dataFileName);
            if (!Files.exists(path)) {
                throw new FileNotFoundException();
            }
            return Files.readString(path);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private boolean cleanDataFile(String dataFileName) {
        try {
            Path path = Path.of(dataFilePath, dataFileName);
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}

