# WordGame.WordGame


  ### Purpose and Scope

This is a game using terms from the "ISTQB Software Testing Glossary" published by ISTQB. The aim is to master software testing terms, prepare for the ISTQB exam, have fun and try to detect bugs by looking at the software written with the eyes of a tester.

  ### Features of the game

**1-)**	When you run the program, the first thing you will see in the console is the ISTQB dictionary definition of the term you are trying to guess. 

    〉〉〉 Explanation :
    " The behavior produced/observed when a component or system is tested." 

**2-)**	Under the explanation section, there will be an expression showing how many words the term you are looking for consists of. 

    〉〉〉The term you have to guess has 2 words:

**3-)**	Just below the word count section, you will see the masked version of the term you need to guess with the asterisk code.

    ****** ******

**4-)**	Then the information message will appear where you will start guessing the letters to find the hidden term.

    〉〉〉Now, you will try to find the term by guessing the letters.🤔

  Just below, you will see a reminder that you can use your  hint only one time.  Yes, you can indeed use one time  hint in the game. If you type "hint" in the field where you will write your guess, you will see that a letter will be opened as many times as the number it contains.
 
    〉〉〉 DON'T FORGET, you can use hint once by typing "hint".

  And then, you will then see an information note about how many times you can guess incorrectly.

    〉〉〉 You can guess 6 times incorrectly.

   Depending on the number of different letters in the term you are trying to guess, the number of incorrect guesses will change. 5 for some terms, 6 for some, and 7 for some.
   If the term contains many different letters, your chances of guessing correctly will increase. Therefore, you will have less right to make incorrect guesses.(min 5)
   If the term contains fewer different letters, you will have less chances to guess correctly. Therefore, you will have more right to make incorrect guesses.(max 7)

**5-)**	Then you will be asked to enter your prediction. You can uppercase or lowercase your prediction.

    ⌲⌲⌲Please enter your letter guess:


**6-)**	For example, suppose your first guess is the letter "a" and it is correct. You will see the following output in the console.

    CORRECT GUESS 👍🏻 
    a***a*   ******
    ⍄ Number of hints remaining : 1
    ⍄ Number of incorrect guesses remaining: 6

   You will see that the letter you guessed correctly appears in the masked view and the remaining number of incorrect guesses remains unchanged.


**7-)**	For example, let's say your next guess is the letter "b" and is incorrect. You will see the following output in the console.

    Incorrect Guess 👎🏻 
    a***a*   ******
    ⍄ Number of hints remaining : 1
    ⍄ Number of incorrect guesses remaining: 5 

   You will see that there is no change in the masked view and the number of false predictions remaining has decreased by one.

**8-)**	If you retype a letter you have already typed, you will see a warning message like the one below. And this mistake does not reduce your number of incorrect guesses remaining.

    !!! You have used this letter before 🤭!!! 
    Number of incorrect guesses remaining: 5   

**9-)**	If you make an incorrect entry, you will see a warning message like the one below. (enter a number or special character / enter multiple characters / enter without English alphabet) And this mistake does not reduce your number of incorrect guesses remaining.

     !!! Incorrect entry. Please try again 🫤
      Number of incorrect guesses remaining: 5  

**10-)** Right to hint. You are only allowed to use hint 1 time. If you type "hint" in the letter guess field, you will see that all the elements of a letter in the term are opened.

    ⌲⌲⌲ Please enter your letter guess: hint
    CORRECT GUESS 👍🏻
    ac**a*   ******
    ⍄ Number of hints remaining : 0
    ⍄ Number of incorrect guesses remaining: 5

**11)** Then, if you type "hint" one more time, you will see the following message.

    ⌲⌲⌲  Please enter your letter guess: hint
    !!! Incorrect entry. Please try again 🫤
    Number of incorrect guesses remaining: 5  


**12-)**	If you find the correct answer before you run out of number of incorrect guesses, you will see a message similar to the one below.

		🎖🏅🎖🥇🎖 CONGRATULATIONS 🎖🏅🎖🥇🎖

    …:. actual result
    The behavior produced/observed when a component or system is tested.

**13-)**	If you run out of number of incorrect guesses and you cannot find the correct answer, you will see a message similar to the one below.

  		  ❌❌😢❌❌ YOU FAILED ❌❌😢❌❌

    searched term: actual result
    The behavior produced/observed when a component or system is tested.





