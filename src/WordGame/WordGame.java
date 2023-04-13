package WordGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordGame {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String RED_BRIGHT = "\033[0;91m";
    public static final String GREEN_BRIGHT = "\033[0;92m";
    public static final String GREEN_BOLD = "\033[1;32m";
    public static final String RED_BOLD = "\033[1;31m";

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {

        Scanner scan = new Scanner(System.in);

/////////////////////////////// pull words from file and add to list ////////////////////////////////////////////////

        File file = new File("wordList.txt");

        Scanner sc = new Scanner(file);

        ArrayList<String> terms = new ArrayList<>();

        while (sc.hasNextLine()) {
            terms.add(sc.nextLine());
        }

//////////////////// Randomly selecting word from the file & Separating the word and its meaning /////////////////////

        Random rand = new Random();
        String str = terms.get(rand.nextInt(terms.size()));
        String[] searchTerm = str.split(":");
        String secretWord = searchTerm[0];

        int MaxNumOfIncorrectGuess = maxNumOfIncorrectGuess(secretWord);

////////////////// The FIRST INFORMATIONS that will appear in the console when the program is run ///////////////////

        ArrayList<Character> guessList = new ArrayList<>(); // The list to store the prediction letters we make

        //// for long explanations to fit in the console /////

        String[] explanationParts = searchTerm[1].split("#");
        System.err.println("〉〉〉 Explanation :");
        Thread.sleep(250);
        for (String s : explanationParts) {
            System.out.println("\033[0;1m" + s);  //  "\033[0;1m"  --> for bold
        }

        System.out.println("\n〉〉〉 The term you have to guess has " + numberOfWord(secretWord) +
                " words: \n\t\t\t" + maskWord(secretWord, guessList));
        System.out.println("\n〉〉〉 Now, you will try to find the term by guessing the letters.🤔");
        System.out.println("〉〉〉 DON'T FORGET, you can use hint once by typing \"hint\".");
        System.out.println("〉〉〉 You can guess " + MaxNumOfIncorrectGuess + " TIMES incorrectly.");

///////////////////////////////////////////  Main operations  /////////////////////////////////////////////////////
        int hintCount = 0;                          //  For one time use hint
        while (MaxNumOfIncorrectGuess != 0) {
            String guess;
            do {

                System.out.print("\n⌲⌲⌲ Please enter your letter guess: ");

                guess = scan.nextLine();

                guess = guess.toLowerCase();   // if the entry is made with a capital letter

                //////////////  one time to use a hint  ///////////////

                if (hintCount == 0 && guess.equals("hint")) {
                    for (int i = 0; i < secretWord.length(); i++) {
                        if (!guessList.contains(secretWord.charAt(i))) {
                            guess = secretWord.charAt(i) + "";
                            hintCount++;
                            break;
                        }
                    }
                }

                /////// incorrect entry (numbers, special characters and non-english letters) and re-entry part ///////

                if (guess.length() > 1 || !(guess.charAt(0) >= 65 && guess.charAt(0) <= 90) &&
                        !(guess.charAt(0) >= 97 && guess.charAt(0) <= 122)) {
                    System.out.println("!!! Incorrect entry. Please try again 🫤");
                    System.out.println("Number of incorrect guesses remaining: " + MaxNumOfIncorrectGuess);
                }
                if (guessList.contains(guess.charAt(0)) && guess.length() == 1) {
                    System.out.println("!!! You have used this letter before 🤭!!!");
                    System.out.println("Number of incorrect guesses remaining: " + MaxNumOfIncorrectGuess);
                }
            } while (!(guess.charAt(0) > 64 && guess.charAt(0) < 91) && !(guess.charAt(0) > 96 && guess.charAt(0) < 123)
                    || guess.length() > 1 || guessList.contains(guess.charAt(0)));

            guessList.add(guess.charAt(0));

            if (!secretWord.contains(guess)) {
                MaxNumOfIncorrectGuess--;
            }
            Thread.sleep(1000);

            if (secretWord.contains(guess)) {
                System.out.println(GREEN_BRIGHT + "\tCORRECT GUESS 👍🏻" + ANSI_RESET);
            } else {
                System.err.println(RED_BRIGHT + "\tIncorrect Guess 👎🏻" + ANSI_RESET);
            }
            Thread.sleep(100);
            String guessWord = maskWord(secretWord, guessList);

            System.out.println("\t" + guessWord);
            Thread.sleep(100);

            //////////////////////// result part //////////////////////

            if (guessWord.equals(secretWord)) {

                System.out.println(GREEN_BOLD + "\n\t\t 🎖🏅🎖🥇🎖 CONGRATULATIONS 🎖🏅🎖🥇🎖\n" + ANSI_RESET);
                System.out.println("\033[0;1m" + "...:. " + secretWord);
                for (String s : explanationParts) {                   // for long explanations to fit in the console
                    System.out.println(s);
                }
                break;

            }
            if (MaxNumOfIncorrectGuess == 0) {
                System.out.println(RED_BOLD + "\n\t\t  ❌❌😢❌❌ YOU FAILED ❌❌😢❌❌\n" + ANSI_RESET);
                System.out.println("\033[0;1m" + "searched term: " + secretWord);
                for (String s : explanationParts) {                   // for long explanations to fit in the console
                    System.out.println(s);
                }
                break;
            }

            if (hintCount == 0) {
                System.out.println("    ⍄ Number of hints remaining : 1");
            } else {
                System.out.println("    ⍄ Number of hint remaining : 0");
            }

            System.out.println("    ⍄ Number of incorrect guesses remaining: " + (MaxNumOfIncorrectGuess));
            System.out.println();
        }
    }

    ///////////////////////////////// make the searched word appear masked////////////////////////////////////
    public static String maskWord(String secretWord, ArrayList<Character> guessList) {

        String result = "";

        for (int i = 0; i < secretWord.length(); i++) {
            char ch = secretWord.charAt(i);
            if (ch == ' ') {
                result = result.concat(" ");
            } else if (ch == '-') {
                result = result.concat("-");
            } else if (guessList.contains(ch)) {
                result = result.concat(ch + "");
            } else {
                result = result.concat("*");
            }
        }
        return result;
    }

    //////////////////////////// information on the number of words in the FIRST INFORMATIONS /////////////////////////
    public static int numberOfWord(String word) {

        int count = 0;
        if (word.contains(" ") || word.contains("-")) {             // if there is only one word, for performancing
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == ' ' || word.charAt(i) == '-') {
                    count++;
                }
            }
        }
        return count + 1;
    }

    /////////////// the right to guess wrong according to the number of different letters it contains /////////////////
    public static int maxNumOfIncorrectGuess(String word) {
        String str = "";
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (word.indexOf(ch) == i) {
                str += ch;
            }
        }

        if (str.length() > 13) {
            return 5;
        } else if (str.length() > 7) {
            return 6;
        } else {
            return 7;
        }
    }
}