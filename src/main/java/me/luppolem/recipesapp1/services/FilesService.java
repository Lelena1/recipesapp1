package me.luppolem.recipesapp1.services;

public interface FilesService {
    boolean saveToFile(String json,String dataFileName);

    String readFromFile(String dataFileName);
}
