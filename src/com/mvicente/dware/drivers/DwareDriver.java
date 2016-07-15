package com.mvicente.dware.drivers;

import com.mvicente.dware.utils.WordKey;

import java.io.IOException;

public class DwareDriver
{
    // Driver method for building a WordKey object
    // passes exceptions up to allow interfaces to handle them as they see fit
    public static void buildWordKey(WordKey wKey, String wordFilePath) throws IOException, IndexOutOfBoundsException, NumberFormatException
    {
        wKey.readWordList(wordFilePath);
    }

    // Base generate password method
    // genericized to allow different separators to be combined for generating passwords
    public static String generatePassword(int numOfWords, String seperatorPool[])
    {
        String password;

        return password;
    }

    // Selects a single separator character from the current pool
    public static String getSeparator(String seperatorPool[])
    {
        String separator;

        return separator;
    }
}
