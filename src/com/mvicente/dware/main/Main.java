package com.mvicente.dware.main;

import com.mvicente.dware.utils.CLI;
import com.mvicente.dware.utils.Menu;

import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    {
        CLI tCLI = new CLI();

        int choice = -1;
        String input;
        boolean validChoice = false;
        Scanner inputReader = new Scanner(System.in);

        while(!validChoice)
        {
            tCLI.displayMenu(Menu.MAIN);

            try
            {
                input = inputReader.next();
                choice = Integer.parseInt(input);
            }
            catch (NumberFormatException ex)
            {
                choice = -1;
            }

            validChoice = tCLI.makeChoice(Menu.MAIN, choice);
        }
    }
}
