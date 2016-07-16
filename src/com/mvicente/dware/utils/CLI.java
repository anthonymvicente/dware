package com.mvicente.dware.utils;

import java.util.Arrays;
import java.util.Scanner;

public class CLI
{
    private String wordFile;
    private int numWords;
    private boolean poolFlags[];

    private int choice[];
    private int menuRange[];

    public CLI()
    {
        this.wordFile = "(none)";

        choice = new int[2];
        Arrays.fill(choice, -1);

        menuRange = new int[]{2, 3};

        numWords = 0;
        poolFlags = new boolean[3];
        Arrays.fill(poolFlags, false);
    }

    public boolean displayMenu(Menu menu, Scanner inputReader)
    {
        boolean validChoice = false;

        while(!validChoice)
        {
            switch (menu)
            {
                case MAIN:
                    this.displayMainMenu();
                    break;
                case GEN:
                    this.displayGenMenu();
                    break;
            }

            int choice = -1;

            try
            {
                choice = Integer.parseInt(inputReader.next());
            } catch (NumberFormatException ex)
            {
                choice = -1;
            }

            validChoice = makeChoice(menu, choice);
        }

        return validChoice;
    }

    public void displayMainMenu()
    {
        System.out.println("Current Word File: " + this.wordFile);
        System.out.println("Please select an action:");
        System.out.println("1) Load Word File");
        System.out.println("2) Generate Passphrase");
        System.out.println();
        System.out.println("0) Exit");
        System.out.println();
        System.out.print("action: ");
    }

    public void displayGenMenu()
    {
        System.out.println("Current Word File: " + this.wordFile);
        System.out.println("Current Settings:");
        System.out.println("\tNumber of Words: " + numWords);
        System.out.println("\tSeparators");
        System.out.print("\t");
        if(poolFlags[0])
        {
            System.out.print("[x] Digits");
        }
        else
        {
            System.out.print("[ ] Digits");
        }
        if(poolFlags[1])
        {
            System.out.print("[x] Special Characters");
        }
        else
        {
            System.out.print("[ ] Special Characters");
        }
        if(poolFlags[2])
        {
            System.out.print("[x] Brackets");
        }
        else
        {
            System.out.print("[ ] Brackets");
        }
        System.out.println();
        System.out.println("Please select an action:");
        System.out.println("1) Enter Number of Words");
        System.out.println("2) Choose Separators");
        System.out.println("3) Generate Password");
        System.out.println();
        System.out.println("0) Return to Main Menu");
        System.out.println();
        System.out.println("action: ");
    }

    public String wordFileLoad(Scanner inputReader)
    {
        System.out.println("Please enter the path to the Word File.");
        System.out.print("Path: ");

        return inputReader.next();
    }

    public void chooseNumWords(Scanner inputReader)
    {
        System.out.println("Please enter the number of words you'd like in your password.");

        boolean validNumber = false;
        int userNum = -1;

        while (!validNumber)
        {
            System.out.println("Number of words: ");
            try
            {
                userNum = Integer.parseInt(inputReader.next());
            }
            catch(NumberFormatException ex)
            {
                userNum = -1;
                printBlanks(3);
                System.out.println("Please enter a number.");
                printBlanks(3);
            }

            if(userNum < 1)
            {
                printBlanks(3);
                System.out.println("Please enter a positive number.");
                printBlanks(3);
            }
            else
            {
                validNumber = true;
            }
        }

        this.numWords = userNum;
    }

    public boolean makeChoice(Menu menu, int choice)
    {
        if(choice > this.menuRange[menu.value] || choice < 0)
        {
            this.choice[menu.value] = -1;
            this.displayMenuError(menu);
            return false;
        } else
        {
            this.choice[menu.value] = choice;
            return true;
        }
    }

    public int getChoice(Menu menu)
    {
        return this.choice[menu.value];
    }

    public void setWordFile(String wordFile)
    {
        this.wordFile = wordFile;
    }

    public int getNumWords()
    {
        return this.numWords;
    }

    public boolean[] getPoolFlags()
    {
        return this.poolFlags;
    }

    public void displayMenuError(Menu menu)
    {
        this.printBlanks(3);
        System.out.println("Invalid menu choice, please use a value between 0 and " + this.menuRange[menu.value]);
        this.printBlanks(3);
    }

    public void printBlanks(int numLines)
    {
        for(int i = 0; i < numLines; i++)
        {
            System.out.println();
        }
    }
}
