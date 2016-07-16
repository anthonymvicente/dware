package com.mvicente.dware.main;

import com.mvicente.dware.drivers.DwareDriver;
import com.mvicente.dware.utils.CLI;
import com.mvicente.dware.utils.Menu;
import com.mvicente.dware.utils.WordKey;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    {
        CLI tCLI = new CLI();

        boolean userExit = false;
        boolean userReturn = false;

        Random generator = new SecureRandom();

        DwareDriver driver = new DwareDriver(generator);

        Scanner inputReader = new Scanner(System.in);

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
                        driver.buildWordKey(wordFile);
                    }
                    catch (IOException | IndexOutOfBoundsException | NumberFormatException ex)
                    {
                        // TODO - this should show an error and reset for continued use.
                        ex.printStackTrace();
                    }

                    tCLI.setWordFile(wordFile);
                    break;
                case 2:
                    while(!userReturn)
                    {
                        tCLI.displayMenu(Menu.GEN, inputReader);

                        switch (tCLI.getChoice(Menu.GEN))
                        {
                            case 0:
                                userReturn = true;
                                break;
                            case 1:
                                tCLI.chooseNumWords(inputReader);
                                break;
                            case 2:
                                tCLI.chooseSeparators(inputReader);
                                break;
                        }
                    }
                    userReturn = false;
                    break;
                default:
                    break;
            }
        }
    }
}
