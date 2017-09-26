package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException { if ( args.length == 0 ) {
        throw new IllegalArgumentException(" No directory given to index.") ; }

        final File indexableDirectory = new File(args[0]);

        HashMap<File, Trie> indexes = new HashMap<>();

        for (File file : Utils.ListFiles(indexableDirectory)) {
            System.out.println(file.getAbsoluteFile());
            indexes.put(file, IndexFile(file, new WordsBetweenSpaces()));
        }

        Scanner keyboard = new Scanner(System.in);
        while (true)   {
            System.out.print("search>") ;
            final String line = keyboard.nextLine();

            if (line.equals("exit")) {
                break;
            }

            for (Map.Entry<File, Trie> entry : indexes.entrySet()) {
                System.out.println(entry.getKey().getAbsolutePath() + ": " + SearchAndRank(line, entry.getValue()));
            }
        }
    }

    private static int SearchAndRank(String statement, Trie trie) {
        double found = 0;
        String[] statementItems = statement.split("\\s+");
        for (String statementItem : statementItems) {
            if (trie.ContainsWord(statementItem)) {
                found++;
            }
        }
        return (int)((found / (double)statementItems.length) * 100.0);
    }

    private static Trie IndexFile(File file, ITextLineExtractStrategy textLineExtractStrategy) {
        FileInputStream inputStream = null;
        Scanner scanner = null;
        Trie trie = new Trie();

        try {
            inputStream = new FileInputStream(file.getAbsolutePath());
            scanner = new Scanner(inputStream, "UTF-8");

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                for (String word : textLineExtractStrategy.ExtractWordsFromLine(line)) {
                    trie.Add(word);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (scanner != null) {
                scanner.close();
            }
        }
        return trie;
    }
}
