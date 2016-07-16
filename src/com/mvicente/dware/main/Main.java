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

            tCLI.printBlanks(3);

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
                    catch(IndexOutOfBoundsException | NumberFormatException ex)
                    {
                        tCLI.displayGeneralError("The word file you chose is improperly formatted.");
                        wordFile = "(none)";
                    }
                    catch(IOException ex)
                    {
                       tCLI.displayGeneralError("There was an error reading your chosen word file. Please ensure the file path is correct:\n" + wordFile);
                        wordFile = "(none)";
                    }

                    tCLI.setWordFile(wordFile);
                    tCLI.printBlanks(3);
                    break;
                case 2:
                    if(tCLI.getWordFile().equals("(none)"))
                    {
                        tCLI.displayGeneralError("Please load a word file before attempting to generate a password.");
                    }
                    else
                    {
                        while (!userReturn)
                        {
                            tCLI.displayMenu(Menu.GEN, inputReader);

                            tCLI.printBlanks(3);

                            switch (tCLI.getChoice(Menu.GEN))
                            {
                                case 0:
                                    tCLI.resetPasswordSettings();
                                    userReturn = true;
                                    break;
                                case 1:
                                    tCLI.chooseNumWords(inputReader);
                                    tCLI.printBlanks(3);
                                    break;
                                case 2:
                                    tCLI.chooseSeparators(inputReader);
                                    tCLI.printBlanks(3);
                                    break;
                                case 3:
                                    int numWords;
                                    numWords = tCLI.getNumWords();
                                    if(numWords < 1)
                                    {
                                        tCLI.displayGeneralError("Please specify the number of words you'd like your password to contain.");
                                    }
                                    else
                                    {
                                        boolean digitFlag, specialFlag, bracketFlag;
                                        String password;

                                        digitFlag = tCLI.getPoolFlags()[0];
                                        specialFlag = tCLI.getPoolFlags()[1];
                                        bracketFlag = tCLI.getPoolFlags()[2];

                                        driver.buildSeparatorPool(digitFlag, specialFlag, bracketFlag);

                                        password = driver.generatePassword(numWords);

                                        tCLI.setCurrentPassword(password);
                                    }

                                    break;
                            }
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
