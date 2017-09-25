package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) { if ( args.length == 0 ) {
        throw new IllegalArgumentException(" No directory given to index.") ; }
        final File indexableDirectory = new File(args[0]);
        //TODO: Index all files in indexableDirectory



        Scanner keyboard = new Scanner(System.in);
        while (true)   {
            System.out.print("search>") ;
            final String line = keyboard.nextLine();
            //TODO: Search indexed files for words in line
            for (File file : listFiles(indexableDirectory)) {
                System.out.println(file.getAbsoluteFile());
            }
            if (line.equals("end")) {
                break;
            }




        }
    }

    public static ArrayList<File> listFiles(File directory) {
        ArrayList<File> files = new ArrayList<File>();

        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                files.add(file);
            } else if (file.isDirectory()) {
                files.addAll(listFiles(file));
            }
        }

        return files;
    }
}
