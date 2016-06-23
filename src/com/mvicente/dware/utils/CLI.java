package com.mvicente.dware.utils;

import java.util.Arrays;

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

    public void displayMenu(Menu menu)
    {
        switch(menu)
        {
            case MAIN:
                this.displayMainMenu();
                break;
        }
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

    public void displayMenuError(Menu menu)
    {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Invalid menu choice, please use a value between 0 and " + this.menuRange[menu.value]);
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
