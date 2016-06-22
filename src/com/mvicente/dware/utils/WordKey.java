package com.mvicente.dware.utils;

import java.util.HashMap;

public class WordKey
{
    private HashMap<Integer, String> wordMap;

    public WordKey(String wordFile)
    {
        wordMap = new HashMap<>();
        readWordList(wordFile);
    }

    public void readWordList(String wordFile)
    {

    }
}
