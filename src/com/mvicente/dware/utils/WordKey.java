package com.mvicente.dware.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class WordKey
{
    private HashMap<Integer, String> wordMap;

    public WordKey()
    {
        wordMap = new HashMap<>();
    }

    public String getWord(int key)
    {
        return wordMap.get(key);
    }

    public String getWord(String key) throws NumberFormatException
    {
        int iKey = 0;

        iKey = Integer.parseInt(key);

        String value = wordMap.get(iKey);

        return value;
    }

    public void readWordList(String wordFile) throws IOException, IndexOutOfBoundsException, NumberFormatException
    {
        BufferedReader bReader = new BufferedReader(new FileReader(wordFile));
        String line;
        while ((line = bReader.readLine()) != null)
        {
            String lineArr[] = line.split("\t");

            if(lineArr.length != 2)
            {
                throw new IndexOutOfBoundsException("Improperly formatted word file");
            }

            String key = lineArr[0];
            String value = lineArr[1];
            wordMap.put(Integer.parseInt(key), value);
        }
    }
}
