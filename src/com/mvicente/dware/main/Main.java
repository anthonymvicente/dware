package com.mvicente.dware.main;

import com.mvicente.dware.utils.CLI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    {
        CLI tCLI = new CLI();

        int choice = -1;
        boolean validChoice = false;
        Scanner inputReader = new Scanner(System.in);

        while(!validChoice)
        {
            tCLI.displayMenu();

            try
            {
                choice = inputReader.nextInt();
            }
            catch (InputMismatchException ex)
            {
                choice = -1;
                System.out.println(choice);
                System.exit(-1);
            }

            validChoice = tCLI.makeChoice(choice);
        }
    }
}
