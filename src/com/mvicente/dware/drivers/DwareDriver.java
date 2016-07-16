package com.mvicente.dware.drivers;

import com.mvicente.dware.utils.Dice;
import com.mvicente.dware.utils.WordKey;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class DwareDriver
{
    final int STANDARD_DICE_SIDES = 6;
    final String digitPool[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    final String specialPool[] = {"`", "~", "!", "@", "#", "$", "%", "^", "&", "*", "'", "\"", "?", ".", ",", "\\", "/", "-", "_", "|"};
    final String bracketPool[] = {"(", ")", "[", "]", "{", "}", "<", ">"};

    private Dice dice;
    private Random generator;
    private WordKey wKey;
    private ArrayList<String> separatorPool;

    public DwareDriver(Random generator)
    {
        this.dice = new Dice(generator, STANDARD_DICE_SIDES);
        this.generator = generator;
        this.wKey = new WordKey();
        this.separatorPool = new ArrayList<String>();
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
    public String generatePassword(int numOfWords)
    {
        String password;

        StringBuilder passBuilder;
        passBuilder = new StringBuilder();

        for(int i = 0; i < numOfWords; i++)
        {
            passBuilder.append(this.getWord());
            if(i != numOfWords - 1)
            {
                passBuilder.append(this.getSeparator());
            }
        }

        password = passBuilder.toString();

        return password;
    }

    // Selects a single separator character from the current pool
    private String getSeparator()
    {
        String separator;

        Dice tempDie = new Dice(generator, separatorPool.size());

        separator = separatorPool.get(tempDie.roll() - 1);

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

    private void buildSeparatorPool(boolean digitPool, boolean specialPool, boolean bracketPool)
    {
        if(digitPool)
        {
            separatorPool.addAll(Arrays.asList(this.digitPool));
        }

        if(specialPool)
        {
            separatorPool.addAll(Arrays.asList(this.specialPool));
        }

        if(bracketPool)
        {
            separatorPool.addAll(Arrays.asList(this.bracketPool));
        }
    }
}
