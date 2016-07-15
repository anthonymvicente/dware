package com.mvicente.dware.utils;

import java.util.Arrays;
import java.util.Scanner;

public class CLI
{
    private String wordFile;

    private int choice[];
    private int menuRange[];

    public CLI()
    {
        this.wordFile = "(none)";

        choice = new int[1];
        Arrays.fill(choice, -1);

        menuRange = new int[]{2};
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

    public String wordFileLoad(Scanner inputReader)
    {
        System.out.println("Please enter the path to the Word File.");
        System.out.print("Path: ");

        return inputReader.next();
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
