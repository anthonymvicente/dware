package com.mvicente.dware.utils;

public class CLI
{
    private String wordFile;
    private int currentChoice;
    private int menuRange;

    public CLI()
    {
        this.wordFile = "(none)";
        this.currentChoice = -1;
        this.menuRange = 2;
    }

    public void displayMenu()
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

    public boolean makeChoice(int choice)
    {
        if(choice > this.menuRange || choice < 0)
        {
            this.currentChoice = -1;
            this.displayMenuError();
            return false;
        } else
        {
            this.currentChoice = choice;
            return true;
        }
    }

    public int getChoice()
    {
        return this.currentChoice;
    }

    public void displayMenuError()
    {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Invalid menu choice, please use a value between 0 and " + this.menuRange);
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
