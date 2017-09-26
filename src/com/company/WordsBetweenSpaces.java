package com.company;

public class WordsBetweenSpaces implements ITextLineExtractStrategy {
    @Override
    public String[] ExtractWordsFromLine(String line) {
        return line.split("\\s+");
    }
}
