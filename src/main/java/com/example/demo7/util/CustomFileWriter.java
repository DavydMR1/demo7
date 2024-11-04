package com.example.demo7.util;

import org.springframework.context.annotation.Bean;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomFileWriter {
    public void createFile(String fileName) {
        CustomFileConnector.createDB(fileName);
    }

    public List<String> readAll(String fileName) {
        List<String> lines = new ArrayList<>();
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            if (line != null) {
                lines.add(line);
            }
            while (line != null) {
                line = reader.readLine();
                if (line != null) {
                    lines.add(line);
                }
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public void saveAll(String data, String fileName) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(data);
            writer.append('\n');
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveLine(String data, String fileName) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(data);
            writer.append('\n');
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
