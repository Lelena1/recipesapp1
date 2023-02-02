package me.luppolem.recipesapp1.services;

import java.io.File;

public interface FilesService {
    boolean saveToFile(String json,String dataFileName);

    String readFromFile(String dataFileName);

    File getDataFile(String dataFileName);

    boolean cleanDataFile(String dataFileName);
}
