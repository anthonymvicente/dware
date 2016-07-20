#dware
Dev: Anthony Vicente

dware is a project to allow users to create [Diceware](http://world.std.com/~reinhold/diceware.html) style passwords with ease.

####Versions

- [x] v1.0 - Command Line Interface

    The first iteration of the dware project. The CLI exists to create a front end to test back end structures and models.

- [ ] v2.0 - Graphical User Interface

    Once the back end has been tested and found working, a front end graphical client will be created. This will be used to make dware more accessible to users.

- [ ] v3.0 - Android Application

    The final goal of the dware project will be an Android application to allow users to create passwords on the go.

####Installation

coming soon...

####Usage

######v1.0 - CLI

   1. Load Word File
   You will need to enter the filepath to the Word File you'd like to use for generating passwords. It's recommended you use the [official Diceware list](http://world.std.com/~reinhold/diceware.wordlist.asc) (be sure to remove the PGP signature text at the top and bottom of the list). However, if you wish to use a custom file, the expected format is below:

        #####[tab]word

   2. Choose Number of Words
   Specify how many words you'd like your password to be. You will need at least one, though generally the more the better.
   
   3. Choose Separators
   If you'd like your password to be made up of more than just words (which is recommended), you can use separators to achieve this. You can choose any one or more of the options to vary the possible separators between words in your password. The options are shown below, and selecting them makes them available for random selection during password generation.

        Digits - 0 1 2 3 4 5 6 7 8 9
        Special - ` ~ ! @ # $ % ^ & * ' " ? . , \ / - _ |
        Brackets - ( ) [ ] { } < >

   4. Generate Password
   Once you're satisfied with your selected options, it's time to generate your password. Choosing this action will create a password and return you to the Generate Password menu, with your password appearing under the 'Generated Password:' field.


####TODO

######v1.0 - CLI

- [ ] Add 'Exit' command when specifying Word File path

- [ ] Implement configuration file

######v2.0 - GUI

- [ ] Implement

######v3.0 - Android App

- [ ] Implement
