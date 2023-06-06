package org.application;

import java.io.*;
import java.util.HashMap;
import java.util.Properties;

public class Strings {
    public static void main(String[] args) throws IOException {
        // Create a new HashMap
        HashMap<String, String> newStrings = new HashMap<>();
        // Add some key-value pairs to the HashMap
        newStrings.put("ask-name-key", "What is your name?");
        newStrings.put("my-name-key", "My name is Nitin");
        newStrings.put("greeting-key", "Hi, nice to meet you");

        // Create a Properties object
        Properties properties = new Properties();
        // Get the path to the properties file
        String propertiesFilePath = "english-strings.properties";
        // Check if the properties file exists
        File propertiesFile = new File(propertiesFilePath);

        if (propertiesFile.exists())
            append(properties, propertiesFile, newStrings);
        else
            create(properties, propertiesFile, newStrings);
    }

    private static void create(Properties properties, File propertiesFile, HashMap<String, String> newStrings) throws IOException {
        for (String key : newStrings.keySet()) {
            properties.setProperty(key, newStrings.get(key));
        }
        properties.store(new FileOutputStream(propertiesFile), "");
    }

    private static void append(Properties properties, File propertiesFile, HashMap<String, String> newStrings) throws IOException {
        // Load the properties file
        properties.load(new FileInputStream(propertiesFile));
        for (String key : newStrings.keySet()) {
            properties.setProperty(key, newStrings.get(key));
        }
        properties.store(new FileOutputStream(propertiesFile), "");
    }
}
