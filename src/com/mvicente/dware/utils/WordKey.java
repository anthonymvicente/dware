package com.mvicente.dware.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class WordKey
{
    private HashMap<Integer, String> wordMap;

    public WordKey(String wordFile)
    {
        wordMap = new HashMap<>();
        readWordList(wordFile);
    }

    public String getWord(int key)
    {
        return wordMap.get(key);
    }

    public String getWord(String key)
    {
        String value = null;
        try
        {
            value = wordMap.get(Integer.parseInt(key));
        }
        catch (NumberFormatException ex)
        {
            ex.printStackTrace();
        }

        return value;
    }

    public void readWordList(String wordFile)
    {
        try
        {
            BufferedReader breader = new BufferedReader(new FileReader(wordFile));
            String line;
            while ((line = breader.readLine()) != null)
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
        catch(IOException|IndexOutOfBoundsException|NumberFormatException ex)
        {
            ex.printStackTrace();
        }
    }
}
