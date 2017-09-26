package com.company;

import java.io.File;
import java.util.ArrayList;

public static class Utils {
    public static ArrayList<File> ListFiles(File directory) {
        ArrayList<File> files = new ArrayList<File>();

        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                files.add(file);
            } else if (file.isDirectory()) {
                files.addAll(ListFiles(file));
            }
        }

        return files;
    }
}
