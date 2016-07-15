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

        boolean userExit = false;

        Scanner inputReader = new Scanner(System.in);
        WordKey wKey = new WordKey();

        while(!userExit)
        {
            tCLI.displayMenu(Menu.MAIN, inputReader);

            switch(tCLI.getChoice(Menu.MAIN))
            {
                case 0:
                    userExit = true;
                    break;
                case 1:
                    String wordFile;
                    wordFile = tCLI.wordFileLoad(inputReader);

                    try
                    {
                        DwareDriver.buildWordKey(wKey, wordFile);
                    }
                    catch (IOException | IndexOutOfBoundsException | NumberFormatException ex)
                    {
                        // TODO - this should show an error and reset for continued use.
                        ex.printStackTrace();
                    }

                    tCLI.setWordFile(wordFile);
                    break;
                case 2:
                    break;
                default:
                    break;
            }
        }
    }
}
