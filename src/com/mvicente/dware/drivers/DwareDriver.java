package com.mvicente.dware.drivers;

import com.mvicente.dware.utils.Dice;
import com.mvicente.dware.utils.WordKey;

import java.io.IOException;
import java.util.Random;

public class DwareDriver
{
    final int STANDARD_DICE_SIDES = 6;

    private Dice dice;
    private Random generator;
    private WordKey wKey;

    public DwareDriver(Random generator)
    {
        this.dice = new Dice(generator, STANDARD_DICE_SIDES);
        this.generator = generator;
        wKey = new WordKey();
    }

    // Driver method for building a WordKey object
    // passes exceptions up to allow interfaces to handle them as they see fit
    public void buildWordKey(String wordFilePath) throws IOException, IndexOutOfBoundsException, NumberFormatException
    {
        wKey = new WordKey();
        wKey.readWordList(wordFilePath);
    }

    // Base generate password method
    // generalized to allow different separators to be combined for generating passwords
    public String generatePassword(int numOfWords, String separatorPool[])
    {
        String password;

        StringBuilder passBuilder = new StringBuilder();

        for(int i = 0; i < numOfWords; i++)
        {
            passBuilder.append(this.getWord());
            if(i != numOfWords - 1)
            {
                passBuilder.append(this.getSeparator(separatorPool));
            }
        }

        password = passBuilder.toString();

        return password;
    }

    // Selects a single separator character from the current pool
    private String getSeparator(String separatorPool[])
    {
        String separator;

        Dice tempDie = new Dice(generator, separatorPool.length);

        separator = separatorPool[tempDie.roll() - 1];

        return separator;
    }

    private String getWord()
    {
        StringBuilder intString = new StringBuilder();

        for(int i = 0; i < 5; i++)
        {
            intString.append(dice.roll());
        }

        return intString.toString();
    }
}
