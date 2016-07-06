package com.mvicente.dware.drivers;

import com.mvicente.dware.utils.WordKey;

import java.io.IOException;

public class DwareDriver
{
    public static boolean buildWordKey(WordKey wKey, String wordFilePath) throws IOException, IndexOutOfBoundsException, NumberFormatException
    {
        boolean success = false;

        wKey.readWordList(wordFilePath);

        success = true;
        return success;
    }
}
