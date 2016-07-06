package com.mvicente.dware.main;

import com.mvicente.dware.drivers.DwareDriver;
import com.mvicente.dware.utils.CLI;
import com.mvicente.dware.utils.Menu;
import com.mvicente.dware.utils.WordKey;

import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    {
        CLI tCLI = new CLI();

        int choice;
        String input;

        boolean validChoice = false;
        boolean userExit = false;
        boolean opSuccess = false;

        Scanner inputReader = new Scanner(System.in);
        WordKey wKey = new WordKey();

        while(!userExit)
        {
            while (!validChoice)
            {
                tCLI.displayMenu(Menu.MAIN);

                try
                {
                    input = inputReader.next();
                    choice = Integer.parseInt(input);
                } catch (NumberFormatException ex)
                {
                    choice = -1;
                }

                validChoice = tCLI.makeChoice(Menu.MAIN, choice);
            }

            validChoice = false;

            switch(tCLI.getChoice(Menu.MAIN))
            {
                case 0:
                    userExit = true;
                    break;
                case 1:
                    String wordFile;
                    tCLI.displayWordFileLoad();
                    wordFile = inputReader.next();

                    try
                    {
                        opSuccess = DwareDriver.buildWordKey(wKey, wordFile);
                    }
                    catch (IOException | IndexOutOfBoundsException | NumberFormatException ex)
                    {
                        ex.printStackTrace();
                    }

                    if(opSuccess)
                    {
                        tCLI.setWordFile(wordFile);
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
