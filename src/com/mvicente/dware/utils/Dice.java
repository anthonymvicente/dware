package com.mvicente.dware.utils;

import java.util.Random;

public class Dice
{
    private Random rand;
    private int numSides;

    public Dice(Random generator, int numSides)
    {
        this.rand = generator;
        this.numSides = numSides;
    }

    public int roll()
    {
        return this.rand.nextInt(numSides) + 1;
    }

    public int[] multiRoll(int numRolls)
    {
        int results[] = new int[numRolls];

        for(int i = 0; i < numRolls; i++)
        {
            results[i] = this.roll();
        }

        return results;
    }
}
